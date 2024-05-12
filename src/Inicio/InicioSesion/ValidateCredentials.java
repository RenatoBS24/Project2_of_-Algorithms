package Inicio.InicioSesion;

import javax.swing.*;

public class ValidateCredentials {
    public static boolean Validate(String username, String password, JLabel report){
        if(username.equals("Renato")){
            if(password.equals("123456")){
                return true;
            }else {
                report.setText("The password is incorrect.");
            }
        }else {
            report.setText("The username is invalid.");
        }
        return false;
    }
}
