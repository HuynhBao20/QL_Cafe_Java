/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

/**
 *
 * @author Bao
 */
public class KhuVuc {
    String maKV, TenKV;

    @Override
    public String toString() {
        return "KhuVuc{" + "maKV=" + maKV + ", TenKV=" + TenKV + '}';
    }

    public void setMaKV(String maKV) {
        this.maKV = maKV;
    }

    public void setTenKV(String TenKV) {
        this.TenKV = TenKV;
    }

    public String getMaKV() {
        return maKV;
    }

    public String getTenKV() {
        return TenKV;
    }

    public KhuVuc(String maKV, String TenKV) {
        this.maKV = maKV;
        this.TenKV = TenKV;
    }
}
