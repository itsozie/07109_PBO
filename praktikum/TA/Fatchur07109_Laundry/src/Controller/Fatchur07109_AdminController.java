/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
/**
 *
 * @author Ozie
 */
import Entity.*;
import java.util.Date;

public class Fatchur07109_AdminController {
    
    int indexLogin = 0;
    
    public Fatchur07109_AdminController() {
    }
//password, nama, no_telp, alamat, berat, nik, tgl
    public void dataAdmin() {
        int nik[] = {01, 02, 03};
        String pass[] = {"01", "02", "03"};
        String nama[] = {"Admin", "Admin", "Admin"};
        String notelp[] = {"01", "02", "03"};
        int paket[] = {0, 1, 2};
        int berat[] = {0,1,2};
        String alamat[] = {"Kemayoran", "Dupak", "TP"};
        String tgl[] = {"04/05/2000", "01/12/2000", "03/03/2000"};
        for (int i = 0; i < nik.length; i++) {
            Fatchur07109_AllObjectController.adminModel.insertAdmin(new Fatchur07109_AdminEntity(paket[i], pass[i], nama[i],
                    notelp[i], alamat[i], berat[i], nik[i], new Date(tgl[i])));
        };
    }
    
    public void viewAdmin() {
        Fatchur07109_AllObjectController.adminModel.view();
    }
    
    public String showPaketAdmin(int indexPaket) {
        return Fatchur07109_AllObjectController.adminModel.showPaketAdmin(indexPaket);
    }
    
    public void listAntrianPaket(int indexPaket) {
        Fatchur07109_AllObjectController.daftarPelangganModel.view(indexPaket);
    }
    
    public void login(int id, String password) {
        indexLogin = Fatchur07109_AllObjectController.adminModel.cekData(id, password);
    }
    
    public Fatchur07109_AdminEntity adminEntity() {
        return Fatchur07109_AllObjectController.adminModel.showDataAdmin(indexLogin);
    }
    
    public void deleteListAntrianPelanggan(int indexPelanggan) {
        Fatchur07109_AllObjectController.daftarPelangganModel.deleteListPelanggan(indexPelanggan);
    }
    
}
