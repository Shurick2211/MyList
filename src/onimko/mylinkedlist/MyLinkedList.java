package onimko.mylinkedlist;

import onimko.MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * This my own LinkedList
 * @param <E> - tip of data.
 */
public class MyLinkedList<E> implements MyList<E>, InterfaceMyLinkedList<E>, Iterable<E>{
  private int size;
  private Node<E> first;
  private Node<E> current;

  public MyLinkedList() {
    clear();
  }

  public MyLinkedList(Collection<E> col){
    this.addAll(col);
  }

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
    for (E e:this) if (e.equals(el)) return true;
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
  public void remove(E item) {
    Node<E> node = first;
    while (node != null) {
      if (node.value.equals(item)) {
        if (node.next != null && node.prev != null) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
        } else if (node.next == null) {
          removeLast();
        }
        else {
          removeFirst();
        }
        size--;
      }
      node = node.next;
    }
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
        return node != null;
      }

      @Override
      public E next() {
        E value = node.value;
        node = node.next;
        return value;
      }
    };
  }

  @Override
  public void addFirst(E el) {
    first.prev = new Node<>(el);
    first.prev.next = first;
    first = first.prev;
  }

  @Override
  public void addLast(E el) {
    add(el);
  }

  @Override
  public E removeFirst() {
    E value = first.value;
    first = first.next;
    first.prev = null;
    return value;
  }

  @Override
  public E removeLast() {
    E value = current.value;
    current = current.prev;
    current.next = null;
    return value;
  }

  @Override
  public E getFirst() {
    return first.value;
  }

  @Override
  public E getLast() {
    return current.value;
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
