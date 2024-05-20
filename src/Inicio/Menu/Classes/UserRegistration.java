package Inicio.Menu.Classes;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserRegistration {
    public static boolean Register(String username, String password, String type, String dinamic , JLabel report) throws IOException {
        String dinamicKey = "12345";
        try( FileWriter file = new FileWriter("C:\\Users\\DREP\\Documents\\UTP\\CICLO V\\Algoritmos y estructura de datos\\Project2_of_-Algorithms\\src\\Inicio\\Menu\\Classes\\Credentials.txt",true);PrintWriter print = new PrintWriter(file);){
            if(dinamic.equals(dinamicKey)){
                print.println(username+","+password+","+type+"\n");
            }else {
                report.setText("Dinamic Key incorret");
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
