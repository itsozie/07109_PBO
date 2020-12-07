/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ozie
 */
import Entity.AslabEntity07109;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AslabModel07109 implements ModelInterfaces07109 {

    private ArrayList<AslabEntity07109> aslabEntity07109ArrayList;

    public AslabModel07109() {
        aslabEntity07109ArrayList = new ArrayList<AslabEntity07109>();
    }

    public void insertAslab(AslabEntity07109 aslab) {
        aslabEntity07109ArrayList.add(aslab);
    }

    @Override
    public void view() {
        for (AslabEntity07109 aslabEntity07109 : aslabEntity07109ArrayList) {
            System.out.print(aslabEntity07109.getNpm());
            System.out.print(aslabEntity07109.getNama());
            System.out.print(aslabEntity07109.getPassword());
            System.out.print(aslabEntity07109.getNo_telp());
            System.out.print(new SimpleDateFormat("dd-mm-yyyy").format(aslabEntity07109.getTgllahir()));
            System.out.println();

        }
    }

    //@Override
    public int cekData(String npm, String password) {
        int loop = 0;
        for (AslabEntity07109 aslabEntity07109 : aslabEntity07109ArrayList) {
            if (aslabEntity07109.getNpm().equals(npm) && aslabEntity07109.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public AslabEntity07109 showDataAslab(int index){
        return aslabEntity07109ArrayList.get(index);
    }
}
