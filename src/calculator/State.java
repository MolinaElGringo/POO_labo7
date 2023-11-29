package calculator;

import util.Stack;

public class State {

    private Stack<Double> stack = new Stack<>();
    private Double memory = 0.;

    public State(){

    }

    public void update(){

    }

    public void addValue(double val){
        stack.push(val);
    }

    public Double getValue(){
        
        return stack.pop();
    }

    public void storeInMemory(){
        memory = stack.pop();
    }

    public void getMemory(){
        stack.push(memory);
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
