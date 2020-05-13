/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static responsi.Gaji.JDBC_DRIVER;

public class Tambah extends JFrame {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi";
    static final String USER = "root";
    static final String PASS = "";

    
    
    Connection koneksi;
    Statement statement; 
    Tambah enter;
    
           
        JLabel lIdkaryawan = new JLabel("ID Karyawan");
        JTextField tfIdkaryawan = new JTextField();
        JLabel lNama= new JLabel("Nama");
        JTextField tfNama = new JTextField();
        JLabel lPosisi = new JLabel("Posisi");
        JTextField tfPosisi = new JTextField();
        JLabel lAlamat = new JLabel("Alamat ");
        JTextField tfAlamat = new JTextField();
        JLabel lNohp= new JLabel("No HP");
        JTextField tfNohp = new JTextField();
        JLabel lTotal = new JLabel("Total");
        JTextField tfTotal = new JTextField();
        
        Icon iconbtnHome = new ImageIcon("D:\\kamal\\home.jpeg");
        Icon iconbtnGaji = new ImageIcon("D:\\kamal\\gaji.jpeg");
        Icon iconbtnData = new ImageIcon("D:\\kamal\\Data.jpeg");
        Icon iconbtnPetunjuk = new ImageIcon("D:\\kamal\\Petunjuk.jpeg");
        Icon iconbtnAdmin = new ImageIcon("D:\\kamal\\admin.jpeg");
        Icon iconbtnSimpan = new ImageIcon("D:\\kamal\\Simpan.jpeg");
        
        JButton btnHome = new JButton("Home",iconbtnHome);
        JButton btnGaji = new JButton("Gaji",iconbtnGaji);
        JButton btnData = new JButton("Data",iconbtnData);
        JButton btnPetunjuk = new JButton("Petunjuk",iconbtnPetunjuk);
        JButton btnAdmin = new JButton("Admin",iconbtnAdmin);
        JButton btnSimpan = new JButton("Simpan",iconbtnSimpan);
      
             
public Tambah(){
        
         try{
                    Class.forName(JDBC_DRIVER);
                    koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
                    System.out.println("Koneksi Berhasil");
                }catch(ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    System.out.println("Koneksi Gagal");
                }  
    
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,470);

        
setTitle("Tambah");
        
        add(lIdkaryawan);
        lIdkaryawan.setBounds(200, 30, 100,20);
        add(tfIdkaryawan);
        tfIdkaryawan.setBounds(280, 30, 100,20);
        
        add(lNama);
        lNama.setBounds(200, 60, 100,20);
        add(tfNama);
        tfNama.setBounds(250, 60, 100,20);        
        
        add(lPosisi);
        lPosisi.setBounds(200, 90, 100,20);
        add(tfPosisi);
        tfPosisi.setBounds(250, 90, 100,20);
        
        add(lAlamat);
        lAlamat.setBounds(200, 120, 100,20);
        add(tfAlamat);
        tfAlamat.setBounds(250, 120, 200,20);
        
        add(lNohp);
        lNohp.setBounds(200, 150, 150,20);
        add(tfNohp);
        tfNohp.setBounds(250, 150, 150,20);
        
        add(lTotal);
        lTotal.setBounds(200, 300, 100,20);
        add(tfTotal);
        tfTotal.setBounds(250, 300, 100,20);

        add(btnHome);
        btnHome.setBounds(10,10,180,100);
        add(btnGaji);
        btnGaji.setBounds(10,115,180,100);
        add(btnData);
        btnData.setBounds(10,220,180,100);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10,325,180,100);
        add(btnAdmin);
        btnAdmin.setBounds(450,10,180,100);
        add(btnSimpan);
        btnSimpan.setBounds(450,305, 180,100);
        
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
            new Petunjuk();
            dispose();
        });
        btnSimpan.addActionListener((ActionEvent e) -> {
                    if (tfIdkaryawan.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                    } else {
                     
                  
                        String Idkaryawan = tfIdkaryawan.getText();
                        String Nama = tfNama.getText();
                        String Posisi = tfPosisi.getText();
                        String Alamat = tfAlamat.getText();
                        String Nohp = tfNohp.getText();
                        String Total = tfTotal.getText();
                       
                        this.insertSalary(Idkaryawan, Nama, Posisi, Alamat, Nohp, Total);

                                           
                    }
        });

         
        
    }
    
         
   
    
  
public String getIdkaryawan(){
        return tfIdkaryawan.getText();
    } 

 public void insertSalary (String Idkaryawan, String Nama, String Posisi, String Alamat, String Nohp,  String Total) {
                try{
                    String query = "INSERT INTO `pegawai`(`Idkaryawana`,`Namaa`,`Posisia`,`Alamata`,`Nohpa`,`Totala`) VALUES ('"+Idkaryawan+"','"+Nama+"','"+Posisi+"','"+Alamat+"','"+Nohp+"','"+Total+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"data berhasil ditambahkan");
                }catch(Exception sql){
                    System.out.println(sql.getMessage());
                    JOptionPane.showMessageDialog(null, sql.getMessage());
                }

            }



}
    
