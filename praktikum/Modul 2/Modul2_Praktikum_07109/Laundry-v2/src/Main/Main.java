/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.ArrayList;
import java.util.Scanner;
import Model.*;
import Entity.*;
/**
 *
 * @author ozie
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static ArrayList <PesananModel> pesan = new ArrayList();
    static ArrayList <TransaksiModel> trans = new ArrayList();
    static KaryawanModel Karyawan = new KaryawanModel();
    static PaketModel paket = new PaketModel();
    static ArrayList <KatalogEntity> checkOut = new ArrayList();
    public static void main(String[] args) {
        int pil;
        data_karyawan();
        data_paket();
        do{
        System.out.println("1. Pencucian");
        System.out.println("2. Admin");
        System.out.println("0. Exit");
        System.out.print("Pilih -> ");
        pil = input.nextInt();
        switch (pil){
            case 1:
                pesanan();
                break;
            case 2:
                transaksi();
                break;
        }
        }while(pil!=0);
    }
    
    
    public static void data_karyawan(){
        String id_pencuci[] = {"01","02"};
        String nama_pencuci[] = {"Cuci", "Cuciex"};
        String pass_pencuci[] = {"cuci", "cuciex"};
        
        String id_admin[] = {"6","2"};
        String nama_admin[] = {"Admin","User"};
        String pass_admin[] = {"admin","user"};
        
        for(int i=0;i<id_pencuci.length;i++){
            Karyawan.insert_karyawan(new PencuciEntity(id_pencuci[i],nama_pencuci[i],pass_pencuci[i]), 
                    new AdminEntity(id_admin[i],nama_admin[i],pass_admin[i]));
        }
        
    }
    
    public static void data_paket(){
        String nama_paket[] = {"CUCI KERING","CUCI BASAH","CUCI SETRIKA"};
        int harga_paket[] = {14000,10000,20000};
        int berat_paket[] = {2,1,4} ;
        for(int i=0;i<nama_paket.length;i++){
            paket.insert_paket(new KatalogEntity(nama_paket[i],harga_paket[i],berat_paket[i]));
        }
    }
    
 
    public static void pesanan(){
        System.out.println("Login Pencuci");
        System.out.print("Nama Pencuci = ");
        String nama_pencuci = input.next();
        System.out.print("Password = ");
        String pass_pencuci = input.next();
        int index=0,pil;
        String ulang;
        boolean ketemu = false;
        for(int i= 0;i<Karyawan.getDataPencuci().size();i++){
            if(nama_pencuci.equals(Karyawan.getDataPencuci().get(i).getNama())&&
                    pass_pencuci.equals(Karyawan.getDataPencuci().get(i).getPassword())){
                index = i;
                ketemu = true;
            }
        }
        if(ketemu == true){
            do{
                System.out.println("1. input data cucian");
                System.out.println("2. logout");
                System.out.print("pilih = ");
                pil = input.nextInt();
                if (pil==1){
                    System.out.print("Id Pesan = ");
                    String id_pesan = input.next();
                    System.out.print("Nama Pelanggan = ");
                    String nama_pel = input.next();
                    do{
                    System.out.println("pilih paket");
                    for(int i=0;i<paket.getPaket().size();i++){
                        System.out.println(i+" "+paket.getPaket().get(i).getNama_paket()+" "+paket.getPaket().get(i).getHarga_paket()+" min berat "+paket.getPaket().get(i).getBerat_paket());
                    }
                        System.out.print("pilih = ");
                        int pilih = input.nextInt();
                        checkOut.add(paket.getPaket().get(pilih));
                     System.out.println("beli lagi ? (y/n) = ");
                        ulang = input.next();
                    }while(ulang.equals("y")||ulang.equals("Y"));
                    pesan.add(new PesananModel(id_pesan,nama_pel,Karyawan.getDataPencuci().get(index),checkOut));
                    checkOut = new ArrayList();
                }
            }while(pil!=2);
            view_pesan();
        }else{
            System.out.println("nama dan password tidak cocok");
        }
        
    }
    
    public static void view_pesan(){
        for(int i=0;i<pesan.size();i++){
            System.out.println("nama pembeli = "+pesan.get(i).getNama());
            System.out.println("nama Admin = "+pesan.get(i).getAdmin().getNama());
            System.out.println("paket pesanan");
            for(int j=0;j<pesan.get(i).getCheckout().size();j++){
                System.out.println((j+1)+". "+pesan.get(i).getCheckout().get(j).getNama_paket()+" || "+pesan.get(i).getCheckout().get(j).getHarga_paket()+" || "+pesan.get(i).getCheckout().get(j).getBerat_paket());
            }
            System.out.println("Total Harga = "+pesan.get(i).total_harga());
        }
    }
    public static void transaksi(){
        System.out.print("Nama Admin = ");
        String nama_admin = input.next();
        System.out.print("Password Admin = ");
        String pass_admin = input.next();
        int index=0,pil;
        boolean ketemu = false;
        double total = 0;
        for(int i= 0;i<Karyawan.getDataAdmin().size();i++){
            if(nama_admin.equals(Karyawan.getDataAdmin().get(i).getNama())&&
                    pass_admin.equals(Karyawan.getDataAdmin().get(i).getPassword())){
                index = i;
                ketemu = true;
            }
        }
        if(ketemu == true){
            System.out.println("1. Transaksi");
            System.out.println("2. Logout");
            System.out.print("Pilih = ");
            pil = input.nextInt();
            if(pil==1){
                System.out.print("Id Pesan = ");
                String id_pesan = input.next();
                for(int i = 0;i<pesan.size();i++){
                    if(id_pesan.equals(pesan.get(i).getId_pesan())){
                        System.out.println("Nama Pelanggan = "+pesan.get(i).getNama());
                        System.out.println("Nama Pencuci = "+pesan.get(i).getAdmin().getNama());
                        total = pesan.get(i).total_harga();
                        view_pesan();
                    }
                }
                System.out.print("Bayar = ");
                double bayar=input.nextDouble();
                System.out.println("Sistem Bayar = ");
                for(int i=0;i<PayEntity.metode.length;i++){
                    System.out.println(i+". "+PayEntity.metode[i]);
                }
                System.out.print("Pilih = ");
                int pilih = input.nextInt();
                trans.add(new TransaksiModel(Karyawan.getDataAdmin().get(index),pilih));
                System.out.println("Kembali = "+(bayar-total));
            }
        }else{
            System.out.println("nama atau password tidak cocok");
        }
    }
}

