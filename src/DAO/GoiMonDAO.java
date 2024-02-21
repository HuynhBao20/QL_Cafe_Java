/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.BaoMatDAO.cn;
import GUI.frmLogin;
import XuLy.Ban;
import XuLy.MonAn;
import XuLy.ThucDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bao
 */
public class GoiMonDAO {
    public static ArrayList<MonAn> getLoad_LM()
    {
        ArrayList<MonAn> dslm = new ArrayList<>();
        try {
            connectionDB cn = new connectionDB();
            String sql = "Select TENLOAI FROM LOAIMON";
            cn.getCn(frmLogin.user, frmLogin.pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                MonAn m = new MonAn(rs.getString("TENLOAI"));
                dslm.add(m);
            }
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GoiMonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dslm;
    }
    
    public static ArrayList<MonAn> getcbo_MonAn(String MonAn)
    {
        ArrayList<MonAn> dslm = new ArrayList<>();
        try {
            connectionDB cn = new connectionDB();
            String sql = "SELECT TENMON FROM LOAIMON l, THUCDON t WHERE l.MALOAI = t.MALOAI AND TENLOAI = N'"+MonAn+"'";
            cn.getCn(frmLogin.user, frmLogin.pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                MonAn m = new MonAn(rs.getString("TENMON"));
                dslm.add(m);
            }
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GoiMonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dslm;
    }
    
    public static ArrayList<ThucDon> getMon(String User, String Pass, String MaBan, String MaPhieu){
        ArrayList<ThucDon> dsb = new ArrayList<>();
        try {
            String sql = "SELECT b.MABAN, ct.MAMON, d.TENMON, p.MANV FROM BAN b, CHITIET_PHIEU ct, PHIEU p, THUCDON d\n" +
                         "WHERE b.MABAN = p.MABAN and ct.MAPHIEU = p.MAPHIEU and d.MAMON = ct.MAMON and b.MABAN = N'"+MaBan+"' and p.MAPHIEU = '"+MaPhieu+"'";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                ThucDon b = new ThucDon(rs.getString("MABAN").trim(), rs.getString("MAMON").trim(), rs.getString("TENMON").trim(), rs.getString("MANV").trim());
                dsb.add(b);
            }
            cn.close();
        } catch (SQLException e) {}
        return dsb;
    }
    
   public static int getThemPhieu(String MAPHIEU, String MANV, String NGAYLAP, String MABAN)
            {
                int i = 0;
                try {
                String sql = "INSERT INTO PHIEU(MAPHIEU, MANV, NGAYLAP, MABAN) VALUES ('"+MAPHIEU+"', '"+MANV+"', '"+NGAYLAP+"', '"+MABAN+"')";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                System.out.println("Thêm/xóa/sửa thành công");
            
                } catch (Exception e) {
                    System.out.println("Thêm/xóa/sửa không thành công");

                }
                return i;
            }
   
   
   public static String getPhieuCuoi(String User, String Pass) throws SQLException{
       String Ma = "";
       try
           {
            connectionDB cn = new connectionDB();
            String sql = "SELECT TOP 1 MAPHIEU FROM PHIEU ORDER BY MAPHIEU DESC";
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            if (rs.next()) {
            Ma = rs.getString("MAPHIEU");
            }
            cn.close();
           } catch(SQLException e){}
         return Ma;
    }  
    
   public static int getThemMon(String MAPHIEU, String MAMON, int SOLUONG)
            {
                int i = 0;
                try {
                String sql = "INSERT INTO CHITIET_PHIEU(MAPHIEU, MAMON, SOLUONG) VALUES ('"+MAPHIEU+"', '"+MAMON+"', "+SOLUONG+")";
                cn.getCn(frmLogin.user, frmLogin.pass);
                i = cn.executeUpdate(sql);
                cn.close();
                System.out.println("Thêm/xóa/sửa thành công");
            
                } catch (Exception e) {
                    System.out.println("Thêm/xóa/sửa không thành công");

                }
                return i;
            }
   public static String getTimMon(String TenMon)
           {
               String Ma = "";
            try{
                connectionDB cn = new connectionDB();
                String sql = "SELECT MAMON FROM THUCDON WHERE TENMON = N'"+TenMon+"'";
                cn.getCn(frmLogin.user, frmLogin.pass);
                ResultSet rs = cn.executeQuery(sql);
                if (rs.next()) {
                Ma = rs.getString("MAMON");
                }
                cn.close();
           } catch(SQLException e){}
               return Ma;
           }
   
   public static void setTrangThai(String User, String Pass, String MaBan)
              {
                  try {
                    String sql = "UPDATE BAN SET TRANGTHAI = N'Đã đặt' WHERE MABAN = '"+MaBan+"'\n";
                                 
                    connectionDB cn = new connectionDB();
                    cn.getCn(User, Pass);
                    cn.executeUpdate(sql);
                    cn.close();
                  }catch(Exception e)
                      {
                          System.out.print("Bậy bạ rồi");
                      }
                
              }
}
