package stack;

import java.util.Stack;
import java.util.EmptyStackException;

public class PlaceholderStack<T> implements stack.Stack<T> {
    private java.util.Stack<T> stack = new java.util.Stack<T>();

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(T elm) {
        stack.push(elm);
    }

    @Override
    public T pop() throws EmptyStackException {
        return stack.pop();
    }
}
