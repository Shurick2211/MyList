package onimko.stackandqueue;

import onimko.myarraylist.MyArrayList;

/**
 * This my own Stack
 * @param <E> - tip of data.
 */
public class MyStack<E> implements InterfaceMyStack<E>{

    private final MyArrayList<E> stack = new MyArrayList<>(5000);

    @Override
    public void push(E item) {
        stack.add(item);
    }

    @Override
    public E pop() {
        E obj = stack.get(stack.size() - 1);
        stack.remove(obj);
        return obj;
    }

    @Override
    public E peek() {
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public boolean contains(E item) {
        return stack.contains(item);
    }
}
