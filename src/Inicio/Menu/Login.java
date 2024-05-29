package Inicio.Menu;

import Inicio.Menu.Classes.validateCredentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Login extends JFrame {
    private JPanel panel;
    private JLabel tittle;
    private JTextField userTextField;
    private JPasswordField passwordPasswordField;
    private JButton startButton;
    private JCheckBox shoowPasswordCheckBox;
    private JButton signUpButton;
    private JLabel report;

    public Login(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setTitle("KAMBAN");
        setSize(1073,542);
        setLocationRelativeTo(null);

        shoowPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShoowPasword();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(validateCredentials.Validate(userTextField.getText(),new String(passwordPasswordField.getPassword()),report)){
                        Login.this.dispose();
                        System.out.println("Welcome");
                        Kambam2 k = new Kambam2();
                        k.text(userTextField.getText());
                        k.setVisible(true);
                    }else {
                        userTextField.setText("");
                        passwordPasswordField.setText("");
                        report.setText("Error");
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.dispose();
                new SignIn();
            }
        });
    }
    public void ShoowPasword(){
        boolean visible = passwordPasswordField.getEchoChar() == 0;
        passwordPasswordField.setEchoChar(visible ? '*' : '\0');
    }

    public static void main(String[] args) {
        new Login();
    }
}
