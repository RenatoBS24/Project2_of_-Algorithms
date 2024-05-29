package Inicio.GenericQueue.Priority;

import Inicio.Menu.Classes.Task;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prioritys {
    public static  class ComparatorByUserName implements Comparator<Task>{

        @Override
        public int compare(Task t1, Task t2) {
            return t1.getUser().getName().compareTo(t2.getUser().getName());
        }
    }

    private static Comparator<Task> byPrioridad=Comparator.comparing(Task::getPriority);
    private static Comparator<Task> byUser = new ComparatorByUserName();
    private static Comparator<Task> byHora = Comparator.comparing(Task::getStartTime);
    private static Comparator<Task> bystate = Comparator.comparing(Task::getState);
    private static Comparator porHacer = byPrioridad.thenComparing(byUser);
    private static Comparator porVerificar = byPrioridad.thenComparing(byHora);
    private static Comparator xd = byUser.thenComparing(byHora);

    public static Comparator getXd() {
        return xd;
    }

    public static Comparator<Task> getByPorVerificar(){
        return porVerificar;
    }
    public static Comparator<Task> getByPrioridad() {
        return byPrioridad;
    }

    public static Comparator<Task> getByHora() {
        return byHora;
    }
    public static Comparator getPorHacer() {
        return porHacer;
    }

    public static Comparator<Task> getByUser() {
        return byUser;
    }
}
