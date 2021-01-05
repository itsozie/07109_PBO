/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Ozie
 */
import Entity.*;
import Controller.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import View.GUI07109;

public class Main {

    private static AdminController07109 admin = new AdminController07109();
    private static Scanner input = new Scanner(System.in);
    private static PraktikanController07109 praktikan = new PraktikanController07109();

    public static void main(String[] args) {
        GUI07109 gui = new GUI07109();
    }
    
    static void registerPraktikan() {
        try {
            System.out.print("Masukkan NPM = ");
            String npm = input.next();
            System.out.print("Input Nama = ");
            String nama = input.next();
            System.out.print("Input Password = ");
            String pass = input.next();
            System.out.print("Input No Telp = ");
            String notelp = input.next();
            System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
            Date tanggal = new Date(input.next());
            System.out.print("Kelas = ");
            String kelas = input.next();
            praktikan.insert(npm, pass, nama, notelp, tanggal, kelas);
            System.out.println("Daftar Sukses !!");
        } catch (Exception exception) {
            System.out.println("Format Pengisian Salah !!!");
        }
    }

    static void loginPraktikan() {
        System.out.print("NPM : ");
        String npm = input.next();
        System.out.print("Password : ");
        String password = input.next();
        praktikan.login(npm, password);
        System.out.println("Selamat Datang " + praktikan.praktikanEntity().getNama());
        int cek = praktikan.cekDaftarprak(praktikan.praktikanEntity().getNpm());
        if (cek == -1) {
            System.out.println("Anda Belum Terdaftar Praktikum !!!");
            registerPraktikum();
        } else if (cek == -2) {
            System.out.println("Anda Belum Terdaftar Praktikum !!!");
            registerPraktikum();
        } else {
            System.out.println("===========================================");
            System.out.print("NPM : " + praktikan.showDaftarprak(cek).getPraktikan().getNama()
                    + "\n Password : " + praktikan.showDaftarprak(cek).getPraktikan().getPassword()
                    + "\n No. Telp : " + praktikan.showDaftarprak(cek).getPraktikan().getNo_telp()
                    + "\n Tanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy")
                    .format(praktikan.showDaftarprak(cek).getPraktikan().getTgllahir())
                    + "\n Praktikum : " + PraktikumEntity07109.nama[praktikan.showDaftarprak(cek).getIndexPrak()]
                    + "\n IsVerified : ");
            if (praktikan.showDaftarprak(cek).isVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("Kelas : " + praktikan.showDaftarprak(cek).getPraktikan().getKelas());
            System.out.println("===========================================");
        }
    }

    static void registerPraktikum() {
        System.out.println("Pilih Praktikum : ");
        for (int i = 0; i < PraktikumEntity07109.nama.length; i++) {
            System.out.println((i) + " " + PraktikumEntity07109.nama[i]);
        }
        System.out.print("Pilih Praktikum = ");
        int pilPrak = input.nextInt();
        praktikan.daftarPraktikum(pilPrak, praktikan.getData(), false);
        admin.listPendaftarPraktikum();
    }

    static void viewDaftarprak() {
        admin.listPendaftarPraktikum();
    }

    static void loginAslab() {
        System.out.print("NPM : ");
        String npm = input.next();
        System.out.print("Password : ");
        String password = input.next();
        try {
            admin.login(npm, password);
            System.out.println("Selamat Datang "
                    + admin.aslabEntity().getNama()
                    + " Dari Lab " + admin.aslabEntity().getLaboratorium());
            if (admin.cekdaftarprakModel().size() == 0) {
                System.out.println("Data Masih Kosong");
            } else {
                viewDaftarprak();
                updateIsverified();
            }
        } catch (Exception exception) {
            System.out.println("Npm atau Password salah !!!");
        }
    }

    static void updateIsverified() {
        System.out.print("NPM Praktikan : ");
        String npm = input.next();
        int index = AllObjectModel07109.daftarprakModel.cekData(npm, npm);
        admin.updateIsVerified(index, praktikan.showDaftarprak(index).getIndexPrak(), praktikan.showDaftarprak(index).getPraktikan());
    }

}
