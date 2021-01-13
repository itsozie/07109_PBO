/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
/**
 *
 * @author Ozie
 */
public abstract class Fatchur07109_UserAbstractEntity {

    protected String password, nama, no_telp, alamat;
    protected int id, berat;
    protected Date tgl;

    public Fatchur07109_UserAbstractEntity(String password, String nama, String no_telp, String alamat, int berat, int id, Date tgl) {
        this.password = password;
        this.nama = nama;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.berat = berat;
        this.id = id;
        this.tgl = tgl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

}
