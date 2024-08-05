package datastructure.linear.deque_prioriryqueue;

public class MyCircularDequeV2 {
    int front = -1;
    int rear = -1;
    int size;
    int[] cq;

    public MyCircularDequeV2(int k) {
        this.size = k;
        this.cq = new int[k];
    }

    public boolean insertFront(int value) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            cq[front] = value;
        } else if (front == 0) {
            front = size - 1;
            cq[front] = value;
        } else {
            front--;
            cq[front] = value;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            cq[rear] = value;
        } else if (rear == size - 1) {
            rear = 0;
            cq[rear] = value;
        } else {
            rear++;
            cq[rear] = value;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (rear == front) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front ++;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return cq[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return cq[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == (rear + 1) % size;
    }
}
