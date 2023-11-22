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

}
