package Inicio.Menu.Classes;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class validateCredentials {
    public static boolean Validate(String username, String password, JLabel report) throws FileNotFoundException {
        FileReader file = new FileReader("C:\\Users\\DREP\\Documents\\UTP\\CICLO V\\Algoritmos y estructura de datos\\Project2_of_-Algorithms\\src\\Inicio\\Menu\\Classes\\Credentials.txt");
        try {
           BufferedReader reader = new BufferedReader(file);
           String line = reader.readLine();
           while (line != null){
               String[] components = line.split(",");
               if(username.equals(components[0])){
                   if(password.equals(components[1])){
                       return true;
                   }else {
                       report.setText("Password Incorrect");
                   }
               }else {
                   report.setText("Username Incorrect");
               }
               line = reader.readLine();
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
