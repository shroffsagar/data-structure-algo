package src;

//https://leetcode.com/problems/reverse-linked-list/
public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode nextN = head.next;
            head.next = prev;
            prev = head;
            head = nextN;
        }
        return prev;
    }
}
