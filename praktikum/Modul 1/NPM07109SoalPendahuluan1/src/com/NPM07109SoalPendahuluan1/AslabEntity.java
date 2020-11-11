package com.NPM07109SoalPendahuluan1;
import java.util.Date;

public class AslabEntity {
    String npm,nama,password,notelp;
    Date TanggalLahir;

    public AslabEntity(String npm, String nama, String password, String notelp, Date TanggalLahir) {
        this.npm            = npm;
        this.nama           = nama;
        this.password       = password;
        this.notelp         = notelp;
        this.TanggalLahir   = TanggalLahir;
    }

    String getNpm() {
        return this.npm;
    }

    String getNama() {
        return this.nama;
    }

    String getPassword() {
        return this.password;
    }

    String getNotelp() {
        return this.notelp;
    }

    Date getDate() {
        return this.TanggalLahir;
    }
}

