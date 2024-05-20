package Inicio.Menu.Classes;

import Lists.MySinglyLinkedList.SinglyLinkedList;

import javax.swing.*;
import java.io.*;

public class GetUsers {
    public static SinglyLinkedList<User> get() throws IOException {
        File file = new File("C:\\Users\\DREP\\Documents\\UTP\\CICLO V\\Algoritmos y estructura de datos\\Project2_of_-Algorithms\\src\\Inicio\\Menu\\Classes\\Credentials.txt");
        SinglyLinkedList<User>users = new SinglyLinkedList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while (line != null) {
            if(!line.equals("")){
                String[] data = line.split(",");
                users.add(new User(data[0], data[1], data[2]));
            }
            line = br.readLine();
        }
        for(User user : users) {
            System.out.println(user);
        }
        return users;
    }

    public static void main(String[] args) {
        try {
            get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
