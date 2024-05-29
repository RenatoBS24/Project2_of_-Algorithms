package Inicio.Menu.Classes;
import Inicio.GenericQueue.Priority.Prioritys;
import Inicio.GenericQueue.SLLQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class TaskRegister {
    private static SLLQueue<Task> tasksByHora = new SLLQueue<>(Prioritys.getByHora());
    private static SLLQueue<Task> tasksPorHacer = new SLLQueue<>(Prioritys.getByPrioridad());
    private static SLLQueue<Task> tasksByUser = new SLLQueue<>(Prioritys.getByUser());
    private static SLLQueue<Task> tasksPorVerificar = new SLLQueue<>(Prioritys.getByPorVerificar());
    public static void Register(JPanel panel,String name,User user,int priority,State state,int opc){
        if (panel == null) {
            System.out.println("xd");
            throw new IllegalArgumentException("Panel cannot be null");

        }
        GridLayout layout = new GridLayout(100,1);
        panel.setLayout(layout);
        Task task = new Task(1,user,state,name,priority);
        panel.removeAll();
        try {
            switch (opc){
                case 0:
                case 4:
                    tasksByHora.enqueue(task);
                    for (Task task1 : tasksByHora) {
                        System.out.println(task1);
                        panel.add(new JLabel(task1.getName()));
                    }
                    panel.revalidate();
                    break;
                case 1:
                    tasksPorHacer.enqueue(task);
                    for (Task task1 : tasksPorHacer) {
                        System.out.println(task1);
                        panel.add(new JLabel(task1.getName()));
                    }
                    panel.revalidate();
                    break;
                case 2:
                    tasksByUser.enqueue(task);
                    for (Task task1 : tasksByUser) {
                        panel.add(new JLabel(task1.getName()));
                    }
                    panel.revalidate();
                    break;
                case 3:
                    tasksPorVerificar.enqueue(task);
                    for (Task task1 : tasksPorVerificar) {
                        panel.add(new JLabel(task1.getName()));
                    }
                    panel.revalidate();
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
