/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XuLy;

/**
 *
 * @author Bao
 */
public class BaoMat {
    String TK, NGAYDN;

    public void setTK(String TK) {
        this.TK = TK;
    }

    public void setNGAYDN(String NGAYDN) {
        this.NGAYDN = NGAYDN;
    }

    public String getTK() {
        return TK;
    }

    public String getNGAYDN() {
        return NGAYDN;
    }

    public BaoMat(String TK, String NGAYDN) {
        this.TK = TK;
        this.NGAYDN = NGAYDN;
    }
}
