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
import java.util.ArrayList;
import java.util.Date;

public class AdminController07109 implements ControllerInterface07109 {

    int indexLogin = 0;

    public AdminController07109() {
    }

    public void dataAslab() {
        String npmAslab[] = {"01", "02", "03", "04", "05", "06", "07"};
        String passwordAslab[] = {"01", "02", "03", "04", "05", "06", "07"};
        String namaAslab[] = {"Michael", "Alan", "Odila", "Fitria", "Sita", "Eric", "Fernanda"};
        String notelpAslab[] = {"01", "02", "03", "04", "05", "06", "07"};
        String laboratorium[] = {"RPL", "SO", "BASPROG", "BASPROG", "SO", "RPL", "RPL"};
        String tglLahirAslab[] = {"04/05/2000", "01/12/2000", "03/03/2000", "23/06/2000", "11/07/2000", "13/09/2000", "22/12/2000"};
        for (int i = 0; i < npmAslab.length; i++) {
            AllObjectModel07109.aslabModel.insertAslab(new AslabEntity07109(npmAslab[i], passwordAslab[i],
                    namaAslab[i], notelpAslab[i], new Date(tglLahirAslab[i]), laboratorium[i]));
        }
    }

    public void viewAslab() {
        AllObjectModel07109.aslabModel.view();
    }

    public void listPendaftarPraktikum() {
        AllObjectModel07109.daftarprakModel.view();
    }

    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel07109.aslabModel.cekData(npm, password);
    }

    public AslabEntity07109 aslabEntity() {
        return AllObjectModel07109.aslabModel.showDataAslab(indexLogin);
    }

    public void updateIsVerified(int index, int indexPrak, PraktikanEntity07109 praktikanEntity) {
        AllObjectModel07109.daftarprakModel.updateIsVerified(index, new DaftarprakEntity07109(indexPrak, praktikanEntity, true));
    }

    public ArrayList<DaftarprakEntity07109> cekdaftarprakModel() {
        return AllObjectModel07109.daftarprakModel.getDaftarprakArrayList();
    }

}
