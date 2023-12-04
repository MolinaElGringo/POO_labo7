/**
 * @author  Sebastian Diaz & Guillaume Dunant
 * Date   : 16.11.2023
 * Fichier: Stack.java
 */
package util;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implémentation de la pile
 */
public class Stack<T> {

    Node<T> head;
    int size = 0;

    /**
     * Constructeur
     */
    public Stack(){
        head = null;
    }

    /**
     * Retourne un itérateur pour parcourir la stack
     * @return Iterator<T>
     */
    public Iterator<T> getIterator(){
        Iterator<T> ite = new Iterator<>(head);
        return ite;
    }
    
    /**
     * Ajoute une valeur sur la pile
     * @param value Valeur à ajouter
     */
    public void push(T value){
        if (head == null) {
            head = new Node<T>(value);
        }
        else{
            head = new Node<T>(value, head);
        }
        ++size;
    }

    /**
     * Retourne et retire la dernière valeur de la stack
     * @return La valeur retirée
     */
    public T pop(){

        if(head == null){
            return null;
        }
        Node<T> top = head;
        head = head.getPrevious();
        --size;
        return top.getValue();
    }

    /**
     * Retourne les valeurs de la stacks en String
     */
    public String toString(){
        T[] values = getValues();
        
        if (values == null) {
            return "[]";
        }
        else{
            return Arrays.toString(getValues());
        }
    }

    /**
     * Retourne un tableau contenant les valeurs de la stacks
     * @return T[] ou null si la stack est vide
     */
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

    /**
     * Retourne le nombre d'élément de la stack
     * @return int
     */
    public int size(){
        return size;
    }

    /**
     * Retire tous les éléments de la stack
     */
    public void emptyStack(){
        head = null;
        size = 0;
    }
}
