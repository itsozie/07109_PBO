package com.NPM07109SoalPendahuluan1;

import java.util.Date;
public class PraktikanEntity {
    String npm,nama,password,notelp,kelas;
    Date TanggalLahir;
    int indexPraktikum;
    int indexAslab;

    public PraktikanEntity(String npm, String nama, String password, String notelp, Date TanggalLahir, int indexPraktikum, int indexAslab, String kelas) {
        this.npm            = npm;
        this.nama           = nama;
        this.password       = password;
        this.notelp         = notelp;
        this.TanggalLahir   = TanggalLahir;
        this.indexPraktikum = indexPraktikum;
        this.indexAslab     = indexAslab;
        this.kelas          = kelas;
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

    int getIndexPraktikum() {
        return this.indexPraktikum;
    }
}

