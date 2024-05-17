package Inicio.Kamban;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePersonAndNumber {
    Comparator byPriorityNumber = Comparator.comparing(WorkUnit::getPriority);
    Comparator byPriorityPerson = Comparator.comparing(WorkUnit::getAssignedPerson);
    Comparator priorityRules = byPriorityPerson.thenComparing(byPriorityNumber);
    PriorityQueue<WorkUnit> personQueue = new PriorityQueue<>(priorityRules);
}
