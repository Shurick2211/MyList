package onimko.stackandqueue;

import onimko.mylinkedlist.MyLinkedList;

/**
 * This my own Queue
 * @param <E> - tip of data.
 */
public class MyQueue<E> implements InterfaceMyQueue<E>{
    private final MyLinkedList<E> queue = new MyLinkedList<>();

    @Override
    public void offer(E item) {
        queue.add(item);
    }

    @Override
    public E pop() {
        return queue.removeFirst();
    }

    @Override
    public E peek() {
        return queue.getFirst();
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(E item) {
        return queue.contains(item);
    }
}
