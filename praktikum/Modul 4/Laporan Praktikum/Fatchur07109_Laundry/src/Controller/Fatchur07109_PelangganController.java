package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entity.*;
import Model.Fatchur07109_DaftarPelanggan;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

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
        int id[] = {01, 02, 03};
        String pass[] = {"01", "02", "03"};
        String nama[] = {"koko", "kiki", "arni"};
        String no_telp[] = {"01", "02", "03"};
        int berat[] = {2,4,6};
        String alamat[] = {"surabayans", "sidoarjo", "gresik"};
        String tanggal[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < id.length; i++) {
            Fatchur07109_AllObjectController.pelangganModel.insertPelanggan(new Fatchur07109_PelangganEntity(pass[i], nama[i], no_telp[i], alamat[i], berat[i], id[i], new Date(tanggal[i])));
        };
    }

    public void login(int id, String password) {
        indexLogin = Fatchur07109_AllObjectController.pelangganModel.cekData(id, password);
    }

    public void viewPelanggan() {
        Fatchur07109_AllObjectController.pelangganModel.view();
    }

    public String showNamePaket(int indexPaket) {
        return Fatchur07109_AllObjectController.daftarPelangganModel.showNamePaket(indexPaket);
    }

    public void registerAntrian(int indexPaket, Fatchur07109_PelangganEntity pelangganEntity) {
        Fatchur07109_AllObjectController.daftarPelangganModel.insertDataDaftarpelanggan(new Fatchur07109_DaftarPelangganEntity(pelangganEntity, indexPaket));

    }
       
    public DefaultTableModel antrianPelanggan(int IndexPaket) {
        DefaultTableModel tblAntrianPelanggan = new DefaultTableModel();
        Object[] kolom = {"ID", "Nama", "No Telp", "Tgl Masuk", "Alamat", "Berat", "Paket"};
        tblAntrianPelanggan.setColumnIdentifiers(kolom);
        int size = Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().size();
        String verif = null ;
        for (int i = 0; i < size; i++) {
            if (IndexPaket == Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getIndexpaket()) {
                Object[] data = new Object[7];
                data[0] = Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getPelanggan().getId();
                data[1] = Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getPelanggan().getNama();
                data[2] = Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getPelanggan().getNo_telp();
                data[3] = new SimpleDateFormat("dd-mm-yyy").format(Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getPelanggan().getTgl());
                data[4] = Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getPelanggan().getAlamat();
                data[5] = Fatchur07109_AllObjectController.daftarPelangganModel.alldataplg().get(i).getPelanggan().getBerat();
                data[6] = Fatchur07109_AllObjectController.daftarPelangganModel.showNamePaket(IndexPaket);
                tblAntrianPelanggan.addRow(data);
            }
        }
        return tblAntrianPelanggan;
    }

    public void postData(String pass, String nama, String notelp, String alamat, int berat, int id, Date tgllahir, String inAction) {
         if (inAction == "editPelanggan") {
            Fatchur07109_AllObjectController.pelangganModel.updatePelanggan(indexLogin, new Fatchur07109_PelangganEntity(pass, nama, notelp, alamat, berat, id, tgllahir));
        } else if (inAction == "newPelanggan") {
            Fatchur07109_AllObjectController.pelangganModel.insertPelanggan(new Fatchur07109_PelangganEntity(pass, nama, notelp, alamat, berat, id, tgllahir));
        }
    }
}
