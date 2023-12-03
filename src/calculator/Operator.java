/**
 * @author  Sebastian Diaz & Guillaume Dunant
 * Date   : 16.11.2023
 * Fichier: Operator.java
 */
package calculator;

/**
 * Classe abstraite permettant de représenter
 *  une opération de la caluclatrice à effectuer
 */
abstract class Operator {
    protected State state;
    /**
     * Méthode qui sera appelée pour effectuer l'opération
     */
    abstract void execute();

    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Operator(State s){
        state = s;
    }
}

/**
 * Opération rajoutant un chiffre à la valeur courante
 */
class Digit extends Operator {
    private String value;
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     * @param val Valeur qui sera ajoutée à la valeur courante
     */
    public Digit(State s, int val){
        super(s);
        value = "" + val;
    }

    public void execute() {
        if(state.noError() && state.isUserInput()) {
            state.appendToCurrent(value);
        }
    }
}

/**
 * Opération ajouant un point à la valeur courante
 */
class Point extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Point(State s) {
        super(s);
    }

    public void execute() {
        if (state.noError() && state.isUserInput()) {
            state.appendToCurrent(".");
        }
    }
}

/**
 * Opération permettant d'enlevé un caractère de la valeur courante
 */
class Backspace extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Backspace(State s) {
        super(s);
    }

    public void execute() {
        if(state.noError() && state.isUserInput()){
            state.removeACharFromCurrent();
        }
    }
}

/**
 * Classe abstraite représentant les opérations nécessitant deux opérandes
 */
abstract class DoubleOperation extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public DoubleOperation(State s) {
        super(s);
    }

    /**
     * Opération qui sera effectuée entre les deux valeurs
     * @param d1 Valeur 1
     * @param d2 Valeur 2
     * @return Résultat de l'opération
     */
    abstract protected Double operate(Double d1, Double d2);

    public void execute() {
        if(state.noError()){
            Double d1 = state.getCurrent();
            Double d2 = state.getStackValue();

            if(d1 != null && d2 != null){
                state.setCurrent(operate(d1, d2));
                state.setUserInput(false);
            }
            else{
                state.setError();
            }
        }
    }
}

/**
 * Opération d'addition
 */
class Addition extends DoubleOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Addition(State s) {
        super(s);
    }

    protected Double operate(Double d1, Double d2) {
        return d1 + d2;
    }
}

/**
 * Opération de soustraction
 */
class Subtraction extends DoubleOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Subtraction(State s) {
        super(s);
    }

    protected Double operate(Double d1, Double d2) {
        return d1 - d2;
    }

}

/**
 * Opération de multiplication
 */
class Multiplication extends DoubleOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Multiplication(State s) {
        super(s);
    }

    protected Double operate(Double d1, Double d2) {
        return d1 * d2;
    }
}

/**
 * Opération de division
 */
class Division extends DoubleOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Division(State s) {
        super(s);
    }

    protected Double operate(Double d1, Double d2) {
        return d2 / d1;
    }
}

/**
 * Classe abstraite représentant les opérations nécessitant une seule opérande
 */
abstract class UnaryOperation extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public UnaryOperation(State s) {
        super(s);
    }

    /**
     * Operation qui sera effectuée sur la valeur courante
     * @param d1 Valeur qui sera modifiée
     * @return Nouvelle valeur
     */
    abstract protected Double operate(Double d1);

    public void execute() {
        if(state.noError()){
            Double d1 = state.getCurrent();
            if(d1 != null){
                state.setCurrent(operate(d1));
                state.setUserInput(false);
            }
            else{
                state.setError();
            }
        }
    }
}

/**
 * Opération pour retourner la racine carrée de la valeur courante
 */
class SquareRoot extends UnaryOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public SquareRoot(State s) {
        super(s);
    }

    protected Double operate(Double d1) {
        return Math.sqrt(d1);
    }
}

/**
 * Opération pour retourner le carré de la valeur courante
 */
class Power extends UnaryOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Power(State s) {
        super(s);
    }

    protected Double operate(Double d1) {
        return d1 * d1;
    }
}

/**
 * Opération pour changer le signe de la valeur courante
 */
class Negate extends Operator{
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Negate(State s) {
        super(s);
    }

    public void execute(){
        if(state.noError()){
            if(state.isUserInput()){
                state.negateCurrent();
            }
            else{
                state.setCurrent(-state.getCurrent());
            }
        }
    }
}

/**
 * Opération pour obtenir l'inverse de la valeur courante
 */
class Inverse extends UnaryOperation {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Inverse(State s) {
        super(s);
    }

    protected Double operate(Double d1) {
        return 1 / d1;
    }
}

/**
 * Opération pour réinitialiser la valeur courante et la stack
 */
class Clear extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Clear(State s) {
        super(s);
    }

    public void execute() {
        state.emptyStack();
        state.rstState();
    }
}

/**
 * Opération pour réinitialiser la valeur courante
 */
class ClearError extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public ClearError(State s) {
        super(s);
    }

    public void execute() {
        state.rstState();
    }
}

/**
 * Opération pour stocker une valeur en mémoire
 */
class MemoryStore extends Operator {
   /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public MemoryStore(State s) {
        super(s);
    }

    public void execute() {
        if(state.noError()){
            state.storeInMemory();
            state.setUserInput(true);
        }
    }
}

/**
 * Opération pour récupérer la valeur stockée en mémoire
 */
class MemoryRecall extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public MemoryRecall(State s) {
        super(s);
    }

    public void execute() {
        if(state.noError()){
            state.getMemory();
            state.setUserInput(false);
        }
        
    }
}

/**
 * Opération pour ajouter la valeur courante sur la stack
 */
class Enter extends Operator {
    /**
     * Constructeur
     * @param s Etat interne de la calculatrice
     */
    public Enter(State s) {
        super(s);
    }

    public void execute() {
        if(state.noError()){
            state.pushCurrent();
            state.setUserInput(true);
        }
    }
}




