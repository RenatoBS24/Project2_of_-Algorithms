package Inicio.MySinglyLinkedList;

public class Company {
    private String name;
    private String CEOName;
    private int sinceYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCEOName() {
        return CEOName;
    }

    public void setCEOName(String CEOName) {
        this.CEOName = CEOName;
    }

    public int getSinceYear() {
        return sinceYear;
    }

    public void setSinceYear(int sinceYear) {
        this.sinceYear = sinceYear;
    }

    public Company(String name, String CEOName, int sinceYear) {
        this.name = name;
        this.CEOName = CEOName;
        this.sinceYear = sinceYear;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)", name, CEOName, sinceYear);
    }
}
