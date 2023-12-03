/**
 * @author  Sebastian Diaz & Guillaume Dunant
 * Date   : 16.11.2023
 * Fichier: State.java
 */
package calculator;

import util.Iterator;
import util.Stack;

/**
 * Classe servant à représenter l'état interne 
 * de la calculatrice
 */
public class State {
    private static final String ERROR = "# error #";
    private static final String DEFAULTVAL = "0";
    private static final String NEGATE = "-";
    private static final String DOT = ".";

    private Stack<Double> stack = new Stack<>();
    private Double memory = 0.;
    
    private String currentVal = DEFAULTVAL;
    private boolean isError = false;
    private boolean userInput = true;
    
    /**
     * Passe la calculatrice en mode erreur
     */
    public void setError() {
        isError = true;
        currentVal = ERROR;
    }

    /**
     * Enlève le mode erreur de la calculatrice
     */
    public void rstError() {
        isError = false;
        currentVal = DEFAULTVAL;
    }

    /**
     * Obtient l'état du erreur 
     * @return true s'il la calculatrice 
     * n'est pas en mode erreur
     */
    public boolean noError() {
        return !isError;
    }

    /**
     * Obtient si la valeur courante est une entrée de l'utilisateur 
     * ou le résultat d'une opération
     * @return true si c'est ue entrée de l'utilisateur
     */
    public boolean isUserInput(){
        return userInput;
    }

    /**
     * Change l'état de userInput
     * @param bool Nouvel état
     */
    public void setUserInput(boolean bool){
        userInput = bool;
    }

    /**
     * Obtient la valeur du dessus de la stack
     * @return Double
     */
    public Double getStackValue(){ 
        return stack.pop();
    }
    
    /**
     * Ajoute un String à la fin de la valeur courrante
     * @param s1 String à ajouter
     */
    public void appendToCurrent(String s1) {
        if (currentVal == null || currentVal.equals(DEFAULTVAL)) {
            currentVal = s1;
        } else if(s1.equals(DOT)) {
            if (!currentVal.contains(DOT)) {
                currentVal += s1;
            }
        }
        else {
            currentVal += s1;
        }
    }

    /**
     * Enlève le dernier caractère de la valeur courante
     */
    public void removeACharFromCurrent(){ 
        currentVal = currentVal.substring(0, currentVal.length() - 1);
    }

    /**
     * Obtient la valeur courante en Double
     * @return La valeur courante ou null si l'état 
     * est en mode erreur
     */
    public Double getCurrent(){
        if(currentVal.equals(ERROR)){
            return null;
        }
        else{
            return Double.parseDouble(currentVal);
        }
    }

    /**
     * Obtient la valeur courante en String
     * @return String
     */
    public String getCurrentInString(){
        return currentVal;
    }

    /**
     * Défini une nouvelle valeur courante
     * @param val Nouvelle valeur
     */
    public void setCurrent(Double val){
        currentVal = val.toString();
    }

    /**
     * Déplace la valeur courante sur la stack
     */
    public void pushCurrent(){
        stack.push(Double.parseDouble(currentVal));
        currentVal = DEFAULTVAL;
    }

    /**
     * Inverse le signe de la valeur courrante
     */
    public void negateCurrent(){
        if(currentVal.contains(NEGATE)){
            currentVal = currentVal.substring(1, currentVal.length());
        }
        else{
            currentVal = NEGATE + currentVal;
        }
    }

    /**
     * Stock la valeur courante dans la mémoire
     */
    public void storeInMemory(){
        memory = getCurrent();
        currentVal = DEFAULTVAL;
    }

    /**
     * Modifie la valeur courante par la valeur en mémoire
     */
    public void getMemory(){
        setCurrent(memory);
    }

    /**
     * Retourne les valeurs dans la stack au format String
     * @return String[] contenant les valeurs ou null si la stack est vide
     */
    public String[] getStackInString(){
        if(stack.size() == 0){
            return null;
        }

        String[] stringStack = new String[stack.size()];
        Iterator<Double> i = stack.getIterator();
        int counter = stack.size();

        while(i.hasNext()){
            stringStack[--counter] = i.next().toString();
        }

        return stringStack;
    }

    /**
     * Réinitialise l'état interne
     */
    public void rstState(){
        rstError();
        currentVal = DEFAULTVAL;
        setUserInput(true);
    }

    /**
     * Vide la stack
     */
    public void emptyStack(){
        stack.emptyStack();
    }
}
