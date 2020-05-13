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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static responsi.Gaji.JDBC_DRIVER;

public class Update extends JFrame {
    
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
        
        JButton btnHome = new JButton("Home");
        JButton btnGaji = new JButton("Tambah");
        JButton btnData = new JButton("Data");
        JButton btnPetunjuk = new JButton("Petunjuk");
        JButton btnAdmin = new JButton("Karyawan");
        JButton btnSimpan = new JButton("Simpan");
      
             
public Update(){
        
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
        lIdkaryawan.setBounds(150, 30, 100,20);
        add(tfIdkaryawan);
        tfIdkaryawan.setBounds(250, 30, 100,20);
        
        add(lNama);
        lNama.setBounds(150, 60, 100,20);
        add(tfNama);
        tfNama.setBounds(250, 60, 100,20);        
        
        add(lPosisi);
        lPosisi.setBounds(150, 90, 100,20);
        add(tfPosisi);
        tfPosisi.setBounds(250, 90, 100,20);
        
        add(lAlamat);
        lAlamat.setBounds(150, 120, 100,20);
        add(tfAlamat);
        tfAlamat.setBounds(250, 120, 200,20);
        
        add(lNohp);
        lNohp.setBounds(150, 150, 150,20);
        add(tfNohp);
        tfNohp.setBounds(250, 150, 150,20);
        
        add(lTotal);
        lTotal.setBounds(150, 300, 100,20);
        add(tfTotal);
        tfTotal.setBounds(250, 300, 100,20);


        add(btnHome);
        btnHome.setBounds(10,10,100,100);
        add(btnGaji);
        btnGaji.setBounds(10,115,100,100);
        add(btnData);
        btnData.setBounds(10,220,100,100);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10,325,100,100);
        add(btnAdmin);
        btnAdmin.setBounds(570,10, 100,30);
        add(btnSimpan);
        btnSimpan.setBounds(570,335, 100,30);
        
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
    
