package ManajemenLaundry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
//    MEMODIFIKASI STATIC MENJADI PUBLIC
public ArrayList<fatchur_07109_OwnerEntity> dataOwner = new ArrayList();
public Scanner input;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int pilih,indexdat ;
        System.out.println("Sistem Manajemen Laundry");
        do{
            System.out.println("1. Input");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus");
            System.out.println("5. exit");
            System.out.println("Pilih =");
            
            pilih = input.nextInt();
            switch(pilih){
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
        }while(pilih!=5);
    }
    public void add(){
         System.out.print("input nama pelanggan = ");
         String fatchur_07109_nama_pelanggan = input.next();
         System.out.print("input Tgl masuk (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_masuk = new Date(input.next());
         System.out.print("input nama pegawai = ");
         String fatchur_07109_pegawai = input.next();
         System.out.print("input jenis cucian");
         System.out.print("CK / CB / CS  = ");
         String fatchur_07109_katalog = input.next();
         System.out.print("input berat Cucian = ");
         float fatchur_07109_berat_cucian = input.nextByte();
         System.out.print("input Tgl Selesai (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_selesai = new Date(input.next());
         dataOwner.add(new fatchur_07109_OwnerEntity(fatchur_07109_nama_pelanggan,
         fatchur_07109_tanggal_masuk,fatchur_07109_pegawai,
         fatchur_07109_katalog,fatchur_07109_berat_cucian,fatchur_07109_tanggal_selesai));
         
    }

    
    public void view(){
        for(int i=0;i<dataOwner.size();i++){
            System.out.println("==========================================================");
            System.out.println("transaksi:"+i);
            System.out.println("nama = "+dataOwner.get(i).getFatchur_07109_nama_pelanggan());
            System.out.println("Tanggal Masuk = "+new SimpleDateFormat("dd-MM-yyyy").format(dataOwner.get(i)
                    .getFatchur_07109_tanggal_masuk()));
            System.out.println("pegawai yang melayani = "+dataOwner.get(i).getFatchur_07109_pegawai());
            System.out.println("Jenis cucian =  " + dataOwner.get(i).getFatchur_07109_katalog() + 
                    " [ " + dataOwner.get(i).getTipekatalog() + " ]");
            System.out.println("berat Cucian = "+dataOwner.get(i).getFatchur_07109_berat_cucian()+" Kg");
            System.out.println("Tanggal Selesai = "+new SimpleDateFormat("dd-MM-yyyy").format(dataOwner.get(i)
                    .getFatchur_07109_tanggal_selesai()));
            System.out.println("==========================================================");            
        }
    }
    
    public void update(int indexdat){
        System.out.print("input nama pelanggan = ");
         String fatchur_07109_nama_pelanggan = input.next();
         System.out.print("input Tgl masuk (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_masuk = new Date(input.next());
         System.out.print("input nama pegawai = ");
         String fatchur_07109_pegawai = input.next();
         System.out.print("input jenis cucian = ");
         String fatchur_07109_katalog = input.next();
         System.out.print("input berat cucian = ");
         float fatchur_07109_berat = input.nextByte();
         System.out.print("input Tgl Selesai (dd/mm/yyyy) = ");
         Date fatchur_07109_tanggal_selesai = new Date(input.next());
         dataOwner.set(indexdat,new fatchur_07109_OwnerEntity(fatchur_07109_nama_pelanggan,
         fatchur_07109_tanggal_masuk,fatchur_07109_pegawai,
         fatchur_07109_katalog,fatchur_07109_berat,fatchur_07109_tanggal_selesai));  
    }
    
    public void delete(int indexdat){
     dataOwner.remove(indexdat);
     System.out.println("Data Di hapus");
        
    }
    
}

