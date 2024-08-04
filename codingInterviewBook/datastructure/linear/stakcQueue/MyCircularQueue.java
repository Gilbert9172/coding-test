package datastructure.linear.stakcQueue;

/**
 * 622. Design Circular Queue
 */
public class MyCircularQueue {
    int[] q;
    int front = 0;
    int rear = -1;
    int len = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
    }

    public boolean isFull() {
        return len == q.length;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % q.length;
            q[rear] = value;
            len++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            // int temp = q[front]
            front = (front + 1) % q.length;
            len--;
            return true;
        } else {
            return  false;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[rear];
    }
}
