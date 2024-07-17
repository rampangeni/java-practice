package LeetCode75;

import LeetCode75.DataStructure.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode ll = head;

        ll.insert(head, 1);
        ll.insert(head, 3);
        ll.insert(head, 5);
        ll.insert(head, 6);
        ll.insert(head, 4);
        ll.insert(head, 7);

        ll.printLinkedList(head);

        ListNode result = ll.oddEvenList(head);
        result.printLinkedList(result);
    }
}
