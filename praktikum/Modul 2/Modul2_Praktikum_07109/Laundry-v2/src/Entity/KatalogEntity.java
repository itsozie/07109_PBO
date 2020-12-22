/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ozie
 */
public class KatalogEntity {
    protected String nama_paket;
    protected int harga_paket;
    protected int berat_paket;

    public KatalogEntity(String nama_paket, int harga_paket, int berat_paket) {
        this.nama_paket  =  nama_paket;
        this.harga_paket = harga_paket;
        this.berat_paket = berat_paket;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public int getHarga_paket() {
        return harga_paket;
    }
    public int getBerat_paket() {
        return berat_paket;
    }
    
}
