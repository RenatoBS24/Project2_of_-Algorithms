package Inicio.Menu;
import Inicio.GenericQueue.Priority.MyQueue;
import Inicio.Menu.Classes.*;
import Lists.MySinglyLinkedList.SinglyLinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Kambam2  extends JFrame{
    private JPanel panel;
    private JButton newProjectButton;
    private JComboBox Users;
    private JTextField TaskName;
    private JComboBox estados;
    private JComboBox prioridades;
    private JButton registrarTareaButton;
    private JButton cargarProjectoButton;
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JPanel Panel4;
    private JPanel Panel5;
    private JButton deshacerButton;
    private JComboBox Tareas;
    private JButton resolverButton;
    private JPanel panelP;
    private JButton exportarButton;
    private JButton resolverTareaButton;
    private String dato = "";

    public Kambam2() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kanban");
        setVisible(true);
        pack();
        setSize(1360, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        String[] estado = {"Creada","Asignada"};
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
        cargarProjectoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int selected = chooser.showOpenDialog(panel);
                if (selected == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();

                }
            }
        });
        registrarTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelP.setSize(1000,720);
                try {
                    User usuario = GetUsers.getUnityUser(String.valueOf(Users.getSelectedItem()));
                    HashMap<Integer,JPanel>map = new HashMap();
                    map.put(0,Panel1);
                    map.put(1,Panel2);
                    map.put(2,Panel3);
                    map.put(3,Panel4);
                    map.put(4,Panel5);
                    int opc = estados.getSelectedIndex();
                    System.out.println(opc);
                    JPanel seleccionPanel = map.get(opc);
                    int priodidad = prioridades.getSelectedIndex()+1;
                    MyQueue<Task> tarea = TaskRegister.Register(seleccionPanel,TaskName.getText(),usuario,priodidad, State.Approved,opc);
                    for (Task tarea1:tarea){
                         Tareas.addItem(tarea1.toString());
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Component[] components = Panel1.getComponents();
                for (int i = 0; i < components.length; i++) {
                    final JLabel label = (JLabel) components[i];
                    components[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            label.setForeground(Color.RED);
                        }
                    });
                }

            }
        });

        TaskName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Users.getSelectedIndex()==1){
                    estados.removeAllItems();
                    estados.addItem("Creada");
                }
            }
        });
        resolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] components = Panel1.getComponents();
                for (Component component : components) {
                    if (component instanceof JLabel) {
                        JLabel label = (JLabel) component;
                        if (label.getForeground().equals(Color.RED)) {
                            GridLayout layout = new GridLayout(20,1);
                            Panel3.setLayout(layout);
                            Panel3.add(new JLabel(label.getText()));
                            Panel1.remove(label);
                            revalidate();
                            repaint();
                            break;
                        }
                    }
                }
                Component[] components2 = Panel3.getComponents();
                for (int i = 0; i < components2.length; i++) {
                    final JLabel label = (JLabel) components2[i];
                    components2[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            label.setForeground(Color.RED);
                        }
                    });
                }
            }
        });
        exportarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        resolverTareaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] components = Panel3.getComponents();
                for (Component component : components) {
                    if (component instanceof JLabel) {
                        JLabel label = (JLabel) component;
                        if (label.getForeground().equals(Color.RED)) {
                            GridLayout layout = new GridLayout(20,1);
                            Panel4.setLayout(layout);
                            Panel4.add(new JLabel(label.getText()));
                            Panel3.remove(label);
                            revalidate();
                            repaint();
                            break;
                        }
                    }
                }
            }
        });
    }
    public void text(String text){
        dato = text;
    }
}
