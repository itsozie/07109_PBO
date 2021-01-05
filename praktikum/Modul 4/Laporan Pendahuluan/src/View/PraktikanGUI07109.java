/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import Controller.*;
import Entity.PraktikumEntity07109;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class PraktikanGUI07109 {

    JFrame Praktikan = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarpraktikum;
    JComboBox pilprak = new JComboBox(PraktikumEntity07109.nama);
    int cek = allobjctrl07109.praktikan.cekDaftarprak(allobjctrl07109.praktikan.praktikanEntity().getNpm());

    public PraktikanGUI07109() {
        Praktikan.setSize(720, 600);
        Praktikan.setLayout(null);
        Praktikan.getContentPane().setBackground(Color.PINK);
        datadiri = new JLabel("Data Praktikan");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        Praktikan.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Praktikan.add(area);

        daftarpraktikum = new JLabel("Daftar Praktikum");
        daftarpraktikum.setBounds(450, 30, 250, 30);
        daftarpraktikum.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Praktikan.add(daftarpraktikum);
        pilprak.setBounds(450, 90, 230, 30);
        Praktikan.add(pilprak);

        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GREEN);
        Praktikan.add(daftarbtn);

        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        Praktikan.add(back);

        Praktikan.setVisible(true);
        Praktikan.setLocationRelativeTo(null);
        Praktikan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Praktikum", "information",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Praktikum", "information",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datapraktikan());
        }
        daftarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexprak = pilprak.getSelectedIndex();
                allobjctrl07109.praktikan.daftarPraktikum(indexprak, allobjctrl07109.praktikan.getData(), false);
                area.setText(datapraktikan());
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Praktikan.dispose();
                GUI07109 men = new GUI07109();
            }
        });
    }

    String datapraktikan() {
        int cek = allobjctrl07109.praktikan.cekDaftarprak(allobjctrl07109.praktikan.praktikanEntity().getNpm());
        String cekverif;
        if (allobjctrl07109.praktikan.showDaftarprak(cek).isVerified() == false) {
            cekverif = "belum diverifikasi";
        } else {
            cekverif = "sudah diverifikasi";
        }
        String text
                = "Npm = " + allobjctrl07109.praktikan.showDaftarprak(cek).getPraktikan().getNpm() + "\n"
                + "Nama = " + allobjctrl07109.praktikan.showDaftarprak(cek).getPraktikan().getNama() + "\n"
                + "No Telp = " + allobjctrl07109.praktikan.showDaftarprak(cek).getPraktikan().getNo_telp() + "\n"
                + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy")
                .format(allobjctrl07109.praktikan.showDaftarprak(cek).getPraktikan().getTgllahir()) + "\n"
                + "verifikasi = " + cekverif + "\n"
                + "Kelas = " + allobjctrl07109.praktikan.showDaftarprak(cek).getPraktikan().getKelas() + "\n"
                + "Praktikum = " + PraktikumEntity07109.nama[allobjctrl07109.praktikan.showDaftarprak(cek).getIndexPrak()];

        return text;
    }

}
