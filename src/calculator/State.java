package calculator;

import util.Iterator;
import util.Stack;

public class State {

    private Stack<Double> stack = new Stack<>();
    private Double memory = 0.;
    
    private String currentVal = "";
    private boolean isError = false;

    public State(){

    }
    
    public void setError() {isError = true;}
    public void rstError() {isError = false;}
    public boolean noError() {return !isError;}

    public void addValue(Double val){
        stack.push(val);
    }

    public Double getValue(){ 
        return stack.pop();
    }
    
    public void appendToCurrent(String s1) {
        if (currentVal == null || currentVal.equals("0")) {
            currentVal = s1;
        } else if(s1.equals(".")) {
            if (!currentVal.contains(".")) {
                currentVal += s1;
            }
        }
        else {
            currentVal += s1;
        }
    }

    public void removeACharFromCurrent(){ currentVal = currentVal.substring(0, currentVal.length() - 1);}
    public Double getCurrent(){return Double.parseDouble(currentVal);}
    public void rstCurrent(){currentVal = "0";}
    public void pushCurrent(){
        stack.push(Double.parseDouble(currentVal));
        rstCurrent();
    }

    public void storeInMemory(){
        memory = stack.pop();
    }

    public void getMemory(){
        stack.pop();
        stack.push(memory);
    }


    public String[] getStackInString(){
        String[] stringStack = new String[stack.Size()];
        Iterator i = stack.getIterator();
        int counter = stack.Size();

        while(i.hasNext()){
            stringStack[--counter] = i.next().toString();
        }

        return stringStack;
    }
}
