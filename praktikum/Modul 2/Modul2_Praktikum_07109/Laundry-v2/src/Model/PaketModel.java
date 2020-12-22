/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.KatalogEntity;
import java.util.ArrayList;
/**
 *
 * @author ozie
 */
public class PaketModel {
    private ArrayList <KatalogEntity> paket;
    
    public PaketModel(){
        paket = new ArrayList();
    }
    
    public void insert_paket(KatalogEntity cucian){
        paket.add(cucian);
    }

    public ArrayList<KatalogEntity> getPaket() {
        return paket;
    }
}
