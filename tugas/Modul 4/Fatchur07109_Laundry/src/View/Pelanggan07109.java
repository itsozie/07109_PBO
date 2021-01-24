/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Fatchur07109_PaketEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pelanggan07109 {

    JFrame Pelanggan = new JFrame();
    JLabel titleforedit, labelid, labelnama, labelpassword, labelnotelp,
            labeltgllahir, labelalamat, labelberat, labelregpket;
    
    JTextField textid, textnama, textnotelp, texttgl,
            textalamat, textberat;
    
    JPasswordField textpassword;
    JButton EditPelanggan, Antri, Back;
    JComboBox pilpaket = new JComboBox(Fatchur07109_PaketEntity.paket);

    public Pelanggan07109() {
        Pelanggan.setSize(720, 600);
        Pelanggan.setLayout(null);
        Pelanggan.getContentPane().setBackground(Color.cyan);

        titleforedit = new JLabel("Data Pelanggan");
        titleforedit.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleforedit.setBounds(60, 30, 200, 30);
        Pelanggan.add(titleforedit);

        labelid = new JLabel("ID");
        labelid.setBounds(30, 70, 100, 30);
        Pelanggan.add(labelid);

        textid = new JTextField(Integer.toString(Allobjctrl.pelanggan.pelangganEntity().getId()));
        textid.setBounds(30, 100, 250, 30);
        textid.setEditable(false);
        Pelanggan.add(textid);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(30, 130, 100, 30);
        Pelanggan.add(labelnama);

        textnama = new JTextField(Allobjctrl.pelanggan.pelangganEntity().getNama());
        textnama.setBounds(30, 160, 250, 30);
        Pelanggan.add(textnama);

        labelpassword = new JLabel("Password");
        labelpassword.setBounds(30, 190, 100, 30);
        Pelanggan.add(labelpassword);

        textpassword = new JPasswordField(Allobjctrl.pelanggan.pelangganEntity().getPassword());
        textpassword.setBounds(30, 220, 250, 30);
        Pelanggan.add(textpassword);

        labelnotelp = new JLabel("No Telp");
        labelnotelp.setBounds(30, 250, 100, 30);
        Pelanggan.add(labelnotelp);

        textnotelp = new JTextField(Allobjctrl.pelanggan.pelangganEntity().getNo_telp());
        textnotelp.setBounds(30, 280, 250, 30);
        Pelanggan.add(textnotelp);

        labeltgllahir = new JLabel("Tanggal Lahir (dd/mm/yyyy)");
        labeltgllahir.setBounds(30, 310, 200, 30);
        Pelanggan.add(labeltgllahir);

        texttgl = new JTextField(new SimpleDateFormat("dd/MM/YYYY")
                .format(Allobjctrl.pelanggan.pelangganEntity().getTgl()));
        texttgl.setBounds(30, 340, 250, 30);
        Pelanggan.add(texttgl);

        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(30, 370, 100, 30);
        Pelanggan.add(labelalamat);

        textalamat = new JTextField(Allobjctrl.pelanggan.pelangganEntity().getAlamat());
        textalamat.setBounds(30, 400, 250, 30);
        Pelanggan.add(textalamat);

        labelberat = new JLabel("Berat");
        labelberat.setBounds(30, 430, 100, 30);
        Pelanggan.add(labelberat);

        textberat = new JTextField(Integer.toString(Allobjctrl.pelanggan.pelangganEntity().getBerat()));
        textberat.setBounds(30, 460, 250, 30);
        Pelanggan.add(textberat);

        labelregpket = new JLabel("Pendaftaran Antrian");
        labelregpket.setBounds(425, 30, 500, 30);
        labelregpket.setFont(new Font("Times New Roman", Font.BOLD, 30));

        Pelanggan.add(labelregpket);
        pilpaket.setBounds(435, 90, 250, 30);
        Pelanggan.add(pilpaket);

        Antri = new JButton("Daftar Antrian");
        Antri.setBounds(500, 200, 100, 30);
        Antri.setBackground(Color.GREEN);
        Pelanggan.add(Antri);

        EditPelanggan = new JButton("Edit Data");
        EditPelanggan.setBounds(100, 500, 100, 30);
        EditPelanggan.setBackground(Color.GREEN);
        Pelanggan.add(EditPelanggan);

        Back = new JButton("Back");
        Back.setBounds(320, 500, 100, 30);
        Back.setBackground(Color.RED);
        Pelanggan.add(Back);

        Pelanggan.setVisible(true);
        Pelanggan.setLocationRelativeTo(null);
        Pelanggan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EditPelanggan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int id = Integer.parseInt(textid.getText());
                    String nama = textnama.getText();
                    String pass = textpassword.getText();
                    String notelp = textnotelp.getText();
                    Date tgllahir = new Date(texttgl.getText());
                    String alamat = textalamat.getText();
                    int berat = Integer.parseInt(textberat.getText());
                    Allobjctrl.pelanggan.postData(pass, nama, notelp, alamat, berat, id, tgllahir, "newPelanggan");
                    JOptionPane.showMessageDialog(null, "Update Data Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Update Data Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pelanggan.dispose();
                Landing07109 Landing = new Landing07109();
            }
        });

        Antri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexpaket = pilpaket.getSelectedIndex();
                try {
                    Allobjctrl.pelanggan.registerAntrian(indexpaket,
                            Allobjctrl.pelanggan.pelangganEntity());
                    System.out.println("Anda Sudah Terdaftar Di Paket = "
                            + Allobjctrl.pelanggan.showNamePaket(indexpaket));
                    JOptionPane.showMessageDialog(null, "Anda Sudah Terdaftar Di Paket "
                            + Allobjctrl.pelanggan.showNamePaket(indexpaket),
                            "Pendaftaran Berhasil", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Paket Yang Anda Daftarkan Tidak Ada", 
                            "Pendaftaran Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

}
