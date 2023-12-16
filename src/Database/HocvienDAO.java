/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.Hocvien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uynph
 */
public class HocvienDAO extends EduSysDAO<Hocvien, Integer>{

    public void insert(Hocvien model){
        String sql="INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
        JDBC.update(sql, 
                model.getMaKH(), 
                model.getMaNH(), 
                model.getDiem());
    }
    
    public void update(Hocvien model){
        String sql="UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
        JDBC.update(sql, 
                model.getMaKH(), 
                model.getMaNH(), 
                model.getDiem(), 
                model.getMaHV());
    }
    
    public void delete(Integer MaHV){
        String sql="DELETE FROM HocVien WHERE MaHV=?";
        JDBC.update(sql, MaHV);
    }
    
    public List<Hocvien> selectAll(){
        String sql="SELECT * FROM HocVien";
        return selectBySql(sql);
    }
    
    public Hocvien selectById(Integer mahv){
        String sql="SELECT * FROM HocVien WHERE MaHV=?";
        List<Hocvien> list = selectBySql(sql, mahv);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<Hocvien> selectBySql(String sql, Object...args){
        List<Hocvien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBC.query(sql, args);
                while(rs.next()){
                    Hocvien entity=new Hocvien();
                    entity.setMaHV(rs.getInt("MaHV"));
                    entity.setMaKH(rs.getInt("MaKH"));
                    entity.setMaNH(rs.getString("MaNH"));
                    entity.setDiem(rs.getDouble("Diem"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Hocvien> selectByKhoaHoc(int maKH) {
        String sql="SELECT * FROM HocVien WHERE MaKH=?";
        return this.selectBySql(sql, maKH);
    }
}
