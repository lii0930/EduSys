/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.Chuyende;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uynph
 */
public class ChuyendeDAO extends EduSysDAO<Chuyende, String>{

    public void insert(Chuyende model){
        String sql="INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        JDBC.update(sql, 
                model.getMaCD(), 
                model.getTenCD(), 
                model.getHocPhi(), 
                model.getThoiLuong(), 
                model.getHinh(),
                model.getMoTa());
    }
    
    public void update(Chuyende model){
        String sql="UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
        JDBC.update(sql, 
                model.getTenCD(), 
                model.getHocPhi(), 
                model.getThoiLuong(), 
                model.getHinh(), 
                model.getMoTa(),
                model.getMaCD());
    }
    
    public void delete(String MaCD){
        String sql="DELETE FROM ChuyenDe WHERE MaCD=?";
        JDBC.update(sql, MaCD);
    }
    
    public List<Chuyende> selectAll(){
        String sql="SELECT * FROM ChuyenDe";
        return selectBySql(sql);
    }
    
    public Chuyende selectById(String macd){
        String sql="SELECT * FROM ChuyenDe WHERE MaCD=?";
        List<Chuyende> list = selectBySql(sql, macd);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<Chuyende> selectBySql(String sql, Object...args){
        List<Chuyende> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBC.query(sql, args);
                while(rs.next()){
                    Chuyende entity=new Chuyende();
                    entity.setMaCD(rs.getString("MaCD"));
                    entity.setHinh(rs.getString("Hinh"));
                    entity.setHocPhi(rs.getDouble("HocPhi"));
                    entity.setMoTa(rs.getString("MoTa"));
                    entity.setTenCD(rs.getString("TenCD"));
                    entity.setThoiLuong(rs.getInt("ThoiLuong"));
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
    
}
