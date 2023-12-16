package test.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SheetWriter {
	private File file;
	private String fileName;
	private List<String> sheetNames;
	private int activeSheet;
	private Workbook workbook;
	private String fileExtension;
	
	public SheetWriter(File file) throws IOException{
		this.file = file;
		workbook = WorkbookFactory.create(file);
	}
	
	public SheetWriter(String fileName) {
		boolean isFileValid = validateFileName(fileName);
		if(!isFileValid) {
			throw new IllegalArgumentException(fileName + " does not include a supported extension by Excel.");
		} else {
			this.fileName = fileName;
		}
	}
	
	private boolean validateFileName(String name) {
		String[] validExtensions = {
				"xl", "xlsx", "xlsm", "xlsb", "xlam", "xltx", "xltm",
				"xls", "xlt", "htm", "html", "mht", "mhtml", "xml",
				"xla", "xlm", "xlw", "odc", "ods"
		};
		int indexOfExtension = name.lastIndexOf(".");
		if(indexOfExtension == -1) {
			return false;
		}
		String extension = name.substring(indexOfExtension+1);
		for(int i = 0; i < validExtensions.length; i++) {
			if(extension.equals(validExtensions[i])) {
				this.fileExtension = validExtensions[i];
				return true;
			}
		}
		return false;
	}
}
