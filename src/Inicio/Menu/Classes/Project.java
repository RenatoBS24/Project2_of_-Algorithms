package Inicio.Menu.Classes;

public class Project {
    private String name;
    private String description;
    private String user;

    public Project(String name, String user, String description) {
        this.name = name;
        this.user = user;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
