package Inicio.Kamban;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueNumberAndArrival {
    Comparator byPriorityNumber = Comparator.comparing(WorkUnit::getPriority);
    Comparator byPriorityArrival = Comparator.comparing(WorkUnit::getDateTimeRegister);//cambiar "getDateTimeRegister a un valor de orden de llegada actual"
    Comparator priorityRules = byPriorityNumber.thenComparing(byPriorityArrival);
    PriorityQueue<WorkUnit> personQueue = new PriorityQueue<>(priorityRules);
}
