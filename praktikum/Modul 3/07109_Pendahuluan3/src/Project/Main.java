/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import Entity.PraktikumEntity07109;
import Controller.AdminController07109;
import Controller.AllObjectModel07109;
import Controller.PraktikanController07109;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static AdminController07109 admin = new AdminController07109();
    private static Scanner input = new Scanner(System.in);
    private static PraktikanController07109 praktikan = new PraktikanController07109();

    public static void main(String[] args) {
        int loop = 0;
        admin.dataAslab();
        do {
            int pilih = 0;
            System.out.print("Selamat Datang Di Laboratorium Informatika ITATS !!"+"\n 1. Login"+"\n 2. Daftar Praktikan"+"\n 0. Stop"+"\n Masukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if(pilih == 1) {
                int pilLogin = 0;
                System.out.print("1. Login Aslab"+"\n2. Login Praktikan"+"\nPilih : ");
                pilLogin = input.nextInt();
                if(pilLogin == 1) loginAslab();
                else loginPraktikan();
            } else if(pilih == 2) {
                registerPraktikan();
            } else if(pilih == 3) {
                admin.viewAslab07109();
            } else {
                break;
            }
        } while (loop!=1);
    }
    
    static void loginAslab() {
        System.out.print("NPM : ");
        String npm = input.next();
        System.out.print("Password : ");
        String password = input.next();
        try {
            admin.login(npm,password);
            System.out.println("Selamat Datang "+admin.aslabEntity().getNama()+" Dari Lab "+admin.aslabEntity().getLaboratorium());
            if(admin.cekdaftarprakModel().size() == 0) {
                System.out.println("Data Masih Kosong !!");
            } else {
                viewDaftarprak();
                updateIsVerified();
            }
        } catch (Exception exception) {
            System.out.println("NPM atau Password anda salah !!");
        }
    }
    
    static void loginPraktikan() {
        System.out.print("NPM : ");
        String npm = input.next();
        System.out.print("Password : ");
        String password = input.next();
        praktikan.login(npm,password);
        System.out.println("Selamat Datang "+praktikan.praktikanEntity().getNama());
        int cek = praktikan.cekDaftarprak(praktikan.praktikanEntity().getNpm());
        if(cek == -1) {
            System.out.println("Anda Belum Terdaftar Praktikum !!");
            registerPraktikum();
        } else if(cek == -2) {
            System.out.println("Anda Belum Terdaftar Praktikum !!");
            registerPraktikum();
        } else {
            System.out.println("====================================");
            System.out.print("NPM : "+praktikan.showDaftarprak(cek).getPraktikan().getNpm()+"\n Nama : "+praktikan.showDaftarprak(cek).getPraktikan().getNama()+"\n Password : "+praktikan.showDaftarprak(cek).getPraktikan().getPassword()+"\n No.Telp : "+praktikan.showDaftarprak(cek).getPraktikan().getNo_telp()+"\n Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(praktikan.showDaftarprak(cek).getPraktikan().getTglLahir())+"\n Praktikum : "+PraktikumEntity07109.nama[praktikan.showDaftarprak(cek).getIndexPrak()]+"\n IsVerified : ");
            if(praktikan.showDaftarprak(cek).isVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("Kelas : "+praktikan.showDaftarprak(cek).getPraktikan().getKelas());
            System.out.println("====================================");
        }
    }
    
    static void registerPraktikan() {
        try {
            System.out.print("Masukkan NPM : ");
            String npm = input.next();
            System.out.print("Masukkan Password : ");
            String password = input.next();
            System.out.print("Masukkan Nama : ");
            String nama = input.next();
            System.out.print("Masukkan No Telepon : ");
            String notelp = input.next();
            System.out.print("Masukkan Tanggal Lahir (dd/mm/yyyy) : ");
            Date tglLahir = new Date(input.next());
            System.out.print("Masukkan Kelas Anda : ");
            String kelas = input.next();
            praktikan.insert(npm,password,nama,notelp,tglLahir,kelas);
            System.out.println("Daftar Sukses !! ");
        } catch (Exception exception) {
            System.out.println("Format Pengisian Salah !! ");
        }
    }
    
    static void registerPraktikum() {
        System.out.println("Pilih Praktkum : ");
        for(int i=0;i<PraktikumEntity07109.nama.length;i++) {
            System.out.println((i)+" "+PraktikumEntity07109.nama[i]);
        }
        int pilPrak = input.nextInt();
        praktikan.daftarPraktikum(pilPrak, praktikan.getData(), false);
        admin.listPendaftarPraktikum07109();
    }
    
    static void viewDaftarprak() {
        admin.listPendaftarPraktikum07109();
    }
    
    static void updateIsVerified() {
        System.out.print("Masukkan NPM : ");
        String npm = input.next();
        int index = AllObjectModel07109.daftarprakModel07109.cekData(npm,null);
        admin.updateIsVerified(index, praktikan.showDaftarprak(index).getIndexPrak(), praktikan.showDaftarprak(index).getPraktikan());
    }
}