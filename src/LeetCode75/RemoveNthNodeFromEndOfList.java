package LeetCode75;

import LeetCode75.DataStructure.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ll = head;

        ll.insert(head, 2);
        ll.insert(head, 3);
        ll.insert(head, 4);
        ll.insert(head, 5);

        ll.printLinkedList(head);

        ListNode result = ll.removeNthFromEnd(head, 2);
        System.out.println(" ");
        ll.printLinkedList(result);
    }
}
