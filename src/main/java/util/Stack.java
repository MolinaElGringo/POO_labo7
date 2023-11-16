package util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {

    Node<T> head;
    int size = 0;

    private Iterator<T> getIterator(){
        Iterator<T> ite = new Iterator<>(head);
        return ite;
    }

    public Stack(){
        head = null;
    }
    
    public void push(T value){
        if (head == null) {
            head = new Node<T>(value);
        }
        else{
            head = new Node<T>(value, head);
        }
        ++size;
    }

    public T pop(){
        Node<T> top = head;
        head = head.getPrevious();
        --size;
        return top.getValue();
    }

    public String toString(){
        return Arrays.toString(getValues());
    }

    public T[] getValues(){

        if(head == null){
            return null;
        }
        
        T[] values = (T[]) Array.newInstance(head.getValue().getClass(), size);
        int counter = 0;
        Iterator<T> ite = getIterator();
        while(ite.hasNext()){
            values[counter++] = ite.next();
        }
        return values;
    }
}
