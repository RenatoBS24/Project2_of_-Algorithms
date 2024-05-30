package Lists.Stack;

import Lists.MyCircularLinkedList.Lista;

public class SLLStack<E> {
    private Lista<E> elements = new Lista<>();

    public void push(E e) {
        elements.addLast(e);
    }

    public E pop() throws Exception {
        return elements.removeLast();
    }

    public E peek() throws Exception {
        return elements.getLast();
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
}
