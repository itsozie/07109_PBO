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
public class DaftarprakEntity07109 {
    private PraktikanEntity07109 praktikan;
    private boolean isVerified;
    private int indexPraktikum;

    public DaftarprakEntity07109(int indexPraktikum,PraktikanEntity07109 praktikan, boolean isVerified) {
        this.praktikan = praktikan;
        this.isVerified = isVerified;
        this.indexPraktikum = indexPraktikum;
    }
    
    public PraktikanEntity07109 getPraktikan() {
        return this.praktikan;
    }
    
    public void setPraktikan(PraktikanEntity07109 praktikan) {
        this.praktikan = praktikan;
    }
    
    public boolean isVerified() {
        return isVerified;
    }
    
    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }
    
    public int getIndexPrak() {
        return indexPraktikum;
    }
    
    public void setIndexPrak(int indexPrak) {
        this.indexPraktikum = indexPrak;
    }
}
