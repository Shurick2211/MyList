package onimko.stackandqueue;

/**
 * The interface for my own Stack
 * @param <E> - tip of data.
 */
public interface InterfaceMyStack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean empty();
    boolean contains(E item);
}
