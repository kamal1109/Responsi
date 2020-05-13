
package responsi;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PetunjukAdmin extends JFrame {
    JButton btnHome = new JButton("Home");
      
     
    JLabel lTampilan = new JLabel("Tombol Gaji Untuk Menghitung Gaji");
    JLabel lTampilan2 = new JLabel("Menu Data untuk Cek Data Sudah Masuk/Belum");
    JLabel lTampilanDefault = new JLabel("APLIKASI PENGHITUNG GAJI");
      
      
   

    public PetunjukAdmin() {
    setTitle("Petunjuk");
    setDefaultCloseOperation(3);
    setSize(600,400);
       
       
       
       
    setLayout(null);
        

    add(btnHome);
    btnHome.setBounds(200, 280, 100,30);
       
        
    add(lTampilan);
    lTampilan.setBounds(150, 100, 200,20);
    add(lTampilan2);
    lTampilan2.setBounds(150, 120, 300,20);
    add(lTampilanDefault);
    lTampilanDefault.setBounds(180, 320, 200,20);
        
    setVisible(true);
          
        
    btnHome.addActionListener((ActionEvent e) -> {
        new HalAdmin ();
        dispose();
    });
        
        
       
        
       
        
    }
}
