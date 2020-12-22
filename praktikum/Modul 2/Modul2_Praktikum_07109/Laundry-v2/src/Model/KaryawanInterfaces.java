/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.AdminEntity;
import Entity.PencuciEntity;
import java.util.ArrayList;

/**
 *
 * @author ozie
 */
public interface KaryawanInterfaces {
    public void insert_karyawan(PencuciEntity pencuci,AdminEntity admin);
    public ArrayList<PencuciEntity> getDataPencuci();
    public ArrayList<AdminEntity> getDataAdmin();   
}
