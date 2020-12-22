/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bariq Qushoyyi
 */
import Entity.AslabEntity07109;
import Entity.PraktikanEntity07109;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PraktikanModel07109 implements ModelInterfaces07109 {

    private ArrayList<PraktikanEntity07109> praktikanEntity07109ArrayList;

    public PraktikanModel07109() {
        praktikanEntity07109ArrayList = new ArrayList<PraktikanEntity07109>();
    }

    public void insert(PraktikanEntity07109 praktikanEntity07109) {
        praktikanEntity07109ArrayList.add(praktikanEntity07109);
    }

    @Override
    public void view() {
        for (PraktikanEntity07109 praktikanEntity07109 : praktikanEntity07109ArrayList) {
            System.out.println("===============================================================");
            System.out.println(" NPM : " + praktikanEntity07109.getNpm()
                    + "\n Nama : " + praktikanEntity07109.getNama()
                    + "\n Password : " + praktikanEntity07109.getPassword()
                    + "\n No Telp : " + praktikanEntity07109.getNo_telp()
                    + "\n Tanggal Lahir : " + praktikanEntity07109.getTgllahir());
            System.out.println("===============================================================");
        }
    }

    //@Override
    public int cekData(String npm, String password) {
        int loop = 0;
        while (!praktikanEntity07109ArrayList.get(loop).getNpm().equals(npm)
                && !praktikanEntity07109ArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }
    
    public PraktikanEntity07109 getPraktikanEntityArrayList(int index){
        return praktikanEntity07109ArrayList.get(index);
    }
}
