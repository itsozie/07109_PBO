/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ozie
 */
import java.util.Date;
public abstract class MahasiswaAbstractEntity07109 {
    protected String npm, password, nama, no_telp;
    protected Date tglLahir;

    public MahasiswaAbstractEntity07109(String npm, String password, String nama, String no_telp, Date tglLahir) {
        this.npm = npm;
        this.password = password;
        this.nama = nama;
        this.no_telp = no_telp;
        this.tglLahir = tglLahir;
    }
    
    public MahasiswaAbstractEntity07109() {    
    }
    
    public abstract String getNpm();
    
    public void setNpm(String npm) {
        this.npm = npm;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNo_telp() {
        return no_telp;
    }
    
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public Date getTglLahir() {
        return tglLahir;
    }
    
    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }
}
