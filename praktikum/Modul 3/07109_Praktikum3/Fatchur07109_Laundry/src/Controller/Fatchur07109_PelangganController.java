package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entity.*;
import java.util.Date;

/**
 *
 * @author Ozie
 */

public class Fatchur07109_PelangganController {

    int indexLogin = 0;

    public Fatchur07109_PelangganController() {
    }

    public Fatchur07109_PelangganEntity pelangganEntity() {
        return Fatchur07109_AllObjectController.pelangganModel.getPelangganArrayList(indexLogin);
    }

    public void dataPelanggan() {
        int nik[] = {01, 02, 03};
        String pass[] = {"01", "02", "03"};
        String nama[] = {"koko", "kiki", "arni"};
        String no_telp[] = {"01", "02", "03"};
        int berat[] = {2,4,6};
        String alamat[] = {"surabayans", "sidoarjo", "gresik"};
        String tanggal[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < nik.length; i++) {
            Fatchur07109_AllObjectController.pelangganModel.insertPelanggan(new Fatchur07109_PelangganEntity(pass[i], nama[i], no_telp[i], alamat[i], berat[i], nik[i], new Date(tanggal[i])));
        };
    }

    public void login(int nik, String password) {
        indexLogin = Fatchur07109_AllObjectController.pelangganModel.cekData(nik, password);
    }

    public void viewPelanggan() {
        Fatchur07109_AllObjectController.pelangganModel.view();
    }

    public String showNamePaket(int indexPaket) {
        return Fatchur07109_AllObjectController.daftarPelangganModel.showNamePaket(indexPaket);
    }

    public void postData(String password, String nama, String no_telp, String alamat, int berat, int nik, Date tgllahir, String inAction) {
        if (inAction == "editPelanggan") {
            Fatchur07109_AllObjectController.pelangganModel.updatePelanggan(indexLogin, new Fatchur07109_PelangganEntity(password, nama, no_telp, alamat, berat, nik, tgllahir));
        } else if (inAction == "newPelanggan") {
            Fatchur07109_AllObjectController.pelangganModel.insertPelanggan(new Fatchur07109_PelangganEntity(password, nama, no_telp, alamat, berat, nik, tgllahir));
        }
    }

    public void registerAntrian(int indexPaket, Fatchur07109_PelangganEntity pelangganEntity) {
        Fatchur07109_AllObjectController.daftarPelangganModel.insertDataDaftarpelanggan(new Fatchur07109_DaftarPelangganEntity(pelangganEntity, indexPaket));

    }
}
