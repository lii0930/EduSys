package testing;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Database.NhanviienDAO;
import Models.Nhanvien;


public class NhanVienDAOTest {
	private static NhanviienDAO NhanviienDAO;
	private File file;
	private Nhanvien model;
	String maNV = "NV001";
    String matKhau = "password";
    String hoTen = "John Doe";
    String vaiTro = "true";
	@BeforeClass
	public void setUp()  {
		NhanviienDAO = new NhanviienDAO();
		model = new Nhanvien();
	}
	
	@Test(description  = "InsertValid")
	public void testInsertHopLe() {	
		model.setMaNV(maNV);
		model.setMatKhau(matKhau);
		model.setHoTen(hoTen);
		model.setVaiTro(Boolean.valueOf(vaiTro));
		NhanviienDAO.insert(model);
		System.out.println("Thêm thành công");
	}

	@Test(description = "InsertNull", expectedExceptions = {Exception.class}, priority = 1)
	public void testInsertNull() throws Exception {
		model.setMaNV("");
		model.setMatKhau("");
		model.setHoTen("");
		model.setVaiTro(Boolean.valueOf(""));
		NhanviienDAO.insert(model);
		System.out.println("Thêm thất bại");
	}
	
	@Test(description = "UpdateValid" , priority = 2)
	public void testUpdateHopLe() {	
		model.setMaNV(maNV);
		model.setMatKhau(matKhau);
		model.setHoTen(hoTen);
		model.setVaiTro(Boolean.valueOf(vaiTro));
		NhanviienDAO.update(model);
		System.out.println("Sửa thành công");
	}


	@Test(description = "UpdateNull",priority = 3)
	public void testUpdateNull() throws Exception {
		model.setMaNV("");
		model.setMatKhau("");
		model.setHoTen("");
		model.setVaiTro(Boolean.valueOf(""));
		NhanviienDAO.update(model);
		System.out.println("Sửa thất bại");
	}
	
	@Test(description = "DeleteValid",priority = 4)
	public void testDeleteHopLe() {	
		NhanviienDAO.delete(maNV);
		System.out.println("Xóa thành công");
	}


	@Test(description = "DeleteNull", priority = 5)
	public void testDeleteNull() throws Exception {
		NhanviienDAO.delete("");
		System.out.println("Xóa thất bại");
	}
}