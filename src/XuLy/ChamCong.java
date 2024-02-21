/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

/**
 *
 * @author Bao
 */
public class ChamCong {
    public String MaNV, NgayDD;

    public ChamCong(String NgayDD) {
        this.NgayDD = NgayDD;
    }
    int soGio;

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayDD(String NgayDD) {
        this.NgayDD = NgayDD;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getNgayDD() {
        return NgayDD;
    }

    public int getSoGio() {
        return soGio;
    }

    public ChamCong(String MaNV, String NgayDD, int soGio) {
        this.MaNV = MaNV;
        this.NgayDD = NgayDD;
        this.soGio = soGio;
    }
}
