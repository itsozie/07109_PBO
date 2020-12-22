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
import Entity.DaftarprakEntity07109;
import Entity.PraktikumEntity07109;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class DaftarprakModel07109 implements ModelInterfaces07109 {
    private ArrayList<DaftarprakEntity07109> daftarprakArrayList = new ArrayList();
    
    public void DaftarprakModel() {
        daftarprakArrayList = new ArrayList<DaftarprakEntity07109>();
    }
    
    public void insertDataDaftarprak(DaftarprakEntity07109 daftarprak) {
        daftarprakArrayList.add(daftarprak);
    }
    
    public ArrayList<DaftarprakEntity07109> getDaftarprakArrayList() {
        return daftarprakArrayList;
    }
    
    /**
     *
     */
    @Override
    public void view() {
        for(DaftarprakEntity07109 daftarprak : daftarprakArrayList) {
            System.out.println("=============================================");
            System.out.print("NPM : "+daftarprak.getPraktikan().getNpm()+"\n Nama : "+daftarprak.getPraktikan().getNama()+"\n Password : "+daftarprak.getPraktikan().getPassword()+"\n No. Telp : "+daftarprak.getPraktikan().getNo_telp()+"Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(daftarprak.getPraktikan().getTglLahir())+"\n Praktikum : "+PraktikumEntity07109.nama[daftarprak.getIndexPrak()]+"\n IsVerified : ");
            if(daftarprak.isVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("=============================================");
        }
    }
    
    public int cekData(String npm, String password) {
        int loop = 0;
        if(daftarprakArrayList.size() == 0) {
            loop = -1;
        } else {
            for(int i=0;i<daftarprakArrayList.size();i++) {
                if(daftarprakArrayList.get(i).getPraktikan().getNpm().equals(npm)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public DaftarprakEntity07109 showDaftarprak(int index) {
        return daftarprakArrayList.get(index);
    }
    
    public void updateIsVerified(int index, DaftarprakEntity07109 daftarprakEntity) {
        daftarprakArrayList.set(index, daftarprakEntity);
    }
}
