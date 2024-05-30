package Inicio.Menu.Classes;
import Inicio.GenericQueue.Priority.MyQueue;
import Inicio.GenericQueue.Priority.Prioritys;
import Inicio.GenericQueue.SLLQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class TaskRegister {
    private static MyQueue<Task> tasksByHora = new MyQueue<>(Prioritys.getByHora());
    private static MyQueue<Task> tasksPorHacer = new MyQueue<>(Prioritys.getByPrioridad());
    public static MyQueue<Task> Register(JPanel panel,String name,User user,int priority,State state,int opc){
        if (panel == null) {
            System.out.println("xd");
            throw new IllegalArgumentException("Panel cannot be null");

        }
        GridLayout layout = new GridLayout(100,1);
        panel.setLayout(layout);
        Task task = new Task(user,state,name,priority);
        panel.removeAll();
        try {
            switch (opc){
                case 0:
                    tasksByHora.enqueue(task);
                    for (Task task1 : tasksByHora) {
                        System.out.println(task1);
                        JLabel label = new JLabel();
                        label.setBorder(new LineBorder(Color.black));
                        label.setText(task1.getName());
                        panel.add(label);
                    }
                    panel.revalidate();
                    return tasksByHora;
                case 1:
                    tasksPorHacer.enqueue(task);
                    for (Task task1 : tasksPorHacer) {
                        System.out.println(task1);
                        JLabel label = new JLabel();
                        label.setBorder(new LineBorder(Color.black));
                        label.setText(task1.getName());
                        panel.add(label);
                    }
                    panel.revalidate();
                    return tasksPorHacer;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tasksByHora;
    }
}
