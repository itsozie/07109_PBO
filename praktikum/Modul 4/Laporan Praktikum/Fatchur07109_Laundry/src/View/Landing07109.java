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
import java.util.Date;
import javax.swing.*;

public class Landing07109 {

    JFrame LogReg = new JFrame();
    JLabel login, register, title;
    JRadioButton radiopelanggan, radioadmin;
    JTextField textid, textnama, textnotelp, texttglmasuk,
            textalamat, textberat, textidlogin;
    JLabel labelidlogin, labelnama, labelidregister, labelnotelp, labeltgllahir,
            labelalamat, labelberat, labelpasswordlogin, labelpasswordregister;
    JButton loginUser, registerPelanggan;
    JPasswordField passwordlogin, passwordregister;
    private boolean ceklogin = false;

    public Landing07109() {
        LogReg.setSize(700, 700);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.CYAN);
        title = new JLabel("Sistem Informasi Laundry-v4");
        title.setBounds(100, 10, 600, 50);
        title.setFont(new Font("Consolas", Font.BOLD, 30));
        LogReg.add(title);

        login = new JLabel("Login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(login);

        radiopelanggan = new JRadioButton("Pelanggan");
        radiopelanggan.setBounds(30, 150, 100, 30);
        radiopelanggan.setBackground(Color.CYAN);
        LogReg.add(radiopelanggan);

        radioadmin = new JRadioButton("Admin");
        radioadmin.setBounds(140, 150, 100, 30);
        radioadmin.setBackground(Color.CYAN);
        LogReg.add(radioadmin);

        labelidlogin = new JLabel("ID");
        labelidlogin.setBounds(30, 180, 30, 30);
        LogReg.add(labelidlogin);

        textidlogin = new JTextField();
        textidlogin.setBounds(30, 210, 200, 30);
        LogReg.add(textidlogin);

        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(30, 240, 100, 30);
        LogReg.add(labelpasswordlogin);

        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 270, 200, 30);
        LogReg.add(passwordlogin);

        loginUser = new JButton("Login");
        loginUser.setBounds(90, 320, 100, 40);
        loginUser.setBackground(Color.GREEN);
        LogReg.add(loginUser);

        register = new JLabel("Daftar");
        register.setFont(new Font("Consolas", Font.BOLD, 30));
        register.setBounds(440, 40, 150, 100);
        LogReg.add(register);

        labelidregister = new JLabel("ID");
        labelidregister.setBounds(400, 100, 30, 30);
        LogReg.add(labelidregister);

        textid = new JTextField();
        textid.setBounds(400, 130, 200, 30);
        LogReg.add(textid);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(400, 160, 100, 30);
        LogReg.add(labelnama);

        textnama = new JTextField();
        textnama.setBounds(400, 190, 200, 30);
        LogReg.add(textnama);

        labelpasswordregister = new JLabel("Password");
        labelpasswordregister.setBounds(400, 220, 100, 30);
        LogReg.add(labelpasswordregister);

        passwordregister = new JPasswordField();
        passwordregister.setBounds(400, 250, 200, 30);
        LogReg.add(passwordregister);

        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(400, 280, 100, 30);
        LogReg.add(labelnotelp);

        textnotelp = new JTextField();
        textnotelp.setBounds(400, 310, 200, 30);
        LogReg.add(textnotelp);

        labeltgllahir = new JLabel("Tanggal Masuk (dd/mm/yyyy)");
        labeltgllahir.setBounds(400, 340, 200, 30);
        LogReg.add(labeltgllahir);

        texttglmasuk = new JTextField();
        texttglmasuk.setBounds(400, 370, 200, 30);
        LogReg.add(texttglmasuk);

        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(400, 400, 200, 30);
        LogReg.add(labelalamat);

        textalamat = new JTextField();
        textalamat.setBounds(400, 430, 200, 30);
        LogReg.add(textalamat);

        labelberat = new JLabel("berat");
        labelberat.setBounds(400, 460, 200, 30);
        LogReg.add(labelberat);

        textberat = new JTextField();
        textberat.setBounds(400, 490, 200, 30);
        LogReg.add(textberat);

        registerPelanggan = new JButton("Daftar");
        registerPelanggan.setBounds(460, 530, 100, 40);
        registerPelanggan.setBackground(Color.GREEN);
        LogReg.add(registerPelanggan);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);
        radioadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radioadmin.isSelected()) {
                    radiopelanggan.setSelected(false);
                    ceklogin = true;
                }
            }
        });

        radiopelanggan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiopelanggan.isSelected()) {
                    radioadmin.setSelected(false);
                    ceklogin = false;
                }
            }
        });

        loginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int parseID = Integer.parseInt(textidlogin.getText());
                if (ceklogin == true) {
                    try {
                        Allobjctrl.admin.dataAdmin();
                        Allobjctrl.admin.login(parseID, passwordlogin.getText());
                        String nama = Allobjctrl.admin.adminEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        Admin07109 viewAdmin = new Admin07109();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "ID atau Password Salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                } else {
                    try {
                        Allobjctrl.pelanggan.dataPelanggan();
                        Allobjctrl.pelanggan.login(parseID, passwordlogin.getText());
                        String nama = Allobjctrl.pelanggan.pelangganEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        Pelanggan07109 viewPelanggan = new Pelanggan07109();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "ID atau Password Salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });

        registerPelanggan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int id = Integer.parseInt(textid.getText());
                    String nama = textnama.getText();
                    String pass = passwordregister.getText();
                    String notelp = textnotelp.getText();
                    Date tgl = new Date(texttglmasuk.getText());
                    String alamat = textalamat.getText();
                    int berat = Integer.parseInt(textberat.getText());
                    Allobjctrl.pelanggan.postData(pass, nama, notelp, alamat, berat, id, tgl, "newPelanggan");
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }

    void kosong() {
        textidlogin.setText(null);
        passwordlogin.setText(null);
        textid.setText(null);
        textnama.setText(null);
        passwordregister.setText(null);
        textnotelp.setText(null);
        texttglmasuk.setText(null);
        textalamat.setText(null);
        textberat.setText(null);
    }

}
