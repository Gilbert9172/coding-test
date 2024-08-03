package datastructure.linear.stakcQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. Implement Queue using Stacks
 */
public class ImplementQueueUsingStacks {

    // O(1)
    public static class MyQueueV2 {
        Deque<Integer> inputStack = new ArrayDeque<>();
        Deque<Integer> outputStack = new ArrayDeque<>();

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.pop();
        }

        public int peek() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }

    // O(n)
    public static class MyQueueMySolve {

        Deque<Integer> originalStack = new ArrayDeque<>();
        Deque<Integer> reversedStack = new ArrayDeque<>();

        public void push(int x) {
            originalStack.push(x);
            int size = originalStack.size();
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = originalStack.pop();
            }
            reversedStack.clear();
            for (int i = 0; i < temp.length; i++) {
                reversedStack.push(temp[i]);
                originalStack.push(temp[temp.length -1 - i]);
            }
        }

        public int pop() {
            Integer pop = reversedStack.remove();
            int[] temp = new int[reversedStack.size()];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = reversedStack.pop();
            }
            originalStack.clear();
            for (int i = 0; i < temp.length; i++) {
                originalStack.push(temp[i]);
                reversedStack.push(temp[temp.length -1 - i]);
            }
            return pop;
        }

        public int peek() {
            return reversedStack.peek();
        }
        public boolean empty() {
            return reversedStack.size() == 0;
        }
    }
}
