package testing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import edusys.Login;

public class LoginTest {
    private Login login;

    @BeforeClass
    public void setUp() {
        login = new Login();
        login.setVisible(true);
    }

    @AfterClass
    public void tearDown() {
        login.dispose();
    }

    @Test(priority = 3)
    public void testDangNhapHopLe() {
        login.txtMaNV.setText("TeoNV");
        login.txtMatKhau.setText("123");

        login.dangNhap();
    }

    @Test(priority = 2)
    public void testDangNhapSai() {
        login.txtMaNV.setText("hehe");
        login.txtMatKhau.setText("haha");

        login.dangNhap();

    }

    @Test(priority = 1)
    public void testDangNhapNULL() {
        login.txtMaNV.setText("");
        login.txtMatKhau.setText("");

        login.dangNhap();

        
    }
}
