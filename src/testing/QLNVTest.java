package testing;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.FirstCharBasedValidator;

import Models.Nhanvien;
import edusys.Login;
import edusys.QLNV;



public class QLNVTest {
	QLNV qlnv;

    @BeforeClass
    public void setUp() {
        qlnv=new QLNV();
        qlnv.setVisible(true);
    }

    @AfterClass
    public void tearDown() {
        qlnv.dispose();
    }
    @Test (priority = 1)
    public void testInsert() {
        
        // Set form data
        qlnv.txtMaNV.setText("NV100");
        qlnv.txtHoTen.setText("John Doe");
        qlnv.txtMatKhau.setText("password");
        qlnv.txtMatKhau2.setText("password");
        qlnv.rdoTruongPhong.setSelected(true);

        qlnv.insert();
    }
    
    @Test (priority = 2)
    public void testInsertTrungMNV() {
        Nhanvien nv = new Nhanvien();
        
        // Set form data
        qlnv.txtMaNV.setText("NV100");
        qlnv.txtHoTen.setText("John Doe");
        qlnv.txtMatKhau.setText("password");
        qlnv.txtMatKhau2.setText("password");
        qlnv.rdoTruongPhong.setSelected(true);

        qlnv.insert();
    }
    
    @Test (priority = 3)
    public void testInsertNULL() {
        Nhanvien nv = new Nhanvien();
        
        qlnv.txtMaNV.setText("");
        qlnv.txtHoTen.setText("");
        qlnv.txtMatKhau.setText("");
        qlnv.txtMatKhau2.setText("");
        qlnv.rdoTruongPhong.setSelected(true);

        qlnv.insert();
    }

    @Test(priority = 3)
    public void testUpdate() {
        qlnv.txtMaNV.setText("NV100");
        qlnv.txtHoTen.setText("John Doe");
        qlnv.txtMatKhau.setText("newpassword");
        qlnv.txtMatKhau2.setText("newpassword");
        qlnv.rdoTruongPhong.setSelected(true);
        qlnv.update();
    }
    @Test(priority = 4)
    public void testUpdateNULL() {
        qlnv.txtMaNV.setText("");
        qlnv.txtHoTen.setText("");
        qlnv.txtMatKhau.setText("");
        qlnv.txtMatKhau2.setText("");
        qlnv.rdoTruongPhong.setSelected(true);
        qlnv.update();
    }
    @Test(priority = 5)
    public void testUpdateMNVKOTT() {
        qlnv.txtMaNV.setText("liiiiii");
        qlnv.txtHoTen.setText("John Doe");
        qlnv.txtMatKhau.setText("newpassword");
        qlnv.txtMatKhau2.setText("newpassword");
        qlnv.rdoTruongPhong.setSelected(true);
        qlnv.update();
    }

    @Test(priority = 6)
    public void testDelete() {
        qlnv.txtMaNV.setText("NV100");

        qlnv.delete();

    }
    
    @Test(priority = 7)
    public void testDeleteNull() {
        qlnv.txtMaNV.setText("");
        qlnv.delete();

    }
    @Test(priority = 8)
    public void testDeleteMNVKOTT() {
        qlnv.txtMaNV.setText("asmkt");

        qlnv.delete();

    }
    
    @Test(priority = 9)
    public void testDeleteLogin() {
    	Login lg=new Login();
    	lg.txtMaNV.setText("TeoNV");
        lg.txtMatKhau.setText("123");
        lg.dangNhap();
        qlnv.setVisible(true);
        qlnv.txtMaNV.setText("NV100");
        qlnv.delete();
    }
    
}
