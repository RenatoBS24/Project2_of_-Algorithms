package Inicio.Menu.Classes;

import Inicio.GenericQueue.SLLQueue;
import Lists.MySinglyLinkedList.SinglyLinkedList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class TaskRegister {
    private static SLLQueue<Task>tasks = new SLLQueue<>();
    public static void Register(JPanel panel,String name,User user,int priority,State state){
        if (panel == null) {
            System.out.println("xd");
            throw new IllegalArgumentException("Panel cannot be null");

        }
        GridLayout layout = new GridLayout(100,1);
        panel.setLayout(layout);
        tasks.enqueue(new Task(1,user,state,name,priority));
        JLabel takLabel = new JLabel(name);
        takLabel.setBorder(new LineBorder(Color.BLACK));
        takLabel.setSize(100,50);
        panel.add(takLabel);
        panel.revalidate();
    }
}
