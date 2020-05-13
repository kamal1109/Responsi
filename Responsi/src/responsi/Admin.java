/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin extends JFrame{
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JTextField user = new JTextField(20);
    JPasswordField pass = new JPasswordField(20);
    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");
    
    public Admin(){
    setTitle("Halaman LogIn");
        setSize(350, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(username);
        add(user);
        add(password);
        add(pass);
        add(login);
        add(cancel);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username, password;
                username = user.getText();
                password = pass.getText();
                if (username.length() == 0 && password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Username/Password tidak boleh kosong!");
                } 
                else if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin") ){
                    new HalAdmin();
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Username/Password anda salah!");

            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                   dispose();
            }
        });
        setVisible(true);
    }
}

