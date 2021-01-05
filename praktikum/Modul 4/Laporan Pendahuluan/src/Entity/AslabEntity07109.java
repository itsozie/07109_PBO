/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Ozie
 */
import java.util.Date;

public class AslabEntity07109 extends MahasiswaAbstractEntity07109 {

    private String laboratorium;

    public AslabEntity07109(String npm, String password, String nama, String no_telp, Date tglLahir, String lab) {
        super(npm, password, nama, no_telp, tglLahir);
        this.laboratorium = lab;
    }

    @Override
    public String getNpm() {
        return npm;
    }

    public String getLaboratorium() {
        return laboratorium;
    }

    public void AslabEntity07171(String laboratorium) {
        this.laboratorium = laboratorium;
    }
}
