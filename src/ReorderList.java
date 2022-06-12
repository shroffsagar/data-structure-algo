package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/reorder-list/submissions/
public class ReorderList {
    public int[] reorderList(int [] array) {
        if(array.length == 0) return new int[]{};
        ListNode head = createList(array);
        List<ListNode> nodes = new ArrayList<>();
        ListNode pointer = head;
        while(pointer.next != null){
            nodes.add(pointer);
            pointer = pointer.next;
        }
        nodes.add(pointer);

        pointer = head;
        int i = 0; int n = nodes.size()-1;
        while(pointer.next != null && pointer.next.next != null){
            ListNode nNode = nodes.get(n-i);
            ListNode temp = pointer.next;
            pointer.next = nNode;
            nNode.next = temp;
            ListNode nminusOneNode = nodes.get(n-i-1);
            nminusOneNode.next = null;
            i+=1;
            pointer = nodes.get(i);
        }
        return getValues(head);
    }

    private int[] getValues(ListNode node) {
        List<Integer> values = new ArrayList<>();
        while(node.next != null){
            values.add(node.val);
            node = node.next;
        }
        values.add(node.val);
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    ListNode createList(int [] n){
        if(n.length == 0) return new ListNode();
        ListNode head = new ListNode(n[0]);
        ListNode pointer = head;
        for(int i=1; i<n.length; i++){
            ListNode next = new ListNode(n[i]);
            pointer.next=next;
            pointer = pointer.next;
        }
        return head;
    }

    //Tests
    public static void main(String[] args) {
        ReorderList r = new ReorderList();
        int [] test = new int [] {1,2,3,4};
        if(!Arrays.equals(r.reorderList(test), new int[] {1,4,2,3})) throw new RuntimeException("mismatch");
        test = new int [] {1,2,3,4,5};
        if(!Arrays.equals(r.reorderList(test), new int[] {1,5,2,4,3})) throw new RuntimeException("mismatch");
        test = new int [] {1,2,3};
        if(!Arrays.equals(r.reorderList(test), new int[] {1,3,2})) throw new RuntimeException("mismatch");
        test = new int [] {1,2};
        if(!Arrays.equals(r.reorderList(test), new int[] {1,2})) throw new RuntimeException("mismatch");
        test = new int [] {1};
        if(!Arrays.equals(r.reorderList(test), new int[] {1})) throw new RuntimeException("mismatch");
        test = new int [] {};
        if(!Arrays.equals(r.reorderList(test), new int[] {})) throw new RuntimeException("mismatch");
    }
}
