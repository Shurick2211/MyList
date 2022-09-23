package onimko.mylinkedlist;

import onimko.MyList;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * This my own LinkedList
 * @param <E> - tip of data.
 */
public class MyLinkedList<E> implements MyList<E>, Iterable<E>{
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
  public boolean contains(E el) {
    return false;
  }

  @Override
  public void add(E item) {
    if (first == null) first = new Node<>(item);
    else if (current == null) {
      first.next = new Node<>(item);
      current = first.next;
      current.prev = first;
    } else {
      current.next = new Node<>(item);
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

  @Override
  public void forEach(Consumer<? super E> consumer) {
    Node<E> node = first;
    while (node != null) {
      consumer.accept(node.value);
      node = node.next;
    }
  }

  @Override
  public String toString() {
    StringBuilder listString = new StringBuilder("[");
    AtomicInteger i = new AtomicInteger();
    forEach(e -> {
      listString.append(e);
      if (i.get() < size-1) listString.append(", ");
      i.getAndIncrement();
    });
    listString.append("]");
    return listString.toString();
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<>() {
      Node<E> node = first;

      @Override
      public boolean hasNext() {
        return node.next != null;
      }

      @Override
      public E next() {
        E value = node.value;
        node = node.next;
        return value;
      }
    };
  }

  /**
   * The node for the MyLinkedList
   * @param <E> - the tip of data.
   */
  private static class Node<E> {
    Node<E> prev;
    Node<E> next;
    E value;

    public Node(E value) {
      this.value = value;
    }
  }
}
