package util;

public class Stack<T> {

    Node<T> head;

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
    }

    public T pop(){
        Node<T> top = head;
        head = head.getPrevious();
        return top.getValue();
    }

    public String toString(){
        return null;
    }

    public T[] getValues(){
        return null;
    }
}
