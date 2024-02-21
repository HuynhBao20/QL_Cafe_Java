/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

import java.sql.Date;

/**
 *
 * @author Bao
 */
public class NhanVien {

    String MaNV, Hoten, DiaChi, SDT, NgayVL, PHAI, NgaySinh;
    public void setNgayVL(String NgayVL) {
        this.NgayVL = NgayVL;
    }

    public void setPHAI(String PHAI) {
        this.PHAI = PHAI;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNgayVL() {
        return NgayVL;
    }

    public String getPHAI() {
        return PHAI;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }
    public NhanVien(String MaNV, String Hoten, String DiaChi, String SDT, String NgayVL, String PHAI, String NgaySinh) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgayVL = NgayVL;
        this.PHAI = PHAI;
        this.NgaySinh = NgaySinh;
       
    }
    
    
    public NhanVien(String MaNV, String Hoten, String DiaChi, String SDT) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
