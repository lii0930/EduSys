package testing;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Database.NguoihocDAO;
import Khac.XDate;
import Models.Nguoihoc;


public class NguoihocDAOTest {
	private static NguoihocDAO NhanviienDAO;
	private static Nguoihoc model;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	@BeforeClass
	public void setUp()  {
		NhanviienDAO = new NguoihocDAO();
		model = new Nguoihoc();
	}
	 @DataProvider(name = "validData")
	    public Object[][] validData() throws ParseException {
	        return new Object[][]{
	                {"nh-01", "UyenPhuong", "09/08/2002", true, "0328645096", "uynphng765@gmail.com", "hehe", "TeoNV", "08/07/2023"},
	                {"nh-02", "UyenPhuong", "09/08/2002", false, "0328645096", "uynphng765@gmail.com", "hehe", "uyenphuong", "08/07/2023"}
	               
	        };
	    }

	    @DataProvider(name = "nullData")
	    public Object[][] nullData() {
	        return new Object[][]{
	                {"", "", "", false, "", "", "", "", ""},
	        };
	    }

	    @Test(dataProvider = "validData", description = "InsertValid")
	    public void testInsertHopLe(String maNH, String hoTen, String ngaySinh, boolean gioiTinh,
	                                         String dienThoai, String email, String ghiChu, String maNV, String ngayDK) throws ParseException {
	        model.setMaNH(maNH);
	        model.setHoTen(hoTen);
	        model.setNgaySinh(dateFormat.parse(ngaySinh));
	        model.setGioiTinh(gioiTinh);
	        model.setDienThoai(dienThoai);
	        model.setEmail(email);
	        model.setGhiChu(ghiChu);
	        model.setMaNV(maNV);
	        model.setNgayDK(dateFormat.parse(ngayDK));
	        NhanviienDAO.insert(model);
	        System.out.println("Thêm thành công");
	    }

	    @Test(dataProvider = "nullData", description = "InsertNull", expectedExceptions = {Exception.class}, priority = 1)
	    public void testInsertNULL(String maNH, String hoTen, String ngaySinh, boolean gioiTinh,
	                                        String dienThoai, String email, String ghiChu, String maNV, String ngayDK) throws Exception {
	        model.setMaNH(maNH);
	        model.setHoTen(hoTen);
	        model.setNgaySinh(dateFormat.parse(ngaySinh));
	        model.setGioiTinh(gioiTinh);
	        model.setDienThoai(dienThoai);
	        model.setEmail(email);
	        model.setGhiChu(ghiChu);
	        model.setMaNV(maNV);
	        model.setNgayDK(dateFormat.parse(ngayDK));
	        NhanviienDAO.insert(model);
	        System.out.println("Thêm thất bại");
	    }
	
	    @Test(dataProvider = "validData", description = "UpdateValid", priority = 2)
	    public void testUpdateHopLe(String maNH, String hoTen, String ngaySinh, boolean gioiTinh,
	                                         String dienThoai, String email, String ghiChu, String maNV, String ngayDK) throws ParseException {
	        model.setMaNH(maNH);
	        model.setHoTen(hoTen);
	        model.setNgaySinh(dateFormat.parse(ngaySinh));
	        model.setGioiTinh(gioiTinh);
	        model.setDienThoai(dienThoai);
	        model.setEmail(email);
	        model.setGhiChu(ghiChu);
	        model.setMaNV(maNV);
	        model.setNgayDK(dateFormat.parse(ngayDK));
	        NhanviienDAO.update(model);
	        System.out.println("Sửa thành công");
	    }

	    @Test(dataProvider = "nullData", description = "UpdateNull", priority = 3)
	    public void testUpdateNULL(String maNH, String hoTen, String ngaySinh, boolean gioiTinh,
	                                        String dienThoai, String email, String ghiChu, String maNV, String ngayDK) throws Exception {
	        model.setMaNH(maNH);
	        model.setHoTen(hoTen);
	        model.setNgaySinh(dateFormat.parse(ngaySinh));
	        model.setGioiTinh(gioiTinh);
	        model.setDienThoai(dienThoai);
	        model.setEmail(email);
	        model.setGhiChu(ghiChu);
	        model.setMaNV(maNV);
	        model.setNgayDK(dateFormat.parse(ngayDK));
	        NhanviienDAO.update(model);
	        System.out.println("Sửa thất bại");
	    }

	    @Test(dataProvider = "validData", description = "DeleteValid", priority = 4)
	    public void testDeleteHopLe(String maNH) throws ParseException {
	        model.setMaNH(maNH);
	        NhanviienDAO.delete(maNH);
	        System.out.println("Xóa thành công");
	    }

	    @Test(dataProvider = "nullData", description = "DeleteNull", priority = 5)
	    public void testDeleteNULL(String maNH) throws Exception {
	    	model.setMaNH(maNH);
	        NhanviienDAO.delete(maNH);
	        System.out.println("Xóa thất bại");
	    }
}