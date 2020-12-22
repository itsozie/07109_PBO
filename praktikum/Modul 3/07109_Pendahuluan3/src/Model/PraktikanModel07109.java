/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Wahfiudin
 */
import Entity.PraktikanEntity07109;
import java.util.ArrayList;
public class PraktikanModel07109 implements ModelInterfaces07109 {
    private ArrayList<PraktikanEntity07109> praktikanEntityArrayList = new ArrayList();
    
    public void PraktikanModel() {
        praktikanEntityArrayList = new ArrayList<PraktikanEntity07109>();
    }
    
    public void insert(PraktikanEntity07109 praktikanEntity) {
        praktikanEntityArrayList.add(praktikanEntity);
    }
    
    @Override
    public void view() {
        for(PraktikanEntity07109 praktikanEntity : praktikanEntityArrayList) {
            System.out.println("===========================================");
            System.out.println("NPM : "+praktikanEntity.getNpm()+"\nNama : "+praktikanEntity.getNama()+"\nPassword : "+praktikanEntity.getPassword()+"\nNo. Telp : "+praktikanEntity.getNo_telp()+"\nTanggal Lahir : "+praktikanEntity.getTglLahir());
            System.out.println("===========================================");
        }
    }
    
    public int cekData(String npm, String password) {
        int loop = 0;
        while(!praktikanEntityArrayList.get(loop).getNpm().equals(npm) && !praktikanEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }
    
    public PraktikanEntity07109 getPraktikanEntityArrayList(int index) {
        return praktikanEntityArrayList.get(index);
    }
}
