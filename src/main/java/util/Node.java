package util;

class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value){
        this.value = value;

    }

    public Node(T value, Node<T> next){
        this(value);
        this.next = next;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setNext(Node<T> node){
        next = node;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext(){
        return next;
    }
}
