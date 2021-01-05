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
import Entity.DaftarprakEntity07109;
import Entity.PraktikumEntity07109;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DaftarprakModel07109 implements ModelInterfaces07109 {

    public ArrayList<DaftarprakEntity07109> daftarprak07171ArrayList;

    public DaftarprakModel07109() {
        daftarprak07171ArrayList = new ArrayList<DaftarprakEntity07109>();
    }

    public ArrayList<DaftarprakEntity07109> alldataprak() {
        return daftarprak07171ArrayList;
    }

    public void insertDataDaftarprak(DaftarprakEntity07109 daftarPrak07171) {
        daftarprak07171ArrayList.add(daftarPrak07171);
    }

    public ArrayList<DaftarprakEntity07109> getDaftarprakArrayList() {
        return daftarprak07171ArrayList;
    }

    @Override
    public void view() {
        for (DaftarprakEntity07109 daftarprak07171 : daftarprak07171ArrayList) {
            System.out.println("===============================================================");
            System.out.println(" NPM : " + daftarprak07171.getPraktikan().getNpm()
                    + "\n Nama : " + daftarprak07171.getPraktikan().getNama()
                    + "\n Password : " + daftarprak07171.getPraktikan().getPassword()
                    + "\n No Telp : " + daftarprak07171.getPraktikan().getNo_telp()
                    + "\n Tanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarprak07171.getPraktikan().getTgllahir())
                    + "\n Praktikum : " + PraktikumEntity07109.nama[daftarprak07171.getIndexPrak()]
                    + "\n IsVerified : ");
            if (daftarprak07171.isVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("===============================================================");
        }
    }

    public int cekData(String npm, String password) {
        int loop = 0;
        if (daftarprak07171ArrayList.size() == 0) {
            loop = -1;//data kosong
        } else {
            for (int i = 0; i < daftarprak07171ArrayList.size(); i++) {
                if (daftarprak07171ArrayList.get(i).getPraktikan().getNpm().equals(npm)) {
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
        return daftarprak07171ArrayList.get(index);
    }

    public void updateIsVerified(int index, DaftarprakEntity07109 daftarprak07171) {
        daftarprak07171ArrayList.set(index, daftarprak07171);
    }
}
