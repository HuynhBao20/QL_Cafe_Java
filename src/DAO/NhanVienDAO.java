/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.BaoMatDAO.cn;
import GUI.frmLogin;
import XuLy.ChamCong;
import XuLy.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bao
 */
public class NhanVienDAO {
     public static ArrayList<NhanVien> getDSNV(String User, String Pass){
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        try {
            String sql = "select * from NHANVIEN";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                
                NhanVien nv = new NhanVien(rs.getString("MANV").trim(), rs.getString("HOTEN").trim(), rs.getString("DIACHI").trim(), rs.getString("SDT").trim(), rs.getString("NGAYVL"), rs.getString("PHAI"), rs.getString("NGAYSINH"));
                dsNV.add(nv);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Lỗi không thể lấy dữ liệu bảng");
        }
        return dsNV;
    }
     
     
//      public static ArrayList<NhanVien> timNV(String User, String Pass, String MANV){
//        ArrayList<NhanVien> DSNV = new  ArrayList<>();
//        try {
//            String sql = "EXEC sp_Search_NV '"+MANV+"'";
//            connectionDB cn = new connectionDB();
//            cn.getCn(User, Pass);
//            ResultSet rs = cn.executeQuery(sql);
//            while(rs.next()){
//                 NhanVien nv = new NhanVien(rs.getString("MANV").trim(), rs.getString("HOTEN").trim(), rs.getString("DIACHI").trim(), rs.getString("SDT").trim(), rs.getString("NGAYVL"), rs.getString("PHAI"), rs.getString("NGAYSINH"));
//                DSNV.add(nv);
//            }
//            cn.close();
//        } catch (SQLException e) {
//            System.out.println("Lỗi không thể lấy dữ liệu nhân viên từ bảng");
//        }
//        return DSNV;
//    }
      
      
      public static ArrayList<NhanVien> timHoTenNV(String User, String Pass, String MANV, String Hoten){
        ArrayList<NhanVien> DSNV = new  ArrayList<>();
        try {
            String sql = "select * from NHANVIEN WHERE HOTEN LIKE '"+Hoten+"%' OR MANV = '"+MANV+"'";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                 NhanVien nv = new NhanVien(rs.getString("MANV").trim(), rs.getString("HOTEN").trim(), rs.getString("DIACHI").trim(), rs.getString("SDT").trim(), rs.getString("NGAYVL"), rs.getString("PHAI"), rs.getString("NGAYSINH"));
                DSNV.add(nv);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Lỗi không thể lấy dữ liệu nhân viên");
        }
        return DSNV;
    }
     
    public static int getThemNV(String MANV, String HOTEN, String DIACHI, String SDT, String NgayVL, String PHAI, String NgaySinh)
            {
                int i = 0;
                try {
                String sql = "INSERT INTO NHANVIEN VALUES ('"+MANV+"', N'"+HOTEN+"', N'"+DIACHI+"', '"+SDT+"', '"+NgayVL+"', N'"+PHAI+"','"+NgaySinh+"')";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                System.out.println("Thêm/xóa/sửa thành công");
            
                } catch (Exception e) {
                    System.out.println("Thêm/xóa/sửa không thành công");

                }
                return i;
            }
    
    public static int getXoaNV(String MANV)
            {
                int i = 0;
                try {
                String sql = "DELETE FROM NHANVIEN WHERE MANV = '"+MANV+"'";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                System.out.println("Thêm/xóa/sửa thành công");
            
                } catch (Exception e) {
                    System.out.println("Thêm/xóa/sửa không thành công");

                }
                return i;
            }
      
      public static int getUpdateNV(String MANV, String HOTEN, String DIACHI, String SDT, String NgayVL, String PHAI, String NgaySinh)
            {
                int i = 0;
                try {
                String sql = "UPDATE NHANVIEN SET HOTEN = N'"+HOTEN+"', DIACHI = '"+DIACHI+"', SDT = "+SDT+", NGAYVL = '"+NgayVL+"', PHAI = N'"+PHAI+"', NGAYSINH = '"+NgaySinh+"' WHERE MANV = '"+MANV+"'";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                System.out.println("Thêm/xóa/sửa thành công");
            
                } catch (Exception e) {
                    System.out.println("Thêm/xóa/sửa không thành công");

                }
                return i;
            }
      public static String getMaNVCuoi() {
       String Ma = "";
       try
           {
            connectionDB cn = new connectionDB();
            String sql = "SELECT TOP 1 MANV FROM NHANVIEN ORDER BY MANV DESC";
            cn.getCn(frmLogin.user, frmLogin.pass);
            ResultSet rs = cn.executeQuery(sql);
            if (rs.next()) {
            Ma = rs.getString("MANV");
            }
            cn.close();
           } catch(SQLException e){}
         return Ma;
    }  
     
      public static void getTaoTK(String MaNV)
              {
                  connectionDB cn = new connectionDB();
                  String sql = "sp_addlogin '"+MaNV+"', '123' \n" + 
                               "CREATE USER "+MaNV+" FOR LOGIN " + MaNV + "\n";
                  cn.getCn(frmLogin.user, frmLogin.pass);
                  cn.executeUpdate(sql);
                  cn.close();
              }
      public static void getCapQuyen(String MaNV, String QUYEN)
              {
                  connectionDB cn = new connectionDB();
                  String sql = "sp_addrolemember '"+QUYEN+"', '"+MaNV+"'";
                  cn.getCn(frmLogin.user, frmLogin.pass);
                  cn.executeUpdate(sql);
                  cn.close();
              }
      public static void getXoaUser(String MaNV)
              {
                  connectionDB cn = new connectionDB();
                  String sql = "sp_dropuser '"+MaNV+"'";
                  cn.getCn(frmLogin.user, frmLogin.pass);
                  cn.executeUpdate(sql);
                  cn.close();
              }
      public static void getXoaTK(String MaNV)
              {
                  connectionDB cn = new connectionDB();
                  String sql = "sp_droplogin '"+MaNV+"'";
                  cn.getCn(frmLogin.user, frmLogin.pass);
                  cn.executeUpdate(sql);
                  cn.close();
              }
      public static int getThemDiemDanh(String MANV, String NgayDD, int SoGio)
            {
                int i = 0;
                try {
                String sql = "INSERT INTO CHAMCONG VALUES ('"+MANV+"', '"+NgayDD+"', "+SoGio+")";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                } catch (Exception e) {}
                return i;
            }
       public static ArrayList<ChamCong> getChamCong(){
        ArrayList<ChamCong> dsNV = new ArrayList<>();
        try {
            String sql = "select * from CHAMCONG";
            connectionDB cn = new connectionDB();
            cn.getCn(frmLogin.user, frmLogin.pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ChamCong nv = new ChamCong(rs.getString("MANV").trim(), rs.getString("NGAY").trim(), rs.getInt("SOGIO"));
                dsNV.add(nv);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Lỗi không thể lấy dữ liệu bảng");
        }
        return dsNV;
    }
    public static ArrayList<ChamCong> getThang()
            {
                ArrayList<ChamCong> ds = new ArrayList<>();
                try {
            String sql = "SELECT DISTINCT CONCAT('Tháng: ', MONTH(NGAY), '-', YEAR(NGAY)) AS 'Thang' FROM CHAMCONG";
            connectionDB cn = new connectionDB();
            cn.getCn(frmLogin.user, frmLogin.pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ChamCong c = new ChamCong(rs.getString("Thang").trim());
                ds.add(c);
            }
            cn.close();
                } catch (SQLException e) {
                }
               return ds;
            }
}
