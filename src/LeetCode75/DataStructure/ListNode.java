package LeetCode75.DataStructure;

/* Java program to implement a Singly Linked List */

import java.util.Stack;

public class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode insert(ListNode head, int data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = node;
        } else {
            ListNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }

        return head;
    }

    public int lengthOf(ListNode head) {
        int size = 0;
        ListNode traverse = head;
        while (traverse != null) {
            size++;
            traverse = traverse.next;
        }

        return size;
    }

    public void printLinkedList(ListNode head) {

        if (head == null) {
            System.out.print("null");
            return;
        }

        ListNode traverse = head;
        while (traverse != null) {
            if (traverse.next == null) {
                System.out.print(traverse.val + " => null");
            } else {
                System.out.print(traverse.val + " => ");
            }
            traverse = traverse.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list = head;
        if (head == null) {
            return null;
        }

        int length = lengthOf(head);

        if (length < n) {
            return list;
        }

        if (length == n) {
            head = head.next;
            return head;
        }

        ListNode last = head;
        ListNode current = head;
        for (int i = 0; i < n; i++) {
            last = last.next;
        }

        while (last.next != null) {
            last = last.next;
            current = current.next;
        }

        current.next = current.next.next;

        return list;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode traverse = head;
        int length = lengthOf(head);
        Stack<Integer> stack = new Stack<Integer>();
        while (traverse != null) {
            int data = traverse.val;
            stack.push(data);
            traverse = traverse.next;
        }

        traverse = head;
        while (!stack.empty()) {
            int data = stack.pop();
            if (data != traverse.val) {
                return false;
            }
            traverse = traverse.next;
        }

        return true;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode result = head;

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode headOdd = result;
        ListNode headEven = result.next;

        ListNode oddTraverse = headOdd;
        ListNode evenTraverse = headEven;

        ListNode current = evenTraverse.next;
        int count = 3;
        while (current != null) {
            if (count % 2 == 0) {
                evenTraverse.next = current;
                evenTraverse = current;
            } else {
                oddTraverse.next = current;
                oddTraverse = current;
            }
            current = current.next;
            count++;
        }

        oddTraverse.next = headEven;
        evenTraverse.next = null;
        return result;
    }
}
