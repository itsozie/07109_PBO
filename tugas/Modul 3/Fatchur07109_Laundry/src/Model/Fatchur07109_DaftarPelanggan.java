/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author Ozie
 */
import Entity.Fatchur07109_DaftarPelangganEntity;
import Entity.Fatchur07109_PaketEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Fatchur07109_DaftarPelanggan {

    private ArrayList<Fatchur07109_DaftarPelangganEntity> daftarPelangganArrayList;

    public Fatchur07109_DaftarPelanggan() {
        daftarPelangganArrayList = new ArrayList<Fatchur07109_DaftarPelangganEntity>();
    }

    public void insertDataDaftarpelanggan(Fatchur07109_DaftarPelangganEntity daftarPelanggan) {
        daftarPelangganArrayList.add(daftarPelanggan);
    }

    public void deleteListPelanggan(int indexPelanggan) {
        daftarPelangganArrayList.remove(indexPelanggan);
    }

    public String showNamePaket(int indexPaket) {
        return Fatchur07109_PaketEntity.nama[indexPaket];
    }

    public void view(int IndexPaket) {
        int index = 0;
        for (Fatchur07109_DaftarPelangganEntity daftarPelanggan : daftarPelangganArrayList) {
            if (daftarPelangganArrayList.size() == 0) {
                System.out.println("Data Kosong !!!");
            } else {
                if (IndexPaket == daftarPelanggan.getIndexpaket()) {
                    System.out.println("===============================================================");
                    System.out.println("No : " + (index++)
                            + "\nID            : " + daftarPelanggan.getPelanggan().getId()
                            + "\nNama          : " + daftarPelanggan.getPelanggan().getNama()
                            + "\nNo Telp       : " + daftarPelanggan.getPelanggan().getNo_telp()
                            + "\nBerat         : " + daftarPelanggan.getPelanggan().getBerat() + "Kg"
                            + "\nAlamat        : " + daftarPelanggan.getPelanggan().getAlamat()
                            + "\nPaket         : " + Fatchur07109_PaketEntity.nama[daftarPelanggan.getIndexpaket()]
                            + "\nTanggal Masuk : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarPelanggan.getPelanggan().getTgl()));
                    System.out.println("===============================================================");
                }
            }
        }
    }

}
