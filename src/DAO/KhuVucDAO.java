/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import XuLy.Ban;
import XuLy.KhuVuc;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Bao
 */
public class KhuVucDAO {
    public static ArrayList<KhuVuc> getDSKV(String User, String Pass){
        ArrayList<KhuVuc> dsKV = new ArrayList<KhuVuc>();
        try {
            String sql = "select * from KHUVUC";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                KhuVuc kv = new KhuVuc(rs.getString("MAKV").trim(), rs.getString("TENKV").trim());
                dsKV.add(kv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn ");
        }
        return dsKV;
    }
    
     public static ArrayList<Ban> getTimBan(String User, String Pass, String KhuVuc){
        ArrayList<Ban> dsb = new ArrayList<Ban>();
        try {
            String sql = "SELECT * FROM BAN, KHUVUC\n" + "WHERE BAN.MAKV = KHUVUC.MAKV and TENBAN.MAKV = '"+KhuVuc+"'";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                Ban b = new Ban(rs.getString("MABAN").trim(), rs.getString("TENBAN").trim(), rs.getString("MAKV").trim(), rs.getString("TRANGTHAI").trim(), rs.getInt("SONGUOI"));
                dsb.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn ");
        }
        return dsb;
    }
}
