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

        if(actualVal == null || actualVal.equals("0")){
            state.addValue(value);
        }
        else if(actualVal.equals("**Error**")){
            state.addValue(actualVal);
        }
        else{
            state.addValue(actualVal + value);
        }

    }
}

class Point extends Operator{

    public Point(State s){
        super(s);
    }

    public void execute(){
        String val = state.getValue();
        if(!val.contains(".")){
            state.addValue(val + ".");
        }
        else{
            state.addValue(val);
        }
    }
}

class Backspace extends Operator{

    public Backspace(State s){
        super(s);
    }


    public void execute(){
        String val = state.getValue();
        val = val.substring(0, val.length() - 1);
        if(val.isEmpty()){
            val = "0";
        }
        state.addValue(val);
    }
}
abstract class DoubleOperation extends Operator {

    private Operator op;

    public DoubleOperation(State s1) {
        super(s1);
    }

    abstract protected Double operate(Double d1, Double d2);

    public final void execute() {
        try {
            Double d1 = Double.parseDouble(state.getValue());
            Double d2 = Double.parseDouble(state.getValue());
            state.addValue(operate(d1, d2).toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            state.addValue("**Error**");
        }
    }
}

class Addition extends DoubleOperation{

    public Addition(State s){
        super(s);
    }

    @Override
    protected Double operate(Double d1, Double d2) {
        return d1 + d2;
    }
}

class Subtraction extends DoubleOperation {
    public Subtraction(State s){
        super(s);
    }
    @Override
    protected Double operate(Double d1, Double d2) {
        return d1 - d2;
    }

}

class Multiplication extends DoubleOperation {
    public Multiplication(State s){
        super(s);
    }
    @Override
    protected Double operate(Double d1, Double d2) {
        return d1 - d2;
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
        d1 = Math.pow(d1, 2);
        state.addValue(d1.toString());
    }
}

class Clear extends Operator{
    public Clear(State s){
        super(s);
    }
    public void execute() {
        while (state.getValue() != null){}
        state.addValue("0");
    }
}

class ClearError extends Operator{
    public ClearError(State s){
        super(s);
    }
    public void execute() {
        state.getValue();
        state.addValue("0");
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
    public Enter(State s){
        super(s);
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


