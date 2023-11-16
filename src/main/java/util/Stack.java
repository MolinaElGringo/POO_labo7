package util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {

    Node<T> head;
    int size = 0;
    Class<T> classT;

    private Iterator<T> getIterator(){
        Iterator<T> ite = new Iterator<>(head);
        return ite;
    }

    public Stack(Class<T> cls){
        head = null;
        classT = cls;
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
        
        T[] values = (T[]) Array.newInstance(classT, size);
        int counter = 0;
        Iterator<T> ite = getIterator();
        while(ite.hasNext()){
            values[counter++] = ite.next();
        }
        return values;
    }
}
