package testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Database.ChuyendeDAO;
import Models.Chuyende;

public class ChuyendeDAOTest {
    private static ChuyendeDAO chuyendeDAO;

    @BeforeClass
    public void setUp() {
        chuyendeDAO = new ChuyendeDAO();
    }

    @DataProvider(name = "validData")
    public Object[][] validData() {
        return new Object[][] {
            { "CD-001", "ChuyenDe1", 1000.0, 30, "image1.jpg", "Mo ta cho chuyen de 1" },
            { "CD-002", "ChuyenDe2", 1500.0, 25, "image2.jpg", "Mo ta cho chuyen de 2" },
            { "CD-003", "ChuyenDe3", 800.0, 20, "image3.jpg", "Mo ta cho chuyen de 3" },
        };
    }

    @DataProvider(name = "nullData")
    public Object[][] nullData() {
        return new Object[][] {
            { "", "", 0.0, 0, "", "" },
        };
    }

    @Test(dataProvider = "validData", description = "InsertValid")
    public void testInserHopLe(String maCD, String tenCD, double hocPhi, int thoiLuong, String hinh, String moTa) {
        Chuyende model = new Chuyende();
        model.setMaCD(maCD);
        model.setTenCD(tenCD);
        model.setHocPhi(hocPhi);
        model.setThoiLuong(thoiLuong);
        model.setHinh(hinh);
        model.setMoTa(moTa);

        chuyendeDAO.insert(model);
    }

    @Test(dataProvider = "nullData", description = "InsertNull", expectedExceptions = {Exception.class}, priority = 1)
    public void testInsertNULL(String maCD, String tenCD, double hocPhi, int thoiLuong, String hinh, String moTa) throws Exception {
        Chuyende model = new Chuyende();
        model.setMaCD(maCD);
        model.setTenCD(tenCD);
        model.setHocPhi(hocPhi);
        model.setThoiLuong(thoiLuong);
        model.setHinh(hinh);
        model.setMoTa(moTa);

        chuyendeDAO.insert(model);
    }

    @Test(dataProvider = "validData", description = "UpdateValid", priority = 2)
    public void testUpdateHopLe(String maCD, String tenCD, double hocPhi, int thoiLuong, String hinh, String moTa) {
        Chuyende model = new Chuyende();
        model.setMaCD(maCD);
        model.setTenCD(tenCD);
        model.setHocPhi(hocPhi);
        model.setThoiLuong(thoiLuong);
        model.setHinh(hinh);
        model.setMoTa(moTa);

        chuyendeDAO.update(model);
    }

    @Test(dataProvider = "nullData", description = "UpdateNull", priority = 3)
    public void testUpdateNull(String maCD, String tenCD, double hocPhi, int thoiLuong, String hinh, String moTa) throws Exception {
        Chuyende model = new Chuyende();
        model.setMaCD(maCD);
        model.setTenCD(tenCD);
        model.setHocPhi(hocPhi);
        model.setThoiLuong(thoiLuong);
        model.setHinh(hinh);
        model.setMoTa(moTa);

        chuyendeDAO.update(model);
    }

    @Test(dataProvider = "validData", description = "DeleteValid", priority = 4)
    public void testDeleteHopLe(String maCD) {
        chuyendeDAO.delete(maCD);
    }

    @Test(dataProvider = "nullData", description = "DeleteNull", priority = 5)
    public void testDeleteNull(String maCD) throws Exception {
        chuyendeDAO.delete(maCD);
    }

    @Test(description = "SelectAll", priority = 6)
    public void testSelectAll() {
        List<Chuyende> list = chuyendeDAO.selectAll();
    }

    @Test(description = "SelectById", priority = 7)
    public void testSelectById() {
        String maCD = "CD-001";
        Chuyende model = chuyendeDAO.selectById(maCD);
        assertNotNull(model);
    }

    @Test(description = "SelectByIdNotFound", priority = 8)
    public void testSelectByIdNotFound() {
        String maCD = "NonExistentCD";
        Chuyende model = chuyendeDAO.selectById(maCD);
        assertNull(model);
    }
}
