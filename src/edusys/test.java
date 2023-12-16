package edusys;

import java.util.List;

import Database.NhanviienDAO;
import Models.Nhanvien;

public class test {
	public static void main(String[] args) {
		NhanviienDAO dao=new NhanviienDAO();
		List<Nhanvien> nv=dao.selectAll();
		for(Nhanvien v:nv) {
			System.out.println(v.getHoTen());
		}
	}
}
