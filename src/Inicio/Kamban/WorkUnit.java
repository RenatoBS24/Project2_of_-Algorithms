package Inicio.Kamban;

import java.time.LocalDateTime;

public class WorkUnit {
    private int taskNumber;//Implementar un metodo para asignar automaticamente un numero a las tareas
    private String name;
    private LocalDateTime dateTimeRegister;
    private State state;
    private int priority;
    private String assignedPerson;

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTimeRegister() {
        return dateTimeRegister;
    }

    public void setDateTimeRegister(LocalDateTime dateTimeRegister) {
        this.dateTimeRegister = dateTimeRegister;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(String assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public WorkUnit(int taskNumber, String name, LocalDateTime dateTimeRegister, State state, int priority, String assignedPerson) {
        this.taskNumber = taskNumber;
        this.name = name;
        this.dateTimeRegister = dateTimeRegister;
        this.state = state;
        this.priority = priority;
        this.assignedPerson = assignedPerson;
    }
}
