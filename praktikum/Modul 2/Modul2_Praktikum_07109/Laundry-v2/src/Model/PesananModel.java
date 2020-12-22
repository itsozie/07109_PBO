/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ozie
 */
import Entity.PencuciEntity;
import Entity.KatalogEntity;
import java.util.ArrayList;
public class PesananModel {
    private String id_pesan,nama;
    private PencuciEntity pencuci;
    private ArrayList <KatalogEntity> Checkout = new ArrayList();
    
    public PesananModel(String id_pesan, String nama, PencuciEntity pencuci, ArrayList<KatalogEntity> Checkout) {
        this.id_pesan = id_pesan;
        this.nama     = nama;
        this.pencuci  = pencuci;
        this.Checkout = Checkout;
    }

    public String getId_pesan() {
        return id_pesan;
    }

    public String getNama() {
        return nama;
    }

    public PencuciEntity getAdmin() {
        return pencuci;
    }

    public ArrayList<KatalogEntity> getCheckout() {
        return Checkout;
    }
    public double total_harga(){
        double total = 0;
        for(int i=0;i<Checkout.size();i++){
            total = Checkout.get(i).getBerat_paket() * Checkout.get(i).getHarga_paket();
        }
        return total;
    }

}

