/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.AslabEntity07109;
import Entity.DaftarprakEntity07109;
import Entity.PraktikanEntity07109;
import java.util.ArrayList;
import java.util.Date;

public class AdminController07109 implements ControllerInterface07109 {
    int indexLogin = 0;
    
    public AdminController07109() {
    }
    
    public void dataAslab() {
        String npmAslab[] = {"01","02","03","04","05","06","07"};
        String passwordAslab[] = {"01","02","03","04","05","06","07"};
        String namaAslab[] = {"Michael","Alan","Odil","Fitria","Sita","Eric","Fernanda"};
        String notelpAslab[] = {"01","02","03","04","05","06","07"};
        String tglLahirAslab[] = {"04/05/2000","01/12/2000","03/3/2000","23/6/2000","11/3/2000","13/9/2000","22/12/2000"};
        String laboratorium[] = {"RPL","SO","BASPROG","BASPROG","SO","RPL","RPL"};
        for(int i=0;i<npmAslab.length;i++) {
            AllObjectModel07109.aslabModel07109.insertAslab(new AslabEntity07109(npmAslab[i], passwordAslab[i], namaAslab[i], notelpAslab[i], new Date(tglLahirAslab[i]), laboratorium[i]));
        }
    }
    
    public void viewAslab07109() {
        AllObjectModel07109.aslabModel07109.view();
    }
    
    public void listPendaftarPraktikum07109() {
        AllObjectModel07109.daftarprakModel07109.view();
    }
    
    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel07109.aslabModel07109.cekData(npm,password);
    }
    
    public AslabEntity07109 aslabEntity() {
        return AllObjectModel07109.aslabModel07109.showDataAslab(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexPrak, PraktikanEntity07109 praktikanEntity) {
        AllObjectModel07109.daftarprakModel07109.updateIsVerified(index, new DaftarprakEntity07109(indexPrak,praktikanEntity,true));
    }
    
    public ArrayList<DaftarprakEntity07109> cekdaftarprakModel() {
        return AllObjectModel07109.daftarprakModel07109.getDaftarprakArrayList();
    }
}
