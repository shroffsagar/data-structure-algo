package src;

import java.util.EmptyStackException;

public class MaxStack {

    StackNode head;

    void push(int i){
        if(isEmpty()){
            head = new StackNode(i, i, null);
        }
        else {
            int maxVal = i > head.max ? i : head.max;
            head.next = new StackNode(i, maxVal, head);
            head = head.next;
        }
    }

    boolean isEmpty(){
        return head == null;
    }

    int pop(){
        if(isEmpty()) throw new EmptyStackException();
        int popedValue;
        if(head.prev != null){
            StackNode prev = head.prev;
            prev.next = null;
            head.prev = null;
            popedValue = head.val;
            head = prev;
        }
        else {
            popedValue = head.val;
            head = null;
        }
        return popedValue;
    }

    int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return head.val;
    }

    int getMax(){
        if(isEmpty()) throw new EmptyStackException();
        return head.max;
    }

    //Tests
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        //empty pop,peek,getmax should fail
        try { stack.pop(); throw new RuntimeException("Empty pop should fail"); }catch (EmptyStackException e ){}
        try { stack.peek(); throw new RuntimeException("Empty peek should fail"); }catch (EmptyStackException e ){}
        try { stack.getMax(); throw new RuntimeException("Empty getMax should fail"); }catch (EmptyStackException e ){}

        //pushing/poping multiple elements to stack
        stack.push(10);
        if(stack.peek() != 10) throw new RuntimeException("Expected 10");
        if(stack.getMax() != 10) throw new RuntimeException("Expected 10");
        stack.push(1);
        if(stack.peek() != 1) throw new RuntimeException("Expected 1");
        if(stack.getMax() != 10) throw new RuntimeException("Expected 10");
        stack.push(10);
        if(stack.peek() != 10) throw new RuntimeException("Expected 10");
        if(stack.getMax() != 10) throw new RuntimeException("Expected 10");
        if(stack.pop() != 10) throw new RuntimeException("Expected 10");
        if(stack.peek() != 1) throw new RuntimeException("Expected 1");
        if(stack.getMax() != 10) throw new RuntimeException("Expected 10");
        if(stack.pop() != 1) throw new RuntimeException("Expected 1");
        if(stack.peek() != 10) throw new RuntimeException("Expected 10");
        if(stack.getMax() != 10) throw new RuntimeException("Expected 10");
        if(stack.pop() != 10) throw new RuntimeException("Expected 10");
        try { stack.pop(); throw new RuntimeException("Empty pop should fail"); }catch (EmptyStackException e ){}
        stack.push(20);
        stack.push(1);
        if(stack.peek() != 1) throw new RuntimeException("Expected 1");
        if(stack.getMax() != 20) throw new RuntimeException("Expected 20");
        if(stack.pop() != 1) throw new RuntimeException("Expected 1");
        if(stack.getMax() != 20) throw new RuntimeException("Expected 20");
        if(stack.pop() != 20) throw new RuntimeException("Expected 20");
        try { stack.getMax(); throw new RuntimeException("Empty getMax should fail"); }catch (EmptyStackException e ){}
    }

}
class StackNode {
    Integer val, max;
    StackNode next, prev;
    StackNode(Integer v, Integer m, StackNode prev){
        this.val = v;
        this.max = m;
        this.prev = prev;
    }
}
