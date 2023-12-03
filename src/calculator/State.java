package calculator;

import util.Iterator;
import util.Stack;

public class State {
    private final String ERROR = "# error #";
    private final String DEFAULTVAL = "0";

    private Stack<Double> stack = new Stack<>();
    private Double memory = 0.;
    
    private String currentVal = "";
    private boolean isError = false;
    private boolean userInput = true;

    public State(){
        currentVal = DEFAULTVAL;
    }
    
    public void setError() {
        isError = true;
        currentVal = ERROR;
    }
    public void rstError() {
        isError = false;
        currentVal = DEFAULTVAL;
    }
    public boolean noError() {
        return !isError;
    }

    public boolean isUserInput(){
        return userInput;
    }

    public void setUserInput(boolean bool){
        userInput = bool;
    }

    public void addValue(Double val){
        stack.push(val);
    }

    public Double getValue(){ 
        return stack.pop();
    }
    
    public void appendToCurrent(String s1) {
        if (currentVal == null || currentVal.equals(DEFAULTVAL)) {
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
    public Double getCurrent(){
        if(currentVal.equals(ERROR)){
            return null;
        }
        else{
            return Double.parseDouble(currentVal);
        }
    }
    public String getCurrentInString(){return currentVal;}
    public void setCurrent(Double val){currentVal = val.toString();}
    public void rstCurrent(){currentVal = "0";}
    public void pushCurrent(){
        stack.push(Double.parseDouble(currentVal));
        rstCurrent();
    }
    public void negateCurrent(){
        if(currentVal.contains("-")){
            currentVal = currentVal.substring(1, currentVal.length());
        }
        else{
            currentVal = "-" + currentVal;
        }
    }

    public void storeInMemory(){
        memory = getCurrent();
        rstCurrent();
    }

    public void getMemory(){
        setCurrent(memory);
    }


    public String[] getStackInString(){
        if(stack.size() == 0){
            return null;
        }

        String[] stringStack = new String[stack.size()];
        Iterator<Double> i = stack.getIterator();
        int counter = stack.size();

        while(i.hasNext()){
            stringStack[--counter] = i.next().toString();
        }

        return stringStack;
    }

    public void rstState(){
        rstError();
        rstCurrent();
        setUserInput(true);
    }

    public void emptyStack(){
        stack.emptyStack();
    }
}
