package Inicio.MySinglyLinkedList;

import java.util.Iterator;
import java.util.Objects;
import static java.lang.reflect.Array.newInstance;

import static java.lang.reflect.Array.newInstance;

public class SinglyLinkedList<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                try {
                    return get(index++);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return iterator;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            next = null;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head;
    private int numberOfNodes = 0;

    public SinglyLinkedList(E element) {
        head = new Node<>(element);
    }

    public SinglyLinkedList() {
        head = null;
    }


    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> end = head;
            while (end.getNext() != null) {
                end = end.getNext();
            }
            end.setNext(newNode);
        }
        numberOfNodes++;
    }

    public void add(int index, E element) throws Exception {
        Node<E> newNode = new Node<>(element);

        if ((numberOfNodes == 0 && index != 0)
                || index >= numberOfNodes || index < 0) {
            throw new Exception("Index is out of range!");
        }

        if (numberOfNodes == 0 && index == 0) {
            head = newNode;
        } else {
            Node<E> previous = getNode(index - 1);
            assert previous != null;
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }
        numberOfNodes++;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(head);
        head = newNode;
        numberOfNodes++;
    }

    public void addLast(E element) {
        add(element);
    }

    public int size() {
        return numberOfNodes;
    }

    private Node<E> getNode(int index) throws Exception {
        if (numberOfNodes == 0) return null;
        if (index >= numberOfNodes || index < 0) {
            throw new Exception("Index is out of range!");
        }

        int currentIndex = 0;
        Node<E> end = head;
        while (end.getNext() != null && currentIndex != index) {
            end = end.getNext();
            currentIndex++;
        }
        return end;
    }

    public E get(int index) throws Exception {
        return Objects.requireNonNull(getNode(index)).getElement();
    }


    public void remove(int index) {
        if (index < 0 || index >= numberOfNodes) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size() - 1) {
            removeLast();
            return;
        }

        try {
            Node<E> prevNode = getNode(index - 1);
            Node<E> aux = prevNode.getNext().getNext();
            prevNode.getNext().setNext(null);
            prevNode.setNext(aux);
            numberOfNodes--;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFirst() {
        Node<E> auxiliar = head;
        head = head.getNext();
        auxiliar.setNext(null);
        numberOfNodes--;
    }

    public void removeLast() {
        try {
            Node<E> previousNode = getNode(numberOfNodes - 2);
            previousNode.setNext(null);
            numberOfNodes--;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addAll(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public void reverse() {
        SinglyLinkedList<E> list = new SinglyLinkedList<>();
        for (int i = size() - 1; i >= 0; i--) {
            try {
                list.add(get(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        head = list.head;
    }

    public E[] toArray() {
        E[] array = (E[]) newInstance(head.getElement().getClass(), size());
        Node<E> end = head;
        int index = 0;
        while (end != null) {
            array[index] = end.getElement();
            index++;
            end = end.getNext();
        }
        return array;
    }
}
