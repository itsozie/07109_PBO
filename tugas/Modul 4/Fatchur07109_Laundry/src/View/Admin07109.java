/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ozi
 */
public class Admin07109 {

    JFrame Admin = new JFrame();
    JTable tabelAntrianPelanggan = new JTable();
    JScrollPane scroladm = new JScrollPane(tabelAntrianPelanggan);
    JButton back;
    JLabel titleHeader;
    private int IndexPaket = Allobjctrl.admin.adminEntity().getpaket();

    public Admin07109() {
        Admin.setSize(650, 500);
        Admin.setLayout(null);
        Admin.getContentPane().setBackground(Color.MAGENTA);
        titleHeader = new JLabel("Petugas "
                + Allobjctrl.admin.showPaketAdmin(IndexPaket));
        titleHeader.setBounds(100, 30, 500, 50);
        titleHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Admin.add(titleHeader);

        scroladm.setBounds(30, 100, 570, 200);
        tabelAntrianPelanggan.setModel(Allobjctrl.pelanggan.antrianPelanggan(IndexPaket));
        Admin.add(scroladm);

        back = new JButton("Back");
        back.setBounds(290, 400, 100, 30);
        back.setBackground(Color.red);
        Admin.add(back);

        Admin.setLocationRelativeTo(null);
        Admin.setVisible(true);
        Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Admin.dispose();
                Landing07109 landing = new Landing07109();
            }
        });

        tabelAntrianPelanggan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelAntrianPelanggan.getSelectedRow();
                int ok = JOptionPane.showConfirmDialog(null, "Hapus Antrian Ke - " + i + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (ok == 0) {
                    Allobjctrl.admin.deleteListAntrianPelanggan(IndexPaket);
                }
                tabelAntrianPelanggan.setModel(Allobjctrl.pelanggan.antrianPelanggan(IndexPaket));
            }
        }
        );
    }

}
