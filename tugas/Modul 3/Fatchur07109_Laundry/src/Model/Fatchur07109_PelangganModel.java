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
import java.util.ArrayList;
import Entity.Fatchur07109_PelangganEntity;
import java.text.SimpleDateFormat;

public class Fatchur07109_PelangganModel implements Fatchur07109_ModelInterfaces {

    private ArrayList<Fatchur07109_PelangganEntity> pelangganArrayList;

    public Fatchur07109_PelangganModel() {
        pelangganArrayList = new ArrayList<Fatchur07109_PelangganEntity>();
    }

    public void insertPelanggan(Fatchur07109_PelangganEntity pelanggan) {
        pelangganArrayList.add(pelanggan);
    }

    public void updatePelanggan(int indexUser, Fatchur07109_PelangganEntity pelanggan) {
        pelangganArrayList.set(indexUser, pelanggan);
    }

    public Fatchur07109_PelangganEntity getPelangganArrayList(int index) {
        return pelangganArrayList.get(index);
    }

    @Override
    public void view() {
        for (Fatchur07109_PelangganEntity pelanggan : pelangganArrayList) {
            System.out.println("========================================================");
            System.out.println(" ID : " + pelanggan.getId()
                    + "\n Nama : " + pelanggan.getNama()
                    + "\n Alamat : " + pelanggan.getAlamat()
                    + "\n Berat : " + pelanggan.getBerat() + "Kg"
                    + "\n Tanggal Masuk : " + new SimpleDateFormat("dd-MM-yyyy")
                            .format(pelanggan.getTgl()));
            System.out.println("========================================================");
            System.out.println();
        }
    }

    @Override
    public int cekData(int id, String password) {
        int loop = 0;
        for (Fatchur07109_PelangganEntity pelangganEntity : pelangganArrayList) {
            if (pelangganEntity.getId()== id && pelangganEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }

}
