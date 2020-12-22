/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.DaftarprakEntity07109;
import Entity.PraktikanEntity07109;
import java.util.Date;

public class PraktikanController07109 implements ControllerInterface07109 {
    int indexLogin = 0;
    public PraktikanController07109() {
    }
    
    public PraktikanEntity07109 getData() {
        return AllObjectModel07109.praktikanModel07109.getPraktikanEntityArrayList(indexLogin);
    }
    
    public void daftarPraktikum(int indexPraktikum, PraktikanEntity07109 praktikanEntity, boolean isVerified) {
        AllObjectModel07109.daftarprakModel07109.insertDataDaftarprak(new DaftarprakEntity07109(indexPraktikum,praktikanEntity,isVerified));
    }
    
    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel07109.praktikanModel07109.cekData(npm,password);
    }
    
    public void insert(String npm, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        AllObjectModel07109.praktikanModel07109.insert(new PraktikanEntity07109(npm,password,nama,no_telp,tglLahir,kelas));
    }
    
    public PraktikanEntity07109 praktikanEntity() {
        return AllObjectModel07109.praktikanModel07109.getPraktikanEntityArrayList(indexLogin);
    }
    
    public int cekDaftarprak(String npm) {
        int cek = AllObjectModel07109.daftarprakModel07109.cekData(npm,null);
        return cek;
    }
    
    public DaftarprakEntity07109 showDaftarprak(int index) {
        return AllObjectModel07109.daftarprakModel07109.showDaftarprak(index);
    }
}
