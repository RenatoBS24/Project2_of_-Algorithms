package Inicio.GenericCola;

public class Queue<E> {

    private E[] elements;
    private int size;
    private int start;
    private int end;

    public Queue(int capacity) {
        elements = (E[]) new Object[capacity];
        size = start = end = 0;
    }

    public void enqueue(E e) throws Exception {
        if (size == elements.length) {
            throw new Exception("Queue is full.");
        }

        elements[end] = e;
        end = (end + 1) % elements.length;
        size++;
    }

    public E dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty.");
        }

        E data = elements[start];
        elements[start] = null;
        start = (start + 1) % elements.length;
        size--;
        return data;
    }

    public E peek() {
        return size > 0 ? elements[start] : null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[(start + i) % elements.length] = null;
        }
        size = start = end = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
