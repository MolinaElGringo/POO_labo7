package calculator;

abstract class Operator {
    abstract void execute();
    protected State state;

    public Operator(State s){
        state = s;
    }
}

class Digit extends Operator {
    private double value;

    public Digit(State s, int val){
        super(s);
        value = val;
    }

    public void execute() {
        state.addValue(value);
    }
}

class Addition extends Operator {

    public Addition(State s){
        super(s);
    }

    public void execute() {
        double d1 = state.getValue();
        double d2 = state.getValue();
        state.addValue(d1 + d2);
    }
}

class Subtraction extends Operator {
    public Subtraction(State s){
        super(s);
    }
    public void execute() {
        double d1 = state.getValue();
        double d2 = state.getValue();
        state.addValue(d1 - d2);
    }
}

class Multiplication extends Operator {
    public Multiplication(State s){
        super(s);
    }
    public void execute() {
        double d1 = state.getValue();
        double d2 = state.getValue();
        state.addValue(d1 * d2);
    }
}

class Division extends Operator{
    public Division(State s){
        super(s);
    }
    public void execute() {
        double d1 = state.getValue();
        double d2 = state.getValue();
        state.addValue(d1 / d2);
    }
}

class SquareRoot extends Operator{
    public SquareRoot(State s){
        super(s);
    }
    public void execute() {
        double d1 = state.getValue();
        state.addValue(Math.sqrt(d1));
    }
}

class Power extends Operator{
    public Power(State s){
        super(s);
    }
    public void execute() {
        double d1 = state.getValue();
        state.addValue(d1 * d1);
    }
}

class Clear extends Operator{
    public Clear(State s){
        super(s);
    }
    public void execute() {
        // TODO
    }
}

class ClearError extends Operator{
    public ClearError(State s){
        super(s);
    }
    public void execute() {
        // TODO
    }
}

class MemoryStore extends Operator{
    public MemoryStore(State s){
        super(s);
    }
    public void execute() {
        // TODO
    }
}

class MemoryRecall extends Operator{
    public MemoryRecall(State s){
        super(s);
    }
    public void execute() {
        // TODO
    }
}


class Enter extends Operator{
    public Enter(State s){
        super(s);
    }
    public void execute() {
        // TODO
    }
}

class Negate extends Operator{
    public Negate(State s){
        super(s);
    }
    public void execute() {
        // TODO
    }
}


