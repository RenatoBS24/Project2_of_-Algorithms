package Lists.ListasEnlazadas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleCircularLinkedList<T> implements Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count<size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = currentNode.getDato();
                currentNode = currentNode.getNext();
                count++;
                return dato;
            }
        };
    }

    private Node<T> head;
    private int numberOfNodes=0;

    public DoubleCircularLinkedList(){
        head=null;
        numberOfNodes=0;
    }

    public int size(){
        return numberOfNodes;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void add(T data){
        addLast(data);
    }

    public void addFirst(T data){
        Node<T> newNode= new Node<>(data);
        if (isEmpty()){
            head=newNode;
            head.setNext(head);
            head.setPreve(head);
        }else{
            newNode.setNext(head);
            newNode.setPreve(head.getPreve());
            head.getPreve().setNext(newNode);
            head.setPreve(newNode);
            head=newNode;
        }
        numberOfNodes++;
    }

    public void addLast(T data){
        if (isEmpty()){
            addFirst(data);
        }else{
            Node<T> newNode= new Node<>(data);
            newNode.setNext(head);
            newNode.setPreve(head.getPreve());
            head.getPreve().setNext(newNode);
            head.setPreve(newNode);
            numberOfNodes++;
        }
    }

    public void add(int index, T data){
        if (index<0 || index>size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index==0){
            addFirst(data);
            return;
        }

        if (index==size()){
            addLast(data);
            return;
        }

        Node<T> newNode= new Node<>(data);
        Node<T> current=head;
        for (int i=0;i<index-1;i++){
            current=current.getNext();
        }

        //newNode= (T6) position=3
        //(T5)<--(T1)--> <--(T2)--> <--(T3)--> <--(T4)--> <--(T5)-->(T1)
        // (T5)<--(T1)--> <--(T2)--> <--(T3)--> <--(T6)--> <--(T4)--> <--(T5)-->(T1)

        newNode.setNext(current.getNext());
        newNode.setPreve(current);
        current.getNext().setPreve(newNode);
        current.setNext(newNode);
        numberOfNodes++;
    }

    public void remove(T data) throws Exception {
        if (isEmpty()){
            throw new Exception("La lista esta vacía");
        }

        Node<T> current=head;
        do{
            if (current.getDato().equals(data)){
                current.getPreve().setNext(current.getNext());
                current.getNext().setPreve(current.getPreve());
                if (current==head){
                    head=current.getNext();
                }
                numberOfNodes--;
                return;
            }
            current=current.getNext();
        }while (current!=head);

    }

    public void remove(int index) throws Exception {
        if (index<0 || index>size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index==0){
            removeFirst();
            return;
        }

        if (index==numberOfNodes-1){
            removeLast();
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPreve().setNext(current.getNext());
        current.getNext().setPreve(current.getPreve());
        numberOfNodes--;

    }

    public T  removeFirst(){
        T element = null;
        if (!isEmpty()){
            if (numberOfNodes==0){
                head=null;
            }else {
                element = head.getDato();
                head.getNext().setPreve(head.getPreve());
                head.getPreve().setNext(head.getNext());
                head=head.getNext();
            }
            numberOfNodes--;
        }
        return element;
    }

    private void removeLast(){
        if (!isEmpty()){
            if (numberOfNodes==1){
                head=null;
            }else {
                head.getPreve().getPreve().setNext(head);
                head.setPreve(head.getPreve().getPreve());
            }
            numberOfNodes--;
        }
    }

    public void reverse(){
        if(isEmpty() || numberOfNodes==1){
            return;
        }

        Node<T> current=head;
        do {
            Node<T> temp=current.getNext();
            current.setNext(current.getPreve());
            current.setPreve(temp);
            current=temp;
        }while (current!=head);
        head=head.getPreve();
    }

    public Object[] toArray(){
        if (isEmpty()){
            return null;
        }

        Object[] array = new Object[numberOfNodes];
        Node<T> current=head;
        for (int i=0;i<numberOfNodes;i++){
            array[i]=current.getDato();
            current=current.getNext();
        }
        return array;
    }

    public void addAll(T[] array){
        for (int i=0;i<array.length;i++){
            add(array[1]);
        }
    }
    public Object getNode(int index){

        if (index<0 || index>size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current=head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getDato();
    }
    public void clear(){
        head = null;
        numberOfNodes = 0;
    }
    public T getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.getDato();
    }
    public Object get(int index){

        if (index<0 || index>size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current=head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getDato();
    }



}
