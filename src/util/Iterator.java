/**
 * @author  Sebastian Diaz & Guillaume Dunant
 * Date   : 16.11.2023
 * Fichier: Iterator.java
 */
package util;

/**
 * Iterateur simple permettant de parcourir une suite de noeud
 */
public class Iterator<T>{
    private Node<T> value;

    /**
     * Constructeur
     * @param head Neud à partir du quel commencer
     */
    public Iterator(Node<T> head){
        value = new Node<T>(null, head);
    }

    /**
     * Retourne la prochaine valeur non retournée
     * @return T
     */
    public T next(){

        if(!hasNext()){
            return null;
        }
        else{
            value = value.getPrevious();
            return value.getValue();
        }
    }

    /**
     * Définit si une aleur suivante est disponible
     * @return true si une valeur est disponible
     */
    public boolean hasNext(){
        return (value.getPrevious() != null);
    } 
}