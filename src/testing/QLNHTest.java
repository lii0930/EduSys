package testing;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Models.Nguoihoc;
import edusys.Login;
import edusys.QLNH;

import javax.swing.*;
import java.util.Date;

import static org.testng.Assert.*;

public class QLNHTest {

   public QLNH qlnh;
   public Nguoihoc nh;

    @BeforeTest
    public void setUp() {
    	Login lg=new Login();
    	lg.txtMaNV.setText("TeoNV");
        lg.txtMatKhau.setText("123");
        lg.dangNhap();
        qlnh=new QLNH();
        qlnh.setVisible(true);
    }
    @AfterTest
    public void tearDown() {
    	 qlnh.dispose();
    }
    
    @Test(priority = 1)
    public void testInsert() {
    	qlnh.txtMaNH.setText("PS25485");
    	qlnh.txtDienThoai.setText("0328547858");
    	qlnh.txtEmail.setText("phuong@gmail.com");
    	qlnh.txtGhiChu.setText("Vừa đăng ký");
    	qlnh.txtHoTen.setText("Phùng Lê Uyên Phương");
    	qlnh.txtNgaySinh.setText("01-05-2003");
        qlnh.insert();

    }
    @Test(priority = 2)
    public void testInsertTrungMNH() {
    	qlnh.txtMaNH.setText("PS25485");
    	qlnh.txtDienThoai.setText("0328547858");
    	qlnh.txtEmail.setText("phuong@gmail.com");
    	qlnh.txtGhiChu.setText("Vừa đăng ký");
    	qlnh.txtHoTen.setText("Phùng Lê Uyên Phương");
    	qlnh.txtNgaySinh.setText("01-05-2003");
        qlnh.insert();

    }
    @Test(priority = 3)
    public void testInsertNull() {
    	qlnh.txtMaNH.setText("");
    	qlnh.txtDienThoai.setText("");
    	qlnh.txtEmail.setText("");
    	qlnh.txtGhiChu.setText("");
    	qlnh.txtHoTen.setText("");
    	qlnh.txtNgaySinh.setText("");
        qlnh.insert();
       
    }

    @Test(priority = 4)
    public void testUpdate() {
    	qlnh.txtMaNH.setText("PS25485");
    	qlnh.txtDienThoai.setText("0328547858");
    	qlnh.txtEmail.setText("phuong@gmail.com");
    	qlnh.txtGhiChu.setText("Đã đăng ký");
    	qlnh.txtHoTen.setText("Phùng Lê Uyên Phương");
    	qlnh.txtNgaySinh.setText("01-05-2000");
        qlnh.update();
    }

    @Test(priority = 5)
    public void testUpdateNull() {
    	qlnh.txtMaNH.setText("");
    	qlnh.txtDienThoai.setText("");
    	qlnh.txtEmail.setText("");
    	qlnh.txtGhiChu.setText("");
    	qlnh.txtHoTen.setText("");
    	qlnh.txtNgaySinh.setText("");
        qlnh.update();
    }

    @Test(priority = 6)
    public void testDelete() {
    	qlnh.txtMaNH.setText("PS25485");
        qlnh.delete();
    }

    @Test(priority = 7)
    public void testDeleteLoi() {
    	qlnh.txtMaNH.setText("123");
        qlnh.delete();
    }
    @Test(priority = 8)
    public void testFindingKhongtontai() {
    	qlnh.txtTimKiem.setText("PS02037");
        qlnh.timKiem();
    }
    @Test(priority = 9)
    public void testFindingNull() {
    	qlnh.txtTimKiem.setText("");
        qlnh.timKiem();
    }
    @Test(priority = 10)
    public void testFinding() {
    	qlnh.txtTimKiem.setText("LỮ HUY CƯỜNG");
        qlnh.timKiem();
    }

}
