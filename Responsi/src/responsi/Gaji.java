/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;


import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Gaji extends JFrame{
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;    
    
        Icon iconbtnHome = new ImageIcon("D:\\kamal\\home.jpeg");
        Icon iconbtnGaji = new ImageIcon("D:\\kamal\\gaji.jpeg");
        Icon iconbtnData = new ImageIcon("D:\\kamal\\Data.jpeg");
        Icon iconbtnPetunjuk = new ImageIcon("D:\\kamal\\Petunjuk.jpeg");
        Icon iconbtnAdmin = new ImageIcon("D:\\kamal\\admin.jpeg");
           
        JLabel lIdkaryawan = new JLabel("ID Karyawan");
        JTextField tfIdkaryawan = new JTextField();
        JLabel lNama= new JLabel("Nama");
        JTextField tfNama = new JTextField();
        JLabel lPosisi = new JLabel("Posisi");
        String[] Posisi =
                    {"Direktur","Programmer","Marketing","Supervisor"};
        JComboBox cmbPosisi = new JComboBox(Posisi);
        JLabel lAlamat = new JLabel("Alamat ");
        JTextField tfAlamat = new JTextField();
        JLabel lNohp= new JLabel("No HP");
        JTextField tfNohp = new JTextField();
        JLabel lGajipokok= new JLabel("Gaji Pokok");
        JTextField tfGajipokok = new JTextField();
        JLabel lJamlembur= new JLabel("Jam Lembur");
        JTextField tfJamlembur = new JTextField();
        JLabel lTunjangan= new JLabel("Tunjangan");
        JTextField tfTunjangan = new JTextField();
        JLabel lPajak = new JLabel("Pajak");
        JTextField tfPajak = new JTextField();
        JLabel lTotal = new JLabel("Total");
        JTextField tfTotal = new JTextField();
        
        JButton btnHome = new JButton("Home",iconbtnHome);
        JButton btnGaji = new JButton("Gaji",iconbtnGaji);
        JButton btnData = new JButton("Data",iconbtnData);
        JButton btnPetunjuk = new JButton("Petunjuk",iconbtnPetunjuk);
        JButton btnAdmin = new JButton("Admin",iconbtnAdmin);
        JButton btnHitung = new JButton("Hitung");
        JButton btnSimpan = new JButton("Simpan");
      
     
        
        
        
public Gaji(){
        
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

        
        setTitle("gaji");
        
        add(lIdkaryawan);
        lIdkaryawan.setBounds(230, 30, 100,20);
        add(tfIdkaryawan);
        tfIdkaryawan.setBounds(280, 30, 100,20);
        
        add(lNama);
        lNama.setBounds(200, 60, 100,20);
        add(tfNama);
        tfNama.setBounds(200, 60, 100,20);        
        
        add(lPosisi);
        lPosisi.setBounds(200, 90, 100,20);
        add(cmbPosisi);
        cmbPosisi.setBounds(200, 90, 100,20);
        
        add(lAlamat);
        lAlamat.setBounds(200, 120, 100,20);
        add(tfAlamat);
        tfAlamat.setBounds(200, 120, 200,20);
        
        add(lNohp);
        lNohp.setBounds(200, 150, 150,20);
        add(tfNohp);
        tfNohp.setBounds(200, 150, 150,20);
        
        add(lGajipokok);
        lGajipokok.setBounds(200, 180, 100,20);
        add(tfGajipokok);
        tfGajipokok.setBounds(200, 180, 100,20);
        
        add(lJamlembur);
        lJamlembur.setBounds(150, 210, 100,20);
        add(tfJamlembur);
        tfJamlembur.setBounds(250, 210, 100,20);
        
        add(lTunjangan);
        lTunjangan.setBounds(250, 240, 100,20);
        add(tfTunjangan);
        tfTunjangan.setBounds(250, 240, 100,20);
        
        add(lPajak);
        lPajak.setBounds(150, 270, 100,20);
        add(tfPajak);
        tfPajak.setBounds(250, 270, 100,20);
        
        add(lTotal);
        lTotal.setBounds(250, 300, 100,20);
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
        btnAdmin.setBounds(430,10,180,100);
        add(btnHitung);
        btnHitung.setBounds(570,300, 100,30);
        add(btnSimpan);
        btnSimpan.setBounds(570,335, 100,30);
        
        btnHome.addActionListener((ActionEvent e) -> {
            new GUI();
            dispose();
        });
        btnGaji.addActionListener((ActionEvent e) -> {
            new Gaji();
            dispose();
        });
       
        btnData.addActionListener((ActionEvent e) -> {
            new Data();
            dispose();
        });
        btnPetunjuk.addActionListener((ActionEvent e) -> {
            new Petunjuk();
            dispose();
        });
         btnAdmin.addActionListener((ActionEvent e) -> {
            new Admin();
            dispose();
        });
               
        btnHitung.addActionListener((ActionEvent e) -> {
                    if (tfGajipokok.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                    } else {
                        long Gajipokok, Jamlembur, Tunjangan, Pajak, Total;
                        Gajipokok = Long.valueOf(tfGajipokok.getText());
                        Jamlembur = Long.valueOf(tfJamlembur.getText());
                        Tunjangan = Jamlembur*1500;
                        Pajak = Gajipokok/100;
                        Total = Gajipokok+Tunjangan-Pajak;
                        tfPajak.setText("Rp. "+String.valueOf(Pajak));
                        tfTunjangan.setText("Rp. "+String.valueOf(Tunjangan));
                        tfTotal.setText("Rp. "+String.valueOf(Total));
                    }
        });
        btnSimpan.addActionListener((ActionEvent e) -> {
                    if (tfGajipokok.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                    } else {
                        long Gajipokok, Jamlembur, Tunjangan, Pajak, Total;
                        Gajipokok = Long.valueOf(tfGajipokok.getText());
                        Jamlembur = Long.valueOf(tfJamlembur.getText());
                        Tunjangan = Jamlembur*1500;
                        Pajak = Gajipokok/100;
                        Total = Gajipokok+Tunjangan-Pajak;
                        tfPajak.setText("Rp. "+String.valueOf(Pajak));
                        tfTunjangan.setText("Rp. "+String.valueOf(Tunjangan));
                        tfTotal.setText("Rp. "+String.valueOf(Total));
                      
                  
                        String Idkaryawan = tfIdkaryawan.getText();
                        String Nama = tfNama.getText();
                        String Posisi = (String) cmbPosisi.getSelectedItem();
                        String Alamat = tfAlamat.getText();
                        String Nohp = tfNohp.getText();
                       
                        this.insertSalary(Idkaryawan, Nama, Posisi, Alamat, Nohp, Gajipokok, Jamlembur, Tunjangan, Pajak, Total);

                                           
                    }
                });

         
        
    }
    
         
    int getBanyakData() {
                int jmlData = 0;
                try{
                    statement = koneksi.createStatement();
                    String query = "SELECT * from `salary`";
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        jmlData++;
                    }
                    return jmlData;
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                    System.out.println("SQL error");
                    return 0;
                }
            }
    
    
