package Inicio.Menu.Classes;

import Lists.ListasEnlazadas.DoubleCircularLinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskRegister {
    static DoubleCircularLinkedList<Task>tasks = new DoubleCircularLinkedList<>();
    public static void Register(JTable table,String name,User user,int priority,State state){
        tasks.add(new Task(1,user,state,name,priority));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(tasks.toArray());
        table.setModel(model);

    }
}
