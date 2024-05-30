package Inicio.Menu.Classes;

import Inicio.GenericQueue.Priority.MyQueue;
import Inicio.GenericQueue.Priority.Prioritys;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TaskChange {
    private static MyQueue<Task> tasksByuser = new MyQueue<>(Prioritys.getByUser());
    public static void change(Task task,JPanel panel){
        if (panel == null) {

            throw new IllegalArgumentException("Panel cannot be null");
        }
        GridLayout layout = new GridLayout(20,1);
        panel.setLayout(layout);
        panel.removeAll();
        try {
            tasksByuser.enqueue(task);
            for (Task task1 : tasksByuser) {
                System.out.println(task1);
                JLabel label = new JLabel();
                label.setBorder(new LineBorder(Color.black));
                label.setText(task1.getName());
                panel.add(label);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
