package Owner;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ozie
 */
public class OwnerMain {
    public ArrayList<Owner>dataKaryawan   = new ArrayList();
    public ArrayList<Jabatan>dataJabatan     = new ArrayList();
    public Scanner input;

    /**
     *
     * @param 
     */
    public static void main(String[] args) {
        OwnerMain m = new OwnerMain();
        m.menu();
    }



   public void menu() {
        jabatan();

        input = new Scanner(System.in);
        int selectedMenu, id;

        do {
            System.out.println("==== Laundry Berkah ====");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Keluar");
            System.out.println("--------------------");
            System.out.print("Pilih menu> ");

            selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Masukan Id pekerja: ");
                    id = input.nextInt();

                    update(id);
                    break;
                case 4:
                    System.out.println("Masukkan id:");
                    id = input.nextInt();

                    delete(id);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Kamu salah pilih menu!");
            }
        } while(selectedMenu != 5);
    }

    public void add() {
        String pilihKatalog;
        
        System.out.println("Masukan id: ");
        int id = input.nextInt();
        
        System.out.println("Masukan Nama: ");
        String nama = input.next();

        System.out.println("Masukan Alamat: ");
        String alamat = input.next();
        
        
        System.out.println("Pilih Jabatan : ");
        for(int i = 0; i < dataJabatan.size(); i++) {
            System.out.print("[" + dataJabatan.get(i).kodejabatan + "] ");
            System.out.print(dataJabatan.get(i).jabatan + "\n");
        }
        
        System.out.print("Masukkan kode Jabatan yang dipilih: ");
        pilihKatalog = input.next();

        Owner owner = new Owner(id);

        for(int i = 0; i < dataJabatan.size(); i++) {
            if(dataJabatan.get(i).kodejabatan.equals(pilihKatalog)) {
                Jabatan katalog = new Jabatan(dataJabatan.get(i).kodejabatan, dataJabatan.get(i).jabatan);
                
                dataJabatan.get(i).setJabatan(owner);
                owner.setKatalog(katalog);
            }
        }

        owner.setNama(nama);
        owner.setAlamat(alamat);
        dataKaryawan.add(owner);
    }

    
    
    public void update(int id) {
        for(int i = 0; i < dataKaryawan.size(); i++) {
            if(dataKaryawan.get(i).getID() == id) {
                System.out.println("--------------------");
                System.out.println("Nama: " + dataKaryawan.get(i).getNama());
                System.out.println("ID: " + dataKaryawan.get(i).getID());
                System.out.println("--------------------");

                System.out.println("Masukan nama: ");
                String nama = input.next();
                System.out.println("Masukan Alamat: ");
                String alamat = input.next();
                System.out.println("Masukan id: ");
                int idBaru = input.nextInt();

                dataKaryawan.get(i).setNama(nama);
                dataKaryawan.get(i).setAlamat(alamat);
                dataKaryawan.get(i).setID(idBaru);
            }
        }
    }

    
    
    public void read() {
        if(dataKaryawan.size() > 0) {
            for (int i = 0; i < dataKaryawan.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Nama: " + dataKaryawan.get(i).getNama());
                System.out.println("Alamat: " + dataKaryawan.get(i).getAlamat());
                System.out.println("id: " + dataKaryawan.get(i).getID());

                if(dataKaryawan.get(i).jabatan == null) {
                    System.out.println("Jabatan: -");
                } else {
                    System.out.println("Jabatan: " + dataKaryawan.get(i).jabatan.jabatan + " [ " + dataKaryawan.get(i).jabatan.kodejabatan + " ]");
                }

                System.out.println("--------------------");
            }
        } else {
            System.out.println("Belum ada data.");
        }
    }

    
    
    public void delete(int id) {
        if(id == 0) {
            dataKaryawan.clear();
            System.out.println("Data berhasil dihapus");
        } else {
            for(int i = 0; i < dataKaryawan.size(); i++) {
                if(dataKaryawan.get(i).getID() == id) {
                    System.out.println("Data katalog milik: " + dataKaryawan.get(i).getNama() + " berhasil terhapus");
                    dataKaryawan.remove(i);
                }
            }
        }
    }

    
    
    public void jabatan() {
        dataJabatan.add(new Jabatan("ADM", "Admin"));
        dataJabatan.add(new Jabatan("KR", "Karyawan Reguler"));
    }
    
}
