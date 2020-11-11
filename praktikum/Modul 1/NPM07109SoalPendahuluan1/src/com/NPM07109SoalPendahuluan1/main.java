package com.NPM07109SoalPendahuluan1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static ArrayList <AslabEntity> dataAslab = new ArrayList<>();
    static ArrayList <PraktikanEntity> dataPraktikan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Laboratorium Informatika ITATS !!");
        int pil;
        DataAslab();
        do {
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Pilih = ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    daftar();
                    break;
                case 2:
                    System.out.println("NPM = ");
                    String npm = input.next();
                    System.out.println("Password = ");
                    String pass = input.next();
                    view(npm, pass);
                    break;
            }
        } while(pil != 3);
    }

    static void daftar() {
        System.out.println("Input NPM = ");
        String npm  = input.next();
        System.out.println("Input Nama = ");
        String nama  = input.next();
        System.out.println("Input Password = ");
        String pass  = input.next();
        System.out.println("Input No. Telepon = ");
        String notelp  = input.next();
        System.out.println("Input Tanggal Lahir (dd/mm/yyyy) = ");
        Date tanggal = new Date(input.next());
        System.out.println("Kelas = ");
        String kelas = input.next();

        for(int i = 0; i < dataAslab.size(); i++) {
            System.out.println(i+". "+dataAslab.get(i).nama);
        }
        System.out.println("Pilih Aslab = ");
        int indexAslab = input.nextInt();

        for(int i = 0; i < PraktikumEntity.Praktikum.length; i++) {
            System.out.println(i+". "+PraktikumEntity.Praktikum[i]);
        }
        System.out.println("Pilih Praktikum = ");
        int indexPrak = input.nextInt();
        dataPraktikan.add(new PraktikanEntity(npm,nama,pass,notelp,tanggal,indexPrak,indexAslab,kelas));
    }

    static void view(String npm, String password) {
        for(int i = 0; i < dataPraktikan.size(); i++) {
            System.out.println("NPM = "+dataPraktikan.get(0).getNpm());

            if(npm.equals(dataPraktikan.get(i).getNpm()) && password.equals(dataPraktikan.get(i).getPassword())) {
                System.out.println("NPM = "+dataPraktikan.get(i).getNpm());
                System.out.println("Nama = "+dataPraktikan.get(i).getNama());
                System.out.println("Tanggal Lahir = "+new SimpleDateFormat("dd-MM-yyyy").format(dataPraktikan.get(i).getDate()));
                System.out.println("No. Telp = "+dataPraktikan.get(i).getNotelp());
                System.out.println("Nama Asisten = "+dataAslab.get(dataPraktikan.get(i).indexAslab).getNama());
            }
        }
    }

    static void DataAslab() {
        String npmAslab [] = {"01","02","03","04","05","06","07"};
        String passwordAslab [] = {"01","02","03","04","05","06","07"};
        String namaAslab [] = {"Michael", "Fadlan", "Odila", "Fitria", "Sita", "Eric", "Fernanda"};
        String notelpAslab [] = {"01","02","03","04","05","06","07"};
        String tglLahirAslab [] = {
                "04/05/2000", "01/12/2000", "03/3/2000", "23/6/2000", "11/3/2000", "13/9/2000", "22/12/2000"
        };
        for(int i = 0; i < npmAslab.length; i++) {
            dataAslab.add(new AslabEntity(npmAslab[i],namaAslab[i],passwordAslab[i],notelpAslab[i],new Date(tglLahirAslab[i])));
        }
    }
}
