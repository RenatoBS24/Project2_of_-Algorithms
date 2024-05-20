package Inicio.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Kanban extends JFrame {
    private JTable tabla;
    private JPanel panel;
    private JButton newProjectButton;
    private JTextField textField1;
    private JButton fileUploadButton;
    String dato = "";
    public Kanban(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kanban");
        setVisible(false);
        pack();
        setSize(1073, 542);
        setLocationRelativeTo(null);
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
