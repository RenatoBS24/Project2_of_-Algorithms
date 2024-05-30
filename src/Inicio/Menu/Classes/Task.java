package Inicio.Menu.Classes;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private static int idCounter = 0;
    private String name;
    private LocalDateTime startTime;
    private State state;
    private int priority;
    private User user;

    public Task(User user, State state, String name, int priority) {
        this.id = ++idCounter;
        this.user = user;
        this.state = state;
        this.name = name;
        startTime = LocalDateTime.now();
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", state=" + state +
                ", priority=" + priority +
                ", user=" + user +
                '}';
    }
}
