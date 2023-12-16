package test.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SheetDataProvider {
	private String dataSeperator;
	private File file;
	
	public SheetDataProvider(File file) {
		this("\n", file);
	}
	
	public SheetDataProvider(String seperator, File file) {
		this.dataSeperator = seperator;
		this.file = file;
	}
	
	public String[][] getData(String worksheetName, String rowName, int dataCount) throws IOException{
		Sheet sheet = getWorksheet(file, worksheetName);
		if(sheet != null) {
			int[] indices = getRowAndColumnIndex(sheet, rowName);
			if(indices != null) {
				Row row = sheet.getRow(indices[0]);
				String[][] data;
				List<Integer> validCells = getValidCells(row, indices[1]);
				data = new String[validCells.size()][dataCount];
				for(int i = 0; i < validCells.size(); i++) {
					String[] splitData = row.getCell(validCells.get(i)).getStringCellValue().split(this.dataSeperator);
					if(splitData.length > data[i].length) 
						throw new IllegalArgumentException("In worksheet \'" + worksheetName + "\'" + ", at row \'" + rowName + "\'" 
								+ "\nColumn " + (validCells.get(i)+1) + " has " + (splitData.length- data[i].length) + " more parameter(s) than declared.\n" +
								"Number of parameter should be: " + dataCount);
					for(int j = 0; j < dataCount; j++) {
						try {
							data[i][j] = splitData[j];
						} catch (IndexOutOfBoundsException e) {
							data[i][j] = "";
						}
					}
				}
				return data;
			} 
			else return null;
		} 
		else throw new RuntimeException("Worksheet not found with provided name: " + worksheetName);
	}
	
	private List<Integer> getValidCells(Row row, int index){
		List<Integer> validCells = new ArrayList<>();
		for(int i = 0; i < row.getLastCellNum()-1; i++) {
			if(row.getCell(index) == null || 
					row.getCell(index).getStringCellValue().isEmpty()) {
				index++;
				continue;
			}
			validCells.add(index++);
		}
		return validCells;
	}
	
	private Sheet getWorksheet(File file, String worksheetName) throws IOException{
		try(Workbook workbook = WorkbookFactory.create(file)) {
			Sheet sheet = workbook.getSheet(worksheetName);
			return sheet;
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			if(e.getMessage().contains("being used by another process")) {
				throw new RuntimeException("The file " + file.toString() + " is being used/opened, please close it first.");
			}
			throw new RuntimeException(e);
		}
	}
	
	private int[] getRowAndColumnIndex(Sheet sheet, String rowName) {
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(cell.getStringCellValue().equalsIgnoreCase(rowName)) {
					int[] indices = {row.getRowNum(), cell.getColumnIndex()+1};
					return indices;
				}
			}
		}
		return null;
	}

	public String getDataSeperator() {
		return dataSeperator;
	}

	public void setDataSeperator(String dataSeperator) {
		this.dataSeperator = dataSeperator;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
