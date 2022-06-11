package src;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t: tokens){
            if(! "+-*/".contains(t)){
                stack.push(Integer.valueOf(t));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                if(t.equals("+"))
                    stack.push(a + b);
                else if(t.equals("-"))
                    stack.push(a - b);
                else if(t.equals("*"))
                    stack.push(a * b);
                else if(t.equals("/"))
                    stack.push(a / b);
                else throw new RuntimeException("Unsupported operator: "+t);
            }
        }
        return stack.pop();
    }

}
