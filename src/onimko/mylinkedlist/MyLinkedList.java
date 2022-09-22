package onimko.mylinkedlist;

import onimko.MyList;

import java.util.LinkedList;

/**
 * This my own LinkedList
 * @param <E> - tip of data.
 */
public class MyLinkedList<E extends Object> implements MyList {
  private int size = 0;
  private Node<E> first;
  private Node<E> current;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public boolean contains(Object el) {
    return false;
  }

  @Override
  public void add(Object item) {
    if (first == null) first = new Node<>((E) item);
    else if (current == null) {
      first.next = new Node<>((E) item);
      current = first.next;
      current.prev = first;
    } else {
      current.next = new Node<>((E) item);
      Node<E> old = current;
      current = current.next;
      current.prev = old;
    }
    size++;
  }

  @Override
  public void clear() {
    first = null;
    current = null;
    size = 0;
  }

  @Override
  public void remove(Object item) {

  }

  /**
   * The node for the MyLinkedList
   * @param <E> - the tip of data.
   */
  private class Node<E> {
    Node<E> prev;
    Node<E> next;
    E value;

    public Node(E value) {
      this.value = value;
    }

  }
}
