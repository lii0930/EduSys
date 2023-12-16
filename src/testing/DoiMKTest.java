package testing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import edusys.DoiMK;

public class DoiMKTest {

    private DoiMK doiMK;

    @BeforeClass
    public void setUp() {
        doiMK = new DoiMK();
        doiMK.setVisible(true);
    }
    @AfterClass
    public void Teardown() {
    	doiMK.dispose();
    }
    
    @Test(priority = 3)
    public void testDoiMatKhauHopLe() {
    	doiMK.txtMaNV.setText("TeoNV");
        doiMK.txtMatKhau.setText("1234");
        doiMK.txtMatKhauMoi.setText("123");
        doiMK.txtMatKhauMoi2.setText("123");
        doiMK.doiMatKhau();

    }

    @Test(priority = 1)
    public void testDoiMatKhauSaiMK() {
    	doiMK.txtMaNV.setText("TeoNV");
        doiMK.txtMatKhau.setText("111");
        doiMK.txtMatKhauMoi.setText("1234");
        doiMK.txtMatKhauMoi2.setText("1234");
        doiMK.doiMatKhau();
    }

    @Test(priority = 2)
    public void testDoiMatKhauKhongKhop() {
    	doiMK.txtMaNV.setText("TeoNV");
        doiMK.txtMatKhau.setText("123");
        doiMK.txtMatKhauMoi.setText("123");
        doiMK.txtMatKhauMoi2.setText("1234");
        doiMK.doiMatKhau();
    }
}
