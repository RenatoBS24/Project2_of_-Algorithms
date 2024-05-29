package Inicio.GenericQueue;
import Lists.MySinglyLinkedList.SinglyLinkedList;
public class SLLQueue<T> {

    private final SinglyLinkedList<T> elements;

    public SLLQueue() {
        this.elements = new SinglyLinkedList<>();
    }

    public void enqueue(T e) {
        elements.addLast(e);
    }

    public T dequeue() throws Exception {
        return elements.dequeue();
    }

    public T peek() throws Exception {
        return elements.getFirst();
    }

    public int size() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

}
