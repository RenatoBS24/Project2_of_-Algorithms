package Inicio.Menu;

import Inicio.Menu.Classes.*;
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
    private JTextField TaskName;
    private JButton registrarTareaButton;
    private JComboBox estados;
    private JComboBox prioridades;
    String dato = "";
    public Kanban(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kanban");
        setVisible(false);
        pack();
        setSize(1073, 542);
        setLocationRelativeTo(null);
        String[] estado = {"","Creada","Asignado","En progreso","Terminada","Aprobada"};
        String [] prioridad = {"1","2","3","4","5"};
        try {
            SinglyLinkedList<User> user = GetUsers.get();
            System.out.println(user.size());
            Users.addItem("");
            for(int i = 0; i<user.size(); i++){
                User usuario = user.get(i);
                Users.addItem(usuario.getName());
            }
            for(int i = 0; i<estado.length;i++ ){
                estados.addItem(estado[i]);
            }
            for(int i = 0; i<prioridad.length;i++ ){
                prioridades.addItem(prioridad[i]);
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
        registrarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User usuario = GetUsers.getUnityUser(String.valueOf(Users.getSelectedItem()));
                    TaskRegister.Register(tabla,TaskName.getText(),usuario,prioridades.getSelectedIndex(), State.Approved);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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
