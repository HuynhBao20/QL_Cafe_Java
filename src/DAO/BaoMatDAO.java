/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import GUI.frmLogin;
import XuLy.BaoMat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bao
 */
public class BaoMatDAO {
    public static connectionDB cn = new connectionDB();
    public static void BackUp(String Link)
            {
            try {
            String sql = "BACKUP DATABASE QL_CAFE\n" + "TO DISK='"+Link+".bak'";
            cn.getCn(frmLogin.user, frmLogin.pass);
            cn.executeUpdate(sql);
            cn.close();
            } catch (Exception e) 
                {
                    cn.close();
                }
            
            }
    public static void getReSetPass(String User, String OldPass, String NewPass)
            {
            try {
            String sql = "ALTER LOGIN ["+User+"] WITH PASSWORD=N'"+NewPass+"' OLD_PASSWORD=N'"+OldPass+"'";
            cn.getCn(frmLogin.user, frmLogin.pass);
            cn.executeUpdate(sql);
            cn.close();
            } catch (Exception e) 
                {
                    cn.close();
                }
            
            }
    public static void GoiTK(String User, String Pass, String MaNV)
            {
            try {
            String sql = "Select * from NHANVIEN WHERE MANV = '"+MaNV+"'";
            cn.getCn(User, Pass);
            cn.executeQuery(sql);
            cn.close();
        
            } catch (Exception e) 
                {
                    System.out.println("Lỗi không thể lấy dữ liệu nhân viên");
                    cn.close();
                }
            
            }
    public static int Them(String TK, String NgayThang)
            {
                int i = 0;
                try {
                String sql = "INSERT INTO Login_Log VALUES ('"+TK+"', '"+NgayThang+"')";
                cn.getCn("sa", "123");
                i = cn.executeUpdate(sql);
                cn.close();
                System.out.println("Thêm/xóa/sửa thành công");
            
                } catch (Exception e) {
                    System.out.println("Thêm/xóa/sửa không thành công");

                }
                return i;
            }
    public static ArrayList<BaoMat> getTK(String User, String Pass){
        ArrayList<BaoMat> dslg;
        dslg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Login_log";
            connectionDB cn = new connectionDB();
            cn.getCn(User, Pass);
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                //String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi
                BaoMat b = new BaoMat(rs.getString("Acc").trim(), rs.getString("NgayDN").trim());
                dslg.add(b);
            }
            cn.close();
        } catch (SQLException e) {
            
        }
        return dslg;
    }  
    
    
}
