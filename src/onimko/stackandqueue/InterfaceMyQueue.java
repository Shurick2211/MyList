package onimko.stackandqueue;

/**
 * The interface for my own MyQueue
 * @param <E> - tip of data.
 */
public interface InterfaceMyQueue<E> {
    void offer(E item);
    E pop();
    E peek();
    boolean empty();
    boolean contains(E item);
}
