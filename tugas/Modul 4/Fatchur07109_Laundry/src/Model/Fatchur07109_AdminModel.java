/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Entity.Fatchur07109_AdminEntity;
import Entity.Fatchur07109_PaketEntity;

/**
 *
 * @author Ozie
 */
public class Fatchur07109_AdminModel implements Fatchur07109_ModelInterfaces {

    private ArrayList<Fatchur07109_AdminEntity> AdminArrayList;

    public Fatchur07109_AdminModel() {
        AdminArrayList = new ArrayList<Fatchur07109_AdminEntity>();
    }

    public void insertAdmin(Fatchur07109_AdminEntity admin) {
        AdminArrayList.add(admin);
    }

    @Override
    public void view() {
        for (Fatchur07109_AdminEntity admin : AdminArrayList) {
            System.out.println("========================================================");
            System.out.println("ID           : " + admin.getId());
            System.out.println("NAMA          : " + admin.getNama());
            System.out.println("No Telephone  : " + admin.getNo_telp());
            System.out.println("Berat         : " + admin.getBerat());
            System.out.println("Tanggal Masuk : " + new SimpleDateFormat("dd-MM-yyyy").format(admin.getTgl()));
            System.out.println("Alamat        : " + admin.getAlamat());
            System.out.println("========================================================");
            System.out.println();
        }
    }

    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        for (Fatchur07109_AdminEntity adminEntity : AdminArrayList) {
            if (adminEntity.getId() == nik && adminEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }

    public Fatchur07109_AdminEntity showDataAdmin(int index) {
        return AdminArrayList.get(index);
    }

    public String showPaketAdmin(int indexPaket) {
        return Fatchur07109_PaketEntity.paket[indexPaket];
    }
}
