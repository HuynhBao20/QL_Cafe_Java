/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

/**
 *
 * @author Bao
 */
public class ThucDon {
    public String MABAN, MAMON, TENMON, MANV;

    public void setMABAN(String MABAN) {
        this.MABAN = MABAN;
    }

    public void setMAMON(String MAMON) {
        this.MAMON = MAMON;
    }

    public void setTENMON(String TENMON) {
        this.TENMON = TENMON;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMABAN() {
        return MABAN;
    }

    public String getMAMON() {
        return MAMON;
    }

    public String getTENMON() {
        return TENMON;
    }

    public String getMANV() {
        return MANV;
    }

    public ThucDon(String MABAN, String MAMON, String TENMON, String MANV) {
        this.MABAN = MABAN;
        this.MAMON = MAMON;
        this.TENMON = TENMON;
        this.MANV = MANV;
    }
}
