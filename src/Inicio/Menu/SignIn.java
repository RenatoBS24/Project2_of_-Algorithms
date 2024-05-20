package Inicio.Menu;

import Inicio.Menu.Classes.UserRegistration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SignIn extends JFrame {
    private JTextField UserTextField;
    private JTextField passwordTextField;
    private JComboBox Type;
    private JTextField dinamicKeyTextField;
    private JButton signUpButton;
    private JLabel report;
    private JPanel Panel;

    public SignIn(){
        setContentPane(Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setTitle("Sign Up");
        setSize(1072,542);
        setLocationRelativeTo(null);
        setResizable(false);
        String [] types = {"Admin","Usuario"};
        for(int i=0;i<types.length;i++){
            Type.addItem(types[i]);
        }
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(UserRegistration.Register(UserTextField.getText(),passwordTextField.getText(),String.valueOf(Type.getSelectedItem()), dinamicKeyTextField.getText(),report)){
                        SignIn.this.dispose();
                        new Login();
                    }else{
                        System.out.println("Fail register");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
