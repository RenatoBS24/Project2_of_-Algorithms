package Lists.Stack;
import Lists.MyCircularLinkedList.Lista;

public class MyStack<E> {
    private Lista<E> elements;

    public MyStack() {
        elements = new Lista<>();
    }

    public void push(E e) {
        elements.add(e);
    }

    public E pop() throws Exception {
        if (elements.isEmpty()) {
            throw new Exception("Stack is empty");
        } else {
            return elements.removeLast();
        }
    }

    public E peek() throws Exception {
        if (elements.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return elements.getFirst();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public E get(int index){
        return elements.get(index);
    }

    public E elementAt(int i) {
        return null;
    }
}
