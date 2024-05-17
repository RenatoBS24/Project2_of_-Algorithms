package Inicio.Kamban;

public class Proyect {
    private String name;
    private String description;
    private String nameUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Proyect(String name, String description, String nameUser) {
        this.name = name;
        this.description = description;
        this.nameUser = nameUser;
    }
}
