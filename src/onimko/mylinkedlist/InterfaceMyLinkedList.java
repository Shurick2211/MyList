package onimko.mylinkedlist;

/**
 * The interface for my own LinkedList
 * @param <E> - tip of data.
 */
public interface InterfaceMyLinkedList<E> {
  void addFirst(E el);
  void addLast(E el);
  E removeFirst();
  E removeLast();
  E getFirst();
  E getLast();
}
