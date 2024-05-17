package Inicio.Kamban;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueNumber {
    Comparator byPriorityNumber = Comparator.comparing(WorkUnit::getPriority);
    Comparator priorityRules = byPriorityNumber;
    PriorityQueue<WorkUnit> workQueue = new PriorityQueue<>(priorityRules);
}
