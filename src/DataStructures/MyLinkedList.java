package DataStructures;

public class MyLinkedList {
    private int data;
    private MyLinkedList next;

    MyLinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public MyLinkedList getNext() {
        return this.next;
    }

    public void setNext(MyLinkedList node) {
        this.next = node;
    }
}

