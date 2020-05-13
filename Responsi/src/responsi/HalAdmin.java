/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HalAdmin extends JFrame {
    
    Icon iconbtnHome = new ImageIcon("D:\\kamal\\home.jpeg");
    Icon iconbtnGaji = new ImageIcon("D:\\kamal\\gaji.jpeg");
    Icon iconbtnData = new ImageIcon("D:\\kamal\\Data.jpeg");
    Icon iconbtnPetunjuk = new ImageIcon("D:\\kamal\\Petunjuk.jpeg");
    Icon iconbtnKaryawan = new ImageIcon("D:\\kamal\\Karyawan.jpeg");
    
    JButton btnHome = new JButton("Home",iconbtnHome);
        JButton btnGaji = new JButton("Gaji",iconbtnGaji);
        JButton btnData = new JButton("Data",iconbtnData);
        JButton btnPetunjuk = new JButton("Petunjuk",iconbtnPetunjuk);
        JButton btnAdmin = new JButton("Karyawan",iconbtnKaryawan);
      
     
    JLabel lTampilan = new JLabel("Selamat Datang Admin");
    JLabel lTampilan2 = new JLabel("Masuk Menu Tambah untuk Menambah data");
    JLabel lTampilan3 = new JLabel("Menu Petunjuk Jika Kesulitan");
    JLabel lTampilanDefault = new JLabel("APLIKASI PENGHITUNG GAJI");
      
      
   

    public HalAdmin() {
        setTitle("Gaji");
        setDefaultCloseOperation(3);
        setSize(600,470);

       
       
       
        setLayout(null);
        

        add(btnHome);
                btnHome.setBounds(10,10,180,100);
                add(btnGaji);
                btnGaji.setBounds(10,115,180,100);
                add(btnData);
                btnData.setBounds(10,220,180,100);
                add(btnPetunjuk);
                btnPetunjuk.setBounds(10,325,180,100);
                add(btnAdmin);
                btnAdmin.setBounds(400,10,180,100);
        
        add(lTampilan);
                lTampilan.setBounds(200,120,200,20);
                add(lTampilan2);
                lTampilan2.setBounds(200,140,300,20);
                add(lTampilan3);
                lTampilan3.setBounds(200,160,200,20);
                add(lTampilanDefault);
                lTampilanDefault.setBounds(200,320,200,20);
        
        setVisible(true);
          
        
        btnHome.addActionListener((ActionEvent e) -> {
            new HalAdmin();
            dispose();
        });
        btnGaji.addActionListener((ActionEvent e) -> {
            new Tambah();
            dispose();
        });
        btnData.addActionListener((ActionEvent e) -> {
            new Pegawai();
            dispose();
        });
        btnPetunjuk.addActionListener((ActionEvent e) -> {
            new PetunjukAdmin();
            dispose();
        });
        btnAdmin.addActionListener((ActionEvent e) -> {
            new GUI();
            dispose();
        });
        
        
       
        
       
        
    }   
}
