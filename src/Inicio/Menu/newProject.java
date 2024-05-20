package Inicio.Menu;

import Inicio.Menu.Classes.ProjectCreation;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class newProject extends JFrame {
    private JTextField description;
    private JTextField name;
    private JTextField user;
    private JButton createButton;
    private JPanel panel;
    private JLabel report;

    public newProject() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("New Project");
        pack();
        setSize(537,436);
        setLocationRelativeTo(null);
        setResizable(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int selected = fileChooser.showSaveDialog(panel);
                if(selected == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if(!file.getName().toLowerCase().endsWith(".xml")) {
                        file = new File(file.getAbsolutePath() + ".xml");
                    }
                    try {
                        ProjectCreation.Create(name.getText(), description.getText(), user.getText(),file,report);
                    } catch (ParserConfigurationException ex) {
                        throw new RuntimeException(ex);
                    } catch (TransformerException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                newProject.this.dispose();
            }
        });
    }
    public void text(String text){
        user.setText(text);
    }
}
