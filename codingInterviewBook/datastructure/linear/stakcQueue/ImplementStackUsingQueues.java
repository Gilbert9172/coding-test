package datastructure.linear.stakcQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 */
public class ImplementStackUsingQueues {

    public static class MyStack {
        Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.size() == 0;
        }

        public Queue<Integer> getQueue() {
            return this.queue;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(11);
        Queue<Integer> queue = myStack.getQueue();
        int pop = myStack.pop();
        System.out.println(queue);
    }
}
