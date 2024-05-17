package Inicio.Kamban;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrioriryQueuePerson {
    Comparator byPriorityPerson = Comparator.comparing(WorkUnit::getAssignedPerson);
    Comparator priorityRules = byPriorityPerson;
    PriorityQueue<WorkUnit> personQueue = new PriorityQueue<>(priorityRules);
}
