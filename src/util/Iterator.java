package util;

public class Iterator<T>{
    private Node<T> value;

    public Iterator(Node<T> head){
        value = new Node<T>(null, head);
    }

    public T next(){
        value = value.getPrevious();
        return value.getValue();
    }

    public boolean hasNext(){
        return (value.getPrevious() != null);
    } 
}