package LeetCode75;

import LeetCode75.DataStructure.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ll = head;

        ll.insert(head, 2);
        ll.insert(head, 3);
        ll.insert(head, 4);
        ll.insert(head, 5);

        ll.printLinkedList(head);

        Boolean result = ll.isPalindrome(head);
        System.out.println(result);
    }
}
