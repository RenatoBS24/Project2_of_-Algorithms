package Inicio.GenericQueue.Priority;

import Inicio.Menu.Classes.Task;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prioritys {
   /* private Comparator<Task> byNumLlegada=Comparator.comparing(Task::ge);//se organiza por orden de creación
    private Comparator<Task> byPrioridad=Comparator.comparing(Task::getPriority);
    private Comparator<Task> byUser = Comparator.comparing(Task::getUser);
    private Comparator<Task> byHora = Comparator.comparing(Task::getStartTime);

    private Comparator ordenCreacion = byNumLlegada.thenComparing(byHora);
    private Comparator ordenPrioridad = byPrioridad.thenComparing(byUser);
    private Comparator ordenUser = byUser.thenComparing(byHora);
    private Comparator ordenPrioriLlegada = byPrioridad.thenComparing(byNumLlegada);
    private Comparator ordenLlegada = byNumLlegada.thenComparing(byHora);


    private PriorityQueue<Task> catalago;
    private PriorityQueue<Task> porHacer;
    private PriorityQueue<Task> enProgreso;
    private PriorityQueue<Task> porVerificar;
    private PriorityQueue<Task> Hecho;


    public PrioridadColas() {
        catalago = new PriorityQueue<>(ordenCreacion);
        porHacer = new PriorityQueue<>(ordenPrioridad);
        enProgreso = new PriorityQueue<>(ordenUser);
        porVerificar = new PriorityQueue<>(ordenPrioriLlegada);
        Hecho = new PriorityQueue<>(ordenLlegada);
    }

    public void registrarTarea(Task task) {
        if (task.getAssignedUser()==null || task.getAssignedUser().equals(" ")){
            task.setStatusTask(Status.CREADA);
            catalago.add(task);
        }else {
            task.setStatusTask(Status.ASIGNADA);
            porHacer.add(task);
        }
    }

    public void taskIniciada(Task task) {
        if (task.getStatusTask()==Status.ASIGNADA){
            porHacer.remove(task);
            task.setStatusTask(Status.EN_PROCESO);
            enProgreso.add(task);
            System.out.println("se agrego a la columna en proceso ");
        }else {
            System.out.println("no puede iniciar porque no tiene asignado algun user");
        }
    }

    public void taskFinalizada(Task task) {
        if (task.getStatusTask()==Status.EN_PROCESO){
            enProgreso.remove(task);
            task.setStatusTask(Status.TERMINADA);
            porVerificar.add(task);
            System.out.println("Se agregó a la columna de verificar");
        }else {
            System.out.println("no se puede agregar porque no esta en proceso");
        }
    }

    public void taskVerificada(Task task,boolean aprobada) {
        if (task.getStatusTask()==Status.TERMINADA) {
            if (aprobada) {
                porVerificar.remove(task);
                task.setStatusTask(Status.APROBADA);
                Hecho.add(task);
                System.out.println("se añadió a APROBADA");
            } else {
                porVerificar.remove(task);
                task.setStatusTask(Status.ASIGNADA);
                porHacer.remove(task);
                System.out.println("no fue aprobada");
            }
        }else {
            System.out.println("no se puede agregar porque no esta en terminada");
        }
    }

    public void println(){
        System.out.println("columna catalago");
        System.out.println(catalago);
        System.out.println("\ncolumna porHacer");
        System.out.println(porHacer);
        System.out.println("\ncolumna enProgreso");
        System.out.println(enProgreso);
        System.out.println("\ncolumna porVerificar");
        System.out.println(porVerificar);
        System.out.println("\ncolumna Hecho");
        System.out.println(Hecho);
    }*/
}
