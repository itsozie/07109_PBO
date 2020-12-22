/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ozie
 */
import Entity.AdminEntity;
import Entity.PayEntity;
public class TransaksiModel {
    AdminEntity admin;
    int index_bayar;

    public AdminEntity getAdmin() {
        return admin;
    }

    public int getIndex_bayar() {
        return index_bayar;
    }

    public TransaksiModel(AdminEntity admin, int index_bayar) {
        this.admin = admin;
        this.index_bayar = index_bayar;
    }
    public double kembalian(double harga,double bayar){
        double kembali;
        kembali = bayar-harga;
        return kembali;
    }
}
