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
import Entity.AslabEntity07109;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class AslabModel07109 implements ModelInterfaces07109 {
    private ArrayList<AslabEntity07109> aslabEntityArrayList = new ArrayList();
    
    public void AslabModel() {
        aslabEntityArrayList = new ArrayList<AslabEntity07109>();
    }
    
    public void insertAslab(AslabEntity07109 aslab) {
        aslabEntityArrayList.add(aslab);
    }
    
    @Override
    public void view() {
        for(AslabEntity07109 aslabEntity : aslabEntityArrayList) {
            System.out.println(aslabEntity.getNpm());
            System.out.println(aslabEntity.getNama());
            System.out.println(aslabEntity.getPassword());
            System.out.println(aslabEntity.getNo_telp());
            System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(aslabEntity.getTglLahir()));
        }
    }
    
    public int cekData(String npm, String password) {
        int loop = 0;
        for(AslabEntity07109 aslabEntity : aslabEntityArrayList) {
            if(aslabEntity.getNpm().equals(npm) && aslabEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public AslabEntity07109 showDataAslab(int index) {
        return aslabEntityArrayList.get(index);
    }
}
 