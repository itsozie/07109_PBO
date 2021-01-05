/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Ozie
 */
import Entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class PraktikanController07109 implements ControllerInterface07109 {

    int indexLogin = 0;

    public PraktikanController07109() {
    }

    public PraktikanEntity07109 getData() {
        return AllObjectModel07109.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }

    public void daftarPraktikum(int indexPraktikum, PraktikanEntity07109 praktikanEntity, boolean isVerified) {
        AllObjectModel07109.daftarprakModel.insertDataDaftarprak(new DaftarprakEntity07109(indexPraktikum, praktikanEntity, isVerified));
    }

    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel07109.praktikanModel.cekData(npm, password);
    }

    public void insert(String npm, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        AllObjectModel07109.praktikanModel.insert(new PraktikanEntity07109(npm, password, nama, no_telp, tglLahir, kelas));
    }

    public PraktikanEntity07109 praktikanEntity() {
        return AllObjectModel07109.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }

    public int cekDaftarprak(String npm) {
        int cek = AllObjectModel07109.daftarprakModel.cekData(npm, null);
        return cek;
    }

    public DaftarprakEntity07109 showDaftarprak(int index) {
        return AllObjectModel07109.daftarprakModel.showDaftarprak(index);
    }

    public DefaultTableModel daftarprak() {
        DefaultTableModel dtmdaftarprak = new DefaultTableModel();
        Object[] kolom = {"NPM", "Nama", "Password", "No Telp", "Tgl Lahir", "praktikum", "Verified", "Kelas"};
        dtmdaftarprak.setColumnIdentifiers(kolom);
        int size = AllObjectModel07109.daftarprakModel.alldataprak().size();
        String verif = null;
        for (int i = 0; i < size; i++) {
            if (AllObjectModel07109.daftarprakModel.alldataprak().get(i).isVerified() == false) {
                verif = "no";
            } else {
                verif = "yes";
            }
            Object[] data = new Object[8];
            data[0] = AllObjectModel07109.daftarprakModel.alldataprak().get(i).getPraktikan().getNpm();
            data[1] = AllObjectModel07109.daftarprakModel.alldataprak().get(i).getPraktikan().getNama();
            data[2] = AllObjectModel07109.daftarprakModel.alldataprak().get(i).getPraktikan().getPassword();
            data[3] = AllObjectModel07109.daftarprakModel.alldataprak().get(i).getPraktikan().getNo_telp();
            data[4] = new SimpleDateFormat("dd-mm-yyy").format(AllObjectModel07109.daftarprakModel.alldataprak().get(i).getPraktikan().getTgllahir());
            data[5] = PraktikumEntity07109.nama[AllObjectModel07109.daftarprakModel.alldataprak().get(i).getIndexPrak()];
            data[6] = verif;
            data[7] = AllObjectModel07109.daftarprakModel.alldataprak().get(i).getPraktikan().getKelas();
            dtmdaftarprak.addRow(data);
        }
        return dtmdaftarprak;
    }
}
