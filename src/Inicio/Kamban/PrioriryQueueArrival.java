package Inicio.Kamban;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrioriryQueueArrival {
    Comparator byPriorityArrival = Comparator.comparing(WorkUnit::getDateTimeRegister);//cambiar "getDateTimeRegister a un valor de orden de llegada actual"
    Comparator priorityRules = byPriorityArrival;
    PriorityQueue<WorkUnit> personQueue = new PriorityQueue<>(priorityRules);
}
