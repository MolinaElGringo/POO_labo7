package calculator;

abstract class Operator {
    abstract void execute();
    protected State state;

    public Operator(State s){
        state = s;
    }
}

class Digit extends Operator {
    private String value;

    public Digit(State s, int val){
        super(s);
        value = "" + val;
    }

    public void execute() {
        String actualVal = state.getValue();

        if(actualVal == null){
            state.addValue(value);
        }
        else{
            state.addValue(actualVal + value);
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
        double d1 = Double.parseDouble(state.getValue());
        double d2 = Double.parseDouble(state.getValue());
        Double result = d1 + d2;
        state.addValue(result.toString());
    }
}

class Subtraction extends Operator {
    public Subtraction(State s){
        super(s);
    }
    public void execute() {
        double d1 = Double.parseDouble(state.getValue());
        double d2 = Double.parseDouble(state.getValue());
        Double result = d1 - d2;
        state.addValue(result.toString());
    }
}

class Multiplication extends Operator {
    public Multiplication(State s){
        super(s);
    }
    public void execute() {
        double d1 = Double.parseDouble(state.getValue());
        double d2 = Double.parseDouble(state.getValue());
        Double result = d1 * d2;
        state.addValue(result.toString());
    }
}

class Division extends Operator{
    public Division(State s){
        super(s);
    }
    public void execute() {
        double d1 = Double.parseDouble(state.getValue());
        double d2 = Double.parseDouble(state.getValue());
        Double result = d1 / d2;
        state.addValue(result.toString());
    }
}

class SquareRoot extends Operator{
    public SquareRoot(State s){
        super(s);
    }
    public void execute() {
        Double d1 = Double.parseDouble(state.getValue());
        d1 = Math.sqrt(d1);
        state.addValue(d1.toString());
    }
}

class Power extends Operator{
    public Power(State s){
        super(s);
    }
    public void execute() {
        Double d1 = Double.parseDouble(state.getValue());
        d1 *= d1;
        state.addValue(d1.toString());
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
        state.addValue("0");
    }
}

class Negate extends Operator{
    public Negate(State s){
        super(s);
    }
    public void execute() {
        Double d = Double.parseDouble(state.getValue());
        d *= -1.;
        state.addValue(d.toString());
    }
}

class Inverse extends Operator{
    public Inverse(State s){
        super(s);
    }
    public void execute() {
        Double d = Double.parseDouble(state.getValue());
        d = 1/d;
        state.addValue(d.toString());
    }
}


