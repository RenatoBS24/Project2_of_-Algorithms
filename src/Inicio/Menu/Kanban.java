package Inicio.Menu;

import Inicio.Menu.Classes.GetUsers;
import Inicio.Menu.Classes.ImportProject;
import Inicio.Menu.Classes.User;
import Lists.MySinglyLinkedList.SinglyLinkedList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Kanban extends JFrame {
    private JTable tabla;
    private JPanel panel;
    private JButton newProjectButton;
    private JButton fileUploadButton;
    private JComboBox Users;
    String dato = "";
    public Kanban(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kanban");
        setVisible(false);
        pack();
        setSize(1073, 542);
        setLocationRelativeTo(null);
        try {
            SinglyLinkedList<User> user = GetUsers.get();
            System.out.println(user.size());
            for(int i = 0; i<user.size(); i++){
                User usuario = user.get(i);
                Users.addItem(usuario.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        newProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              newProject project = new newProject();
              project.text(dato);
            }
        });
        fileUploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int selected = chooser.showOpenDialog(panel);
                if (selected == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        ImportProject.Import(file,tabla);
                    } catch (ParserConfigurationException | IOException | SAXException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
    public void text(String text){
        dato = text;
    }

    public static void main(String[] args) {
        new Kanban();
    }
}
