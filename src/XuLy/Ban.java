/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

import java.util.logging.Logger;

/**
 *
 * @author Bao
 */
public class Ban {

    
    
    String MaBan, TenBan, MaKV, TrangThai;

    public Ban(String MaBan) {
        this.MaBan = MaBan;
    }
    int SoNguoi;

    public Ban() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public String toString() {
        return "Ban{" + "MaBan=" + MaBan + ", TenBan=" + TenBan + ", MaKV=" + MaKV + ", TrangThai=" + TrangThai + ", SoNguoi=" + SoNguoi + '}';
    }
    
    public Ban(String MaBan, String TenBan, String MaKV, String TrangThai, int SoNguoi) {
        this.MaBan = MaBan;
        this.TenBan = TenBan;
        this.MaKV = MaKV;
        this.TrangThai = TrangThai;
        this.SoNguoi = SoNguoi;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public void setTenBan(String TenBan) {
        this.TenBan = TenBan;
    }

    public void setMaKV(String MaKV) {
        this.MaKV = MaKV;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }
    
    public String getMaBan() {
        return MaBan;
    }

    public String getTenBan() {
        return TenBan;
    }

    public String getMaKV() {
        return MaKV;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }
}
