package Owner;
import java.util.Date;

public class Owner extends Karyawan {
    protected String nama;
    protected String alamat;
    protected int id;
    protected Jabatan jabatan;

     public Owner(int id) {
        this.nama     = super.nama;
        this.alamat   = super.Jabatan;
        this.id       = id;
        Jabatan       = null;
    }
public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setKatalog(Jabatan katalog) {
        this.jabatan = katalog;
    }
}