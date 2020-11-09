package ManajemenLaundry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
static ArrayList<fatchur_07109_OwnerEntity> dataOwner = new ArrayList();
static ArrayList<fatchur_07109_KatalogCucian> jenisCucian = new ArrayList();
static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Sistem Manajemen Laundry");
        int pil;
        int indexdat;
        do{
            System.out.println("1. Input");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus");
            System.out.println("5. exit");
            System.out.println("Pilih =");
            pil = input.nextInt();
            
            switch(pil){
                 case 1:
                    add();
                    break;
                 case 2:
                     view();
                     break;
                 case 3:
                     view();
                     System.out.println("Masukkan Transaksi yang ingin di update");
                     indexdat = input.nextInt();
                     update(indexdat);
                     break;
                 case 4:
                     view();
                     System.out.println("Masukkan Transaksi yang ingin di delete");
                     indexdat = input.nextInt();
                     delete(indexdat);
                     break;
                
            }
        }while(pil!=5);
    }
    static void add(){
         System.out.print("input nama pelanggan = ");
         String fatchur_07109_nama_pelanggan = input.next();
         System.out.print("input Tgl masuk (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_masuk = new Date(input.next());
         System.out.print("input antrian = ");
         String fatchur_07109_antrian = input.next();
           for(int i=0;i<fatchur_07109_KatalogCucian.katalog.length;i++){
             System.out.println(i+". "+fatchur_07109_KatalogCucian.katalog[i]);
         }
         System.out.print("input paket katalog = ");
         int fatchur_07109_indexpaket = input.nextInt();
         System.out.print("input nama pegawai = ");
         String fatchur_07109_pegawai = input.next();
       
         System.out.print("input berat Cucian = ");
         float fatchur_07109_berat_cucian = input.nextByte();
         System.out.print("input Tgl Selesai (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_selesai = new Date(input.next());
         dataOwner.add(new fatchur_07109_OwnerEntity(fatchur_07109_nama_pelanggan,
         fatchur_07109_tanggal_masuk,fatchur_07109_antrian,fatchur_07109_indexpaket,fatchur_07109_pegawai,
        fatchur_07109_berat_cucian,fatchur_07109_tanggal_selesai));
         
    }

    
    static void view(){
        for(int i=0;i<dataOwner.size();i++){
            System.out.println("==========================================================");
            System.out.println("transaksi:"+i);
            System.out.println("nama = "+dataOwner.get(i).getFatchur_07109_nama_pelanggan());
            System.out.println("Tanggal Masuk = "+new SimpleDateFormat("dd-MM-yyyy").format(dataOwner.get(i).getFatchur_07109_tanggal_masuk()));
            System.out.println("antrian = "+dataOwner.get(i).getFatchur_07109_antrian());
            System.out.println("Paket Cuci = "+fatchur_07109_KatalogCucian.katalog[dataOwner.get(i).Fatchur_07109_indexpaket]);
            System.out.println("pegawai yang melayani = "+dataOwner.get(i).getFatchur_07109_pegawai());
            System.out.println("berat Cucian = "+dataOwner.get(i).getFatchur_07109_berat_cucian()+" Kg");
            System.out.println("Tanggal Selesai = "+new SimpleDateFormat("dd-MM-yyyy").format(dataOwner.get(i).getFatchur_07109_tanggal_selesai()));
            System.out.println("==========================================================");
            
            
            
        }
    }
    
    static void update(int indexdat){
        System.out.print("input nama pelanggan = ");
         String fatchur_07109_nama_pelanggan = input.next();
         System.out.print("input Tgl masuk (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_masuk = new Date(input.next());
         System.out.print("input antrian = ");
         String fatchur_07109_antrian = input.next();
           for(int i=0;i<fatchur_07109_KatalogCucian.katalog.length;i++){
             System.out.println(i+". "+fatchur_07109_KatalogCucian.katalog[i]);
         }
         System.out.print("input paket katalog = ");
         int fatchur_07109_indexpaket = input.nextInt();
         System.out.print("input nama pegawai = ");
         String fatchur_07109_pegawai = input.next();
       
         System.out.print("input berat cucian = ");
         float fatchur_07109_berat_katalogan = input.nextByte();
         System.out.print("input Tgl Selesai (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_selesai = new Date(input.next());
         dataOwner.set(indexdat,new fatchur_07109_OwnerEntity(fatchur_07109_nama_pelanggan,
         fatchur_07109_tanggal_masuk,fatchur_07109_antrian,fatchur_07109_indexpaket,fatchur_07109_pegawai,
         fatchur_07109_berat_katalogan,fatchur_07109_tanggal_selesai));
        
    }
    
    static void delete(int indexdat){
      
     dataOwner.remove(indexdat);
     System.out.println("Data Di hapus");
        
    }
    
}

