package Inicio.InicioSesion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel;
    private JLabel tittle;
    private JTextField userTextField;
    private JPasswordField passwordPasswordField;
    private JButton startButton;
    private JCheckBox shoowPasswordCheckBox;
    private JButton checkInButton;
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
                if(ValidateCredentials.Validate(userTextField.getText(),new String(passwordPasswordField.getPassword()),report)){
                    Login.this.dispose();
                    System.out.println("Welcome");
                }else {
                    userTextField.setText("");
                    passwordPasswordField.setText("");
                }
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
