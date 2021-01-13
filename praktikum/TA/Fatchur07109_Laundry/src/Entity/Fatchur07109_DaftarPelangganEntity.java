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
public class Fatchur07109_DaftarPelangganEntity {

    private Fatchur07109_PelangganEntity pelanggan;
    private int paket;

    public Fatchur07109_DaftarPelangganEntity(Fatchur07109_PelangganEntity pelanggan, int paket) {
        this.pelanggan = pelanggan;
        this.paket = paket;
    }

    public void setPelanggan(Fatchur07109_PelangganEntity pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Fatchur07109_PelangganEntity getPelanggan() {
        return pelanggan;
    }

    public int getIndexpaket() {
        return paket;
    }
    public void setIndexpaket(int paket) {
        this.paket = paket;
    }
   
}
