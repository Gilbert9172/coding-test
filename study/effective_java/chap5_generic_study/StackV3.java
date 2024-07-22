package effective_java.chap5_generic_study;

import java.util.*;

/* Can cause heap pollution */
public class StackV3<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackV3() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null; // Eliminate obsolete reference return result;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public void pushAll(List<? extends E> list) {
        for (E e : list) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> list) {
        while (!isEmpty()) {
            list.add(pop());
        }
    }

    public static void main(String[] args) {
        StackV3<Number> numberStack = new StackV3<>();
        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4));
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);
    }
}