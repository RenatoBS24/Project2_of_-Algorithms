package LinkedList;

public class Node <T>{
    private T dato;
    private Node<T> next;
    private Node<T> preve;

    public Node(T dato){
        this.dato = dato;
        next = null;
        preve = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> siguiente) {
        this.next = siguiente;
    }

    public Node<T> getPreve() {
        return preve;
    }

    public void setPreve(Node<T> preve) {
        this.preve = preve;
    }

    public T getDato() {
        return dato;
    }
}
