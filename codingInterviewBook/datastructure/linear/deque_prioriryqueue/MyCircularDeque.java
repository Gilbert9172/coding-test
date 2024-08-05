package datastructure.linear.deque_prioriryqueue;

public class MyCircularDeque {

    public static class ListNode {
        ListNode next;
        ListNode prev;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int currentSize;
    int size;
    ListNode head;
    ListNode tail;


    public MyCircularDeque(int k) {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
        this.size = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(value);
        currentSize++;
        if(isEmpty()){
            head=tail=newNode;
            return true;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ListNode newNode = new ListNode(value);
        currentSize++;
        if (isEmpty()) {
            head=tail=newNode;
            return true;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        currentSize--;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        head = head.next;
        head.prev = null;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        currentSize--;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        tail = tail.prev;
        tail.next = null;
        return true;
    }

    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public boolean isFull() {
        return currentSize == size;
    }
}
