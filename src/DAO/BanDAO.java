/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.BaoMatDAO.cn;
import GUI.frmLogin;
import XuLy.Ban;
import XuLy.ThucDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bao
 */
public class BanDAO {
     public static ArrayList<Ban> getDSBan(String User, String Pass){
        ArrayList<Ban> dsb = new ArrayList<>();
        try {
            String sql = "select * from BAN";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                Ban b = new Ban(rs.getString("MABAN").trim(), rs.getString("TENBAN").trim(), rs.getString("MAKV").trim(), rs.getString("TRANGTHAI").trim(), rs.getInt("SONGUOI"));
                dsb.add(b);
            }
            cn.close();
        } catch (SQLException e) {
        }
        return dsb;
    }
     
    public static ArrayList<Ban> getBan_kv(String User, String Pass, String kv){
        ArrayList<Ban> dsb = new ArrayList<>();
        try {
            String sql = "SELECT * FROM BAN b, KHUVUC k WHERE TENKV = N'"+kv+"' AND b.MAKV = k.MAKV";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                Ban b = new Ban(rs.getString("MABAN").trim(), rs.getString("TENBAN").trim(), rs.getString("MAKV").trim(), rs.getString("TRANGTHAI").trim(), rs.getInt("SONGUOI"));
                dsb.add(b);
            }
            cn.close();
        } catch (SQLException e) {
            
        }
        return dsb;
    }  
     
      public static ArrayList<Ban> getBan_Trong(String User, String Pass){
        ArrayList<Ban> dsb = new ArrayList<>();
        try {
            String sql = "SELECT * FROM BAN b, KHUVUC k WHERE TRANGTHAI = N'Trống' AND b.MAKV = k.MAKV";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                Ban b = new Ban(rs.getString("MABAN").trim(), rs.getString("TENBAN").trim(), rs.getString("MAKV").trim(), rs.getString("TRANGTHAI").trim(), rs.getInt("SONGUOI"));
                dsb.add(b);
            }
            cn.close();
        } catch (SQLException e) {

        }
        return dsb;
    }  
      
      public static ArrayList<ThucDon> getMon(String User, String Pass, String MaBan){
        ArrayList<ThucDon> dsb = new ArrayList<>();
        try {
            String sql = "SELECT b.MABAN, ct.MAMON, d.TENMON, p.MANV FROM BAN b, CHITIET_PHIEU ct, PHIEU p, THUCDON d\n" +
                         "WHERE b.MABAN = p.MABAN and ct.MAPHIEU = p.MAPHIEU and d.MAMON = ct.MAMON and b.TENBAN = N'"+MaBan+"'";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                ThucDon b = new ThucDon(rs.getString("MABAN").trim(), rs.getString("MAMON").trim(), rs.getString("TENMON").trim(), rs.getString("MANV").trim());
                dsb.add(b);
            }
            cn.close();
        } catch (SQLException e) {

        }
        return dsb;
    }
      public static void getDoiBan(String User, String Pass, String MaBan, String MaBanDoi)
              {
                  try {
                    String sql = "UPDATE GOPMON SET MABAN = '"+MaBanDoi+"' WHERE MABAN = '"+MaBan+"'\n" + 
                                 "UPDATE BAN SET TRANGTHAI = N'Đã đặt' WHERE MABAN = '"+MaBanDoi+"'" + 
                                 "UPDATE BAN SET TRANGTHAI = N'Trống' WHERE MABAN = '"+MaBan+"'";
                    connectionDB cn = new connectionDB();
                    cn.getCn(User, Pass);
                    cn.executeUpdate(sql);
                    cn.close();
                  }catch(Exception e)
                      {
                          System.out.print("Bậy bạ rồi");
                      }
                
              }
      
      public static int getThemBan(String MABAN, String TENBAN, int SOLUONG, String MAKV)
            {
                int i = 0;
                try {
                String sql = "INSERT INTO BAN(MABAN, TENBAN, SONGUOI, MAKV) VALUES ('"+MABAN+"', '"+TENBAN+"', "+SOLUONG+", '"+MAKV+"')";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                } catch (Exception e) {}
                return i;
            }
      
      public static int getXoaBan(String MABAN)
            {
                int i = 0;
                try {
                String sql = "DELETE FROM BAN WHERE MABAN = '"+MABAN+"'";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                } catch (Exception e) {}
                return i;
            }
      
      public static String getTimKV(String TenKV)
           {
               String Ma = "";
            try{
                connectionDB cn = new connectionDB();
                String sql = "SELECT MAKV FROM KHUVUC WHERE TENKV = N'"+TenKV+"'";
                cn.getCn(frmLogin.user, frmLogin.pass);
                ResultSet rs = cn.executeQuery(sql);
                if (rs.next()) {
                Ma = rs.getString("MAKV");
                }
                cn.close();
           } catch(SQLException e){}
               return Ma;
           }
      
      public static String getPhieuCuoi(String User, String Pass) throws SQLException{
       String Ma = "";
       try
           {
            connectionDB cn = new connectionDB();
            String sql = "SELECT TOP 1 MABAN FROM BAN ORDER BY MABAN DESC";
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            if (rs.next()) {
            Ma = rs.getString("MABAN");
            }
            cn.close();
           } catch(SQLException e){}
         return Ma;
    }  
      public static int getUpdateBan(String MABAN, String TENBAN, String KHUVUC, int SOLUONG)
            {
                int i = 0;
                try {
                String sql = "UPDATE BAN SET TENBAN = N'"+TENBAN+"', MAKV = '"+KHUVUC+"', SONGUOI = "+SOLUONG+"  WHERE MABAN = '"+MABAN+"'";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                } catch (Exception e) {}
                return i;
            }
}
