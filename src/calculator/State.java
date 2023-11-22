package calculator;

import util.Stack;

public class State {

    private Stack<Double> stack = new Stack<>();

    public State(){

    }

    public void update(){

    }

    public void addValue(double val){
        stack.push(val);
    }

    public double getValue(){
        return stack.pop();
    }

    public String[] getStackInString(){
        Double[] values = stack.getValues();
        String[] s = new String[values.length];
        for(int i = 0; i < values.length; ++i){
            s[i] = values[i].toString();
        }
        return s;
    }
}
