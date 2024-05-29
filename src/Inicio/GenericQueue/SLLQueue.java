package Inicio.GenericQueue;
import Lists.MySinglyLinkedList.SinglyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

public class SLLQueue<T> implements Iterable<T>{

    private  SinglyLinkedList<T> elements;
    private Comparator<T> comparator;

    public SLLQueue() {
        this.elements = new SinglyLinkedList<>();
    }
    public SLLQueue(Comparator<T> comparator) {
        this.elements = new SinglyLinkedList<>();
        this.comparator = comparator;
    }


    public void enqueue(T e) throws Exception {
            if(elements.isEmpty()){
                elements.add(e);
            }
            else {
                try{
                    int index = 0;
                    while (index< elements.size() && comparator.compare(e,elements.get(index)) >0){
                        index ++;
                    }
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
    public  void add(T e) throws Exception {
        elements.add(e);
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
                    return elements.get(index++);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
