package src;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(char c : s.toCharArray()){
            if(!brackets.isEmpty() && c == ')' && brackets.peek() == '(')
                brackets.pop();
            else if(!brackets.isEmpty() && c == ']' && brackets.peek() == '[')
                brackets.pop();
            else if(!brackets.isEmpty() && c == '}' && brackets.peek() == '{')
                brackets.pop();
            else
                brackets.push(c);
        }
        return brackets.isEmpty();
    }
}
