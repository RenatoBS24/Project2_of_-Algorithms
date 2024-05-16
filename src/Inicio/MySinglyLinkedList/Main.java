package Inicio.MySinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Company> companyList = new SinglyLinkedList<>();

        companyList.add(new Company("Microsoft", "Satya Nadella", 1975));
        companyList.add(new Company("Tesla", "Elon Musk", 1980));
        companyList.add(new Company("Google", "Sundar Pichai", 1991));

        // Mostrar el tamaño de la lista
        System.out.println("Tamaño de la lista: " + companyList.size());

        System.out.println("Lista de compañías:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        try {
            companyList.remove(1);
        } catch (Exception e) {
            System.out.println("Error al eliminar la compañía: " + e.getMessage());
        }

        System.out.println("\nTamaño de la lista después de eliminar: " + companyList.size());

        System.out.println("Lista de compañías después de eliminar:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        try {
            companyList.add(1, new Company("Apple", "Tim Cook", 1976));
        } catch (Exception e) {
            System.out.println("Error al agregar la compañía en la posición 1: " + e.getMessage());
        }

        System.out.println("\nTamaño de la lista después de agregar: " + companyList.size());

        System.out.println("Lista de compañías después de agregar:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        companyList.addFirst(new Company("Amazon", "Jeff Bezos", 1994));

        System.out.println("\nTamaño de la lista después de agregar al principio: " + companyList.size());

        System.out.println("Lista de compañías después de agregar al principio:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        companyList.addLast(new Company("Facebook", "Mark Zuckerberg", 2004));

        System.out.println("\nTamaño de la lista después de agregar al final: " + companyList.size());

        System.out.println("Lista de compañías después de agregar al final:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        companyList.removeFirst();

        System.out.println("\nTamaño de la lista después de eliminar la primera compañía: " + companyList.size());

        System.out.println("Lista de compañías después de eliminar la primera compañía:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        companyList.removeLast();

        System.out.println("\nTamaño de la lista después de eliminar la última compañía: " + companyList.size());

        System.out.println("Lista de compañías después de eliminar la última compañía:");
        for (Company company : companyList) {
            System.out.println(company);
        }

        /*Company[] companiesArray = companyList.toArray();

        System.out.println("\nArray de compañías:");
        for (Company company : companiesArray) {
            System.out.println(company);
        }
        */
        companyList.reverse();

        System.out.println("\nLista de compañías después de revertirla:");
        for (Company company : companyList) {
            System.out.println(company);
        }
    }
}
