package src;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<Node>();
    }

    public void push(int val) {
        int min;
        if(stack.isEmpty()) min = val;
        else {
            Node n = stack.peek();
            min = n.min < val ? n.min : val;
        }
        stack.add(new Node(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

class Node {
    int val, min;
    public Node (int val, int min){
        this.val = val;
        this.min = min;
    }
}