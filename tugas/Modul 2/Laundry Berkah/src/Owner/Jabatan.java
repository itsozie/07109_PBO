   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Owner;

/**
 *
 * @author ozie
 */
public class Jabatan {
    public String kodejabatan;
    public String jabatan;
    public Owner owner;
    
 public Jabatan(String kode, String jabatan) {
        this.kodejabatan    = kode;
        this.jabatan = jabatan;
        jabatan = null;
    }

    public void setJabatan(Owner jabatan) {
        this.owner = owner;
    }
}