package Lists.MyCircularLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {
            int index = 0;
            int expectedSize = size();
            @Override
            public boolean hasNext() {
                return index<size();
            }
            @Override
            public Object next() {

                if (index >= expectedSize) {
                    throw new NoSuchElementException();
                }
                try {
                    T data = get(index);
                    index = (index + 1) % size(); // Manejo circular
                    return data;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return iterator;
    }
    public static class Nodo<T>{
        private T elemento;
        private Nodo<T> siguiente;
        public Nodo(T elemento){
            this.elemento = elemento;
            this.siguiente = null;
        }
        public T getElemento(){
            return elemento;
        }
        public Nodo<T> getSiguiente(){
            return siguiente;
        }
        public void setSiguiente(Nodo<T> siguiente){
            this.siguiente = siguiente;
        }
    }
    private int numerodeNodos;
    private Nodo<T> inicio;
    public void add(T elemento){
        Nodo<T> nodo = new Nodo(elemento);
        if(size() == 0){
            inicio = nodo;
            nodo.setSiguiente(inicio);
        }else {
            Nodo<T> auxiliar = inicio;
            while (auxiliar.getSiguiente() != inicio){
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nodo);
            nodo.setSiguiente(inicio);
        }
        numerodeNodos++;
    }
    public void addLast(T elemento){
        add(elemento);
    }
    public void addFirst(T elemento){
        Nodo<T> nodo = new Nodo(elemento);
        if(size() == 0){
            inicio = nodo;
            nodo.setSiguiente(inicio);
        }else{
            Nodo<T> auxiliar = inicio;
            while (auxiliar.getSiguiente() != inicio){
                auxiliar = auxiliar.getSiguiente();
            }
            nodo.setSiguiente(inicio);
            auxiliar.setSiguiente(nodo);
            inicio = nodo;
        }
        numerodeNodos++;
    }
    public void add(T elemento, int pos){
        Nodo<T> nodo = new Nodo(elemento);
        if(pos<0 || pos > size()){
            throw new IndexOutOfBoundsException("El indice no es valido");
        }
        if(size() == 0){
            inicio = nodo;
            nodo.setSiguiente(inicio);
        }else{
            Nodo<T> auxiliar = inicio;
            Nodo<T> before = getNodo(pos-1);
            nodo.setSiguiente(before.getSiguiente());
            before.setSiguiente(nodo);
        }
        numerodeNodos++;
    }
    public void addAll(Lista<T> lista){
        for (T elementos: lista){
            add(elementos);
        }
    }
    public Nodo<T> getNodo(int pos){
        if(size() == 0){
            return null;
        }else{
            Nodo<T> auxiliar = inicio;
            int index = 0;
            while (auxiliar.getSiguiente() != inicio && index != pos){
                auxiliar = auxiliar.getSiguiente();
                index++;
            }
            return auxiliar;
        }
    }
    public void removeFirst() {
       if(size() == 0){
           throw new IndexOutOfBoundsException("El indice no es valido");
       }
       Nodo<T> auxiliar = inicio.getSiguiente();
       Nodo<T> end = inicio;
       while(end.getSiguiente() != inicio){
           end = end.getSiguiente();
       }
       inicio = auxiliar;
       end.setSiguiente(inicio);
       numerodeNodos--;
    }

    public void removeLast() {
       if(size() == 0){
           throw new IndexOutOfBoundsException("El indice no es valido");
       } else if (size() == 1) {
           inicio = null;
       }
       Nodo<T> previo = getNodo(numerodeNodos - 1);
       previo.setSiguiente(inicio);
        numerodeNodos--;

    }
    public void remove(int pos) throws Exception{
        if(pos<0 || pos>=size()){
             throw new Exception("El indice no es valido");
        }
        if (pos == 0) {
            removeFirst();
            return;
        }
        if (pos == size() - 1) {
            removeLast();
            return;
        }
        Nodo previo = getNodo(pos - 1);
        Nodo aux = previo.getSiguiente().getSiguiente();
        previo.getSiguiente().setSiguiente(null);
        previo.setSiguiente(aux);
        numerodeNodos--;

    }
    public T get(int pos){
        return getNodo(pos).getElemento();
    }
    public int size(){
        return numerodeNodos;
    }
    public void reverse(){
        Lista list = new Lista();
        for (int i = size()-1; i >=0 ; i--) {
            try {
                list.add(get(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        inicio = list.inicio;
    }
    public Object[] toArray(){
        Object [] list = new Object[size()];
        Nodo end = inicio;
        int index = 0;
        while (end!= null) {
            list[index] = end.getElemento();
            index++;
            end = end.getSiguiente();
        }
        return list;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public void clear(){
        inicio = null;
        numerodeNodos = 0;
    }

}
