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
        if(state.noError() && state.isUserInput()) {
            state.appendToCurrent(value);
        }
    }
}

class Point extends Operator {

    public Point(State s) {
        super(s);
    }

    public void execute() {
        if (state.noError() && state.isUserInput()) {
            state.appendToCurrent(".");
        }
    }
}


class Backspace extends Operator {

    public Backspace(State s) {
        super(s);
    }

    public void execute() {
        if(state.noError() && state.isUserInput()){
            state.removeACharFromCurrent();
        }
    }
}

abstract class DoubleOperation extends Operator {

    public DoubleOperation(State s1) {
        super(s1);
    }

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

class Addition extends DoubleOperation {

    public Addition(State s) {
        super(s);
    }

    @Override
    protected Double operate(Double d1, Double d2) {
        return d1 + d2;
    }
}

class Subtraction extends DoubleOperation {
    public Subtraction(State s) {
        super(s);
    }

    @Override
    protected Double operate(Double d1, Double d2) {
        return d1 - d2;
    }

}

class Multiplication extends DoubleOperation {
    public Multiplication(State s) {
        super(s);
    }

    @Override
    protected Double operate(Double d1, Double d2) {
        return d1 * d2;
    }
}

class Division extends DoubleOperation {
    public Division(State s) {
        super(s);
    }

    @Override
    protected Double operate(Double d1, Double d2) {
        return d2 / d1;
    }
}

abstract class UnaryOperation extends Operator {
    public UnaryOperation(State s) {
        super(s);
    }

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

class SquareRoot extends UnaryOperation {
    public SquareRoot(State s) {
        super(s);
    }

    protected Double operate(Double d1) {
        return Math.sqrt(d1);
    }
}

class Power extends UnaryOperation {
    public Power(State s) {
        super(s);
    }

    protected Double operate(Double d1) {
        return d1 * d1;
    }
}

class Negate extends Operator{
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

class Inverse extends UnaryOperation {
    public Inverse(State s) {
        super(s);
    }

    protected Double operate(Double d1) {
        return 1 / d1;
    }
}

class Clear extends Operator {
    public Clear(State s) {
        super(s);
    }

    public void execute() {
        state.emptyStack();
        state.rstState();
    }
}

class ClearError extends Operator {
    public ClearError(State s) {
        super(s);
    }

    public void execute() {
        state.rstState();
    }
}

class MemoryStore extends Operator {
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

class MemoryRecall extends Operator {
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


class Enter extends Operator {
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




