package ManajemenLaundry;
import java.util.Date;

public class fatchur_07109_OwnerEntity extends Katalog {
       protected String Fatchur_07109_nama_pelanggan;
       protected Date Fatchur_07109_tanggal_masuk;
       protected String Fatchur_07109_pegawai;
       protected String Fatchur_07109_katalog;
       protected float Fatchur_07109_berat_cucian;
       protected Date Fatchur_07109_tanggal_selesai;
       
       Katalog Katalog = new Katalog();
       
    public fatchur_07109_OwnerEntity(
            String Fatchur_07109_nama_pelanggan,
            Date Fatchur_07109_tanggal_masuk,
            String Fatchur_07109_pegawai,
            String Fatchur_07109_katalog,
            float Fatchur_07109_berat_cucian, 
    Date Fatchur_07109_tanggal_selesai){                              
        this.Fatchur_07109_nama_pelanggan      = Fatchur_07109_nama_pelanggan;
        this.Fatchur_07109_tanggal_masuk       = Fatchur_07109_tanggal_masuk;
        this.Fatchur_07109_pegawai             = Fatchur_07109_pegawai;
        this.Fatchur_07109_katalog             = Fatchur_07109_katalog;
        this.Fatchur_07109_berat_cucian        = Fatchur_07109_berat_cucian;
        this.Fatchur_07109_tanggal_selesai     = Fatchur_07109_tanggal_selesai;
        }
    public String getFatchur_07109_nama_pelanggan() {
        return Fatchur_07109_nama_pelanggan;
    }

    public Date getFatchur_07109_tanggal_masuk() {
        return Fatchur_07109_tanggal_masuk;
    }
    public String getFatchur_07109_pegawai() {
        return Fatchur_07109_pegawai;
    }
    public String getFatchur_07109_katalog(){
        return Fatchur_07109_katalog;
    }
    public String getTipekatalog(){
        return Katalog.cekTipe(Fatchur_07109_katalog);
    }
    public float getFatchur_07109_berat_cucian() {
        return Fatchur_07109_berat_cucian;
    }
    public Date getFatchur_07109_tanggal_selesai() {
        return Fatchur_07109_tanggal_selesai;
    }
}
