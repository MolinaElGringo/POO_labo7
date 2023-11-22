package calculator;

abstract class Operator {
    abstract void execute();
    protected State state;

    public Operator(State s){
        state = s;
    }
}

class Digit extends Operator {
    private int value;
    private JCalculator calculator;

    public Digit(JCalculator c, State s, int val){
        super(s);
        value = val;
        calculator = c;
    }

    public void execute() {
        if(calculator.getText().compareTo("0") == 0){
            calculator.setText(value + "");
        }
        else{
            calculator.setText(calculator.getText() + value);
        }
    }
}

class Point extends Operator{
    JCalculator calculator;

    public Point(JCalculator c, State s){
        super(s);
        calculator = c;
    }


    public void execute(){
        calculator.setText(calculator.getText() + ".");
    }
}

class Backspace extends Operator{
    JCalculator calculator;

    public Backspace(JCalculator c, State s){
        super(s);
        calculator = c;
    }


    public void execute(){
        calculator.setText(calculator.getText().substring(0, calculator.getText().length() - 1));
        if(calculator.getText().isEmpty()){
            calculator.setText("0");
        }
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
        state.storeInMemory();
    }
}

class MemoryRecall extends Operator{
    public MemoryRecall(State s){
        super(s);
    }
    public void execute() {
        state.getMemory();
    }
}


class Enter extends Operator{
    private JCalculator calculator;
    public Enter(JCalculator c, State s){
        super(s);
        calculator = c;
    }
    public void execute() {
        state.addValue(Double.parseDouble(calculator.getText()));
        calculator.setText(0 + "");
    }
}

class Negate extends Operator{
    public Negate(State s){
        super(s);
    }
    public void execute() {
        Double d = state.getValue();
        state.addValue(d * (-1.));
    }
}

class Inverse extends Operator{
    public Inverse(State s){
        super(s);
    }
    public void execute() {
        Double d = state.getValue();
        state.addValue(1 / d);
    }
}


