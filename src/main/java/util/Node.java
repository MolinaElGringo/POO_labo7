package util;

class Node<T> {
    private T value;
    private Node<T> previous;

    public Node(T value){
        this.value = value;
        previous = null;
    }

    public Node(T value, Node<T> next){
        this(value);
        this.previous = next;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setPrevious(Node<T> node){
        previous = node;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrevious(){
        return previous;
    }
}
