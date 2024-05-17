package Inicio.GenericCola;

public class GenericSLLQueue {
    private final Queue<String> elements;

    public GenericSLLQueue(int capacity) {
        this.elements = new Queue<>(capacity);
    }

    public void enqueue(String e) throws Exception {
        elements.enqueue(e);
    }

    public String dequeue() throws Exception {
        return elements.dequeue();
    }

    public String peek() {
        return elements.peek();
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
