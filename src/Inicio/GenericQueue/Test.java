package Inicio.GenericQueue;

import Inicio.Menu.Classes.State;
import Inicio.Menu.Classes.Task;
import Inicio.Menu.Classes.User;

public class Test {
    public static void main(String[] args) {
        User user = new User("Renato","jaja","A");
        SLLQueue<Task>tasks = new SLLQueue<>();
        tasks.enqueue(new Task(1,user, State.Assigned,"Tarea1",5));
        tasks.enqueue(new Task(2,user, State.Assigned,"Tarea2",5));
        tasks.enqueue(new Task(3,user, State.Assigned,"Tarea3",5));
        tasks.enqueue(new Task(4,user, State.Assigned,"Tarea4",5));
        System.out.println(tasks.size());
        try {
            System.out.println(tasks.peek());
            System.out.println(tasks.dequeue());
            System.out.println(tasks.size());
            tasks.clear();
            System.out.println(tasks.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