String[][] readSalary() {
                try{
                    int jmlData = 0;
                    String data[][]=new String[getBanyakData()][10];
                    String query = "Select * from `salary`";
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        data[jmlData][0] = resultSet.getString("Idkaryawan");
                        data[jmlData][1] = resultSet.getString("Nama");
                        data[jmlData][2] = resultSet.getString("Posisi");
                        data[jmlData][3] = resultSet.getString("Alamat");
                        data[jmlData][4] = resultSet.getString("Nohp");
                        data[jmlData][5] = resultSet.getString("Gajipokok");
                        data[jmlData][6] = resultSet.getString("Jamlembur");
                        data[jmlData][7] = resultSet.getString("Tunjangan");
                        data[jmlData][8] = resultSet.getString("Pajak");
                        data[jmlData][9] = resultSet.getString("Total");
                        jmlData++;
                    }
                    return data;
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                    System.out.println("SQL error");
                    return null;
                }
            }
 public void insertSalary (String Idkaryawan, String Nama, String Posisi, String Alamat, String Nohp, long Gajipokok, long Jamlembur, long Tunjangan, long Pajak, long Total) {
                try{
                    String query = "INSERT INTO `salary`(`Idkaryawan`,`Nama`,`Posisi`,`Alamat`,`Nohp`,`Gajipokok`,`Jamlembur`,`Tunjangan`,`Pajak`,`Total`) VALUES ('"+Idkaryawan+"','"+Nama+"','"+Posisi+"','"+Alamat+"','"+Nohp+"', '"+Gajipokok+"','"+Jamlembur+"','"+Tunjangan+"','"+Pajak+"','"+Total+"')";
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
    

