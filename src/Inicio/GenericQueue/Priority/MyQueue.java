package Inicio.GenericQueue.Priority;

import Inicio.Menu.Classes.Task;
import Lists.ListasEnlazadas.DoubleCircularLinkedList;

import java.util.Comparator;
import java.util.Iterator;

public class MyQueue<T> implements Iterable<T>{
    private DoubleCircularLinkedList<T> elements;
    private Comparator<T> comparator;
    public MyQueue(Comparator<T> comparator){
        elements = new DoubleCircularLinkedList<>();
        this.comparator = comparator;
    }

    public void enqueue(T e) {
        System.out.println("elementos"+e);
        if(elements.isEmpty()){
            elements.add(e);
        }
        else {
            try{
                int index = 0;
                while (index< elements.size() && comparator.compare(e, (T) elements.get(index)) >=0){
                    index ++;
                }
                System.out.println("este es xd"+index);
                if (index >= elements.size()) {
                    elements.add(e);
                } else {
                    elements.add(index, e);
                }
            }catch (Exception ex){
                throw new RuntimeException("Error al encolar elemento: " + ex.getMessage());
            }
        }
    }

    public T dequeue() {
        return elements.removeFirst();
    }

    public T peek() {
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                try {
                    return (T) elements.get(index++);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
