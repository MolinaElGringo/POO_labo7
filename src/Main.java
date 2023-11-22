import calculator.JCalculator;
import util.*;


public class Main
{
  public static void main(String ... args) {
    //new JCalculator();
    Stack<Integer> stk = new Stack<>();
    stk.push(1);
    stk.push(2);
    stk.push(3);
    System.out.println(stk);
    stk.pop();
    System.out.println(stk);
  }
}
