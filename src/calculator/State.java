package calculator;

import util.Stack;

public class State {

    private Stack<String> stack = new Stack<>();
    private String memory = "";

    public State(){

    }

    public void update(){

    }

    public void addValue(String val){
        stack.push(val);
    }

    public String getValue(){ 
        return stack.pop();
    }

    public void storeInMemory(){
        memory = stack.pop();
    }

    public void getMemory(){
        stack.push(memory);
    }

    public String[] getStackInString(){
        return stack.getValues();
    }
}
