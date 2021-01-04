/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Ozie
 */
public class Fatchur07109_AdminEntity extends Fatchur07109_KonsumenAbstractEntity {

    private int paket;

    public Fatchur07109_AdminEntity(int paket, String password, String nama, String no_telp, String alamat,int berat, int nik, Date tgl) {
        super(password, nama, no_telp, alamat, berat, nik, tgl);
        this.paket = paket;
    }
    public int getpaket() {
        return paket;
    }
    
    public void setpaket(int paket){
        this.paket = paket;
    }
}
