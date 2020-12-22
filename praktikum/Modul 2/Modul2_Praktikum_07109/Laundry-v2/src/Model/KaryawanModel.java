/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ozie
 */
import Entity.AdminEntity;
import Entity.PencuciEntity;
import java.util.ArrayList;

public class KaryawanModel implements KaryawanInterfaces{
    ArrayList <PencuciEntity> dataPencuci;
    ArrayList <AdminEntity> dataAdmin;
    

    public KaryawanModel(){
        dataAdmin = new ArrayList();
        dataPencuci = new ArrayList();
    }
    

    
    @Override
    public void insert_karyawan(PencuciEntity pencuci,AdminEntity admin){
        dataAdmin.add(admin);
        dataPencuci.add(pencuci);
    }

    @Override
    public ArrayList<PencuciEntity> getDataPencuci() {
        return dataPencuci;
    }

    @Override
    public ArrayList<AdminEntity> getDataAdmin() {
        return dataAdmin;
    }
}
