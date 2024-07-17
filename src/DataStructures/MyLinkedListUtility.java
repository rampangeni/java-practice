package DataStructures;

public class MyLinkedListUtility {
    private MyLinkedList head = null;
    private MyLinkedList tail = null;

    MyLinkedListUtility() {
        head = null;
        tail = null;
    }

    public void addTail(int data) {
        MyLinkedList temp = new MyLinkedList(data);
        if (this.head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }

        if (head.getData() == data) {
            head = head.getNext();
            if (tail.getData() == data) {
                tail = head;
            }
            return;
        }

        MyLinkedList current = head;
        while(current.getNext() != null) {
            if (current.getNext().getData() == data) {
                if (current.getNext().getNext() != null) {
                    current.setNext(current.getNext().getNext());
                } else {
                    current.setNext(null);
                }
            }
            current = current.getNext();
        }
    }

    public int findMiddle() {
        MyLinkedList slow = head;
        MyLinkedList fast = head;
        while(fast.getNext() != null) {
            if (fast.getNext().getNext() != null) {
                fast = fast.getNext().getNext();
            } else {
                fast = fast.getNext();
            }
            slow = slow.getNext();
        }
        return slow.getData();
    }

    public void printLinkedList() {
        System.out.println(" HEAD ");
        MyLinkedList current = head;
        while(current != null) {
            System.out.println(" -> " + current.getData());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        MyLinkedListUtility myLinkedListUtility = new MyLinkedListUtility();
        myLinkedListUtility.addTail(1);
        myLinkedListUtility.addTail(2);
        myLinkedListUtility.addTail(3);
        myLinkedListUtility.printLinkedList();
        myLinkedListUtility.remove(1);
        myLinkedListUtility.printLinkedList();
        myLinkedListUtility.addTail(4);
        myLinkedListUtility.addTail(5);
        myLinkedListUtility.addTail(6);
        myLinkedListUtility.printLinkedList();
        System.out.println("Middle Elements: " + myLinkedListUtility.findMiddle());
    }
}
