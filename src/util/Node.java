/**
 * @author  Sebastian Diaz & Guillaume Dunant
 * Date   : 16.11.2023
 * Fichier: Node.java
 */
package util;

/**
 * Classe représentant les éléments d'une stack
 */
class Node<T> {
    private T value;
    private Node<T> previous;

    /**
     * Constructeur avec le noeud précédent null
     * @param value Valeur stockée dans le noeud
     */
    public Node(T value){
        this.value = value;
        previous = null;
    }

    /**
     * Constucteur
     * @param value Valeur stockée dans le noeud
     * @param next Noeud précédent
     */
    public Node(T value, Node<T> next){
        this(value);
        this.previous = next;
    }

    /**
     * Modifie la valeur du noeud
     * @param value Nouvelle valeur
     */
    public void setValue(T value){
        this.value = value;
    }

    /**
     * Retourne la valeur contenue dans le noeud
     * @return T
     */
    public T getValue() {
        return value;
    }

    /**
     * Modifie le noeud précédent référencé
     * @param node Nouveau noeud
     */
    public void setPrevious(Node<T> node){
        previous = node;
    }

    /**
     * Retourne le noeud précédant
     * @return Node<T>
     */
    public Node<T> getPrevious(){
        return previous;
    }
}
