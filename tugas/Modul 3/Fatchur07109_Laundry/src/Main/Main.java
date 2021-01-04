package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ozie
 */
import Entity.*;
import Controller.*;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Fatchur07109_PelangganController pelanggan = new Fatchur07109_PelangganController();
    private static Fatchur07109_AdminController admin = new Fatchur07109_AdminController();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("SISTEM LAUNDRY V3");
        admin.dataAdmin();
        pelanggan.dataPelanggan();
        menu();
    }

    static void menu() {
        int loop = 0;
        do {
            int pilih = 0;
            System.out.print(" 1. Login"
                    + "\n 2. Daftar Pelanggan"
                    + "\n 0. Stop"
                    + "\n Masukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if (pilih == 1) {
                int pilLogin = 0;
                System.out.print(" 1. Login Admin"
                        + "\n 2. Login Pelanggan"
                        + "\n Pilih : ");
                pilLogin = input.nextInt();
                if (pilLogin == 1) {
                    loginAdmin();
                } else {
                    loginPelanggan();
                }
            } else if (pilih == 2) {
                register();
            } else {
                break;
            }
        } while (loop != 1);
    }

    static void register() {
        try {
            System.out.print("Input ID = ");
            int nik = input.nextInt();
            System.out.print("Input Nama = ");
            String nama = input.next();
            System.out.print("Input Password = ");
            String pass = input.next();
            System.out.print("Input Alamat = ");
            String alamat = input.next();
            System.out.print("berat = ");
            int berat = input.nextInt();
            System.out.print("Input Tanggal Masuk (dd/mm/yyyy) = ");
            Date tanggal = new Date(input.next());
            System.out.print("No Telp = ");
            String no_telp = input.next();
            pelanggan.postData(pass, nama, no_telp, alamat, berat, nik, tanggal, "newPelanggan");
        } catch (Exception exception) {
            System.out.println("Format Pengisian Salah !!!");
        }
    }

    static void loginPelanggan() {
        System.out.print("ID : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        try {
            pelanggan.login(nik, password);
            System.out.println("Selamat Datang " + pelanggan.pelangganEntity().getNama());
            menuPelanggan();
        } catch (Exception exception) {
            System.out.println("Data Pelanggan Tidak Ditemukan !!!");
        }
    }

    static void menuPelanggan() {
        int pilihMenuPelanggan;
        System.out.print("1. Edit Data"
                + "\n2. Daftar Sebagai Antrian"
                + "\n0. Back to Menu"
                + "\n Masukkan Pilihan Anda : ");
        pilihMenuPelanggan = input.nextInt();
        if (pilihMenuPelanggan == 1) {
            System.out.print("Input ID = ");
            int nik = input.nextInt();
            System.out.print("Input Nama = ");
            String nama = input.next();
            System.out.print("Input Password = ");
            String pass = input.next();
            System.out.print("Input Alamat = ");
            String alamat = input.next();
            System.out.print("berat = ");
            int berat = input.nextInt();
            System.out.print("Input Tanggal Masuk (dd/mm/yyyy) = ");
            Date tanggal = new Date(input.next());
            System.out.print("No Telp = ");
            String no_telp = input.next();
            pelanggan.postData(pass, nama, no_telp, alamat, berat, nik, tanggal, "editPelanggan");
        } else if (pilihMenuPelanggan == 2) {
            pendaftaranAntrian();
        } else {
            menu();
        }
    }

    static void loginAdmin() {
        System.out.print("ID : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        try {
            admin.login(nik, password);
            System.out.println("Selamat datang " + admin.adminEntity().getNama()
                    + " Dari " + admin.showPaketAdmin(admin.adminEntity().getpaket()));
            menuAdmin();
        } catch (Exception exception) {
            System.out.println("Data Admin Tidak Ditemukan !!!");
        }
    }

    static void menuAdmin() {
        int pilihMenuAdmin;
        System.out.print("1. List Antrian"
                + "\n2. Delete Antrian"
                + "\n0. Back to Menu"
                + "\n Masukkan Pilihan Anda : ");
        pilihMenuAdmin = input.nextInt();
        if (pilihMenuAdmin == 1) {
            admin.listAntrianPaket(admin.adminEntity().getpaket());
            menuAdmin();
        } else if (pilihMenuAdmin == 2) {
            deleteAntrianPelanggan();
        } else {
            menu();
        }
    }

    static void deleteAntrianPelanggan() {
        System.out.print("Delete Nomor Ke : ");
        int indexList = input.nextInt();
        try {
            admin.deleteListAntrianPelanggan(indexList);
        } catch (Exception exception) {
            System.out.println("Data Yang Anda Inputkan Salah");
        }
    }

    static void pendaftaranAntrian() {
        System.out.println("Silahkan Pilih Paket Yang Dituju ");
        for (int i = 0; i < Fatchur07109_PaketEntity.nama.length; i++) {
            System.out.println(i + ". " + Fatchur07109_PaketEntity.nama[i]);
        }
        System.out.print("Pilih Paket = ");
        int pilPaket = input.nextInt();
        try {
            pelanggan.registerAntrian(pilPaket, pelanggan.pelangganEntity());
            System.out.println("Anda Sudah Terdaftar Di Paket = " + pelanggan.showNamePaket(pilPaket));
        } catch (Exception exception) {
            System.out.println("Data Yang Anda Inputkan Salah");
        }
    }
}
