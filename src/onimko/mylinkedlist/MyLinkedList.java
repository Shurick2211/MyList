package onimko.mylinkedlist;

import onimko.MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * This my own LinkedList
 * @param <E> - tip of data.
 */
public class MyLinkedList<E> implements MyList<E>, InterfaceMyLinkedList<E>, Iterable<E>{

  /**The size of collection*/
  private int size;

  /**The first element of collections*/
  private Node<E> first;

  /**The last element of collections*/
  private Node<E> current;

  /**
   * The empty constructor for create MyLinkedList.
   */
  public MyLinkedList() {
    clear();
  }

  /**
   * The constructor for create MyLinkedList with input collection.
   * @param col - the input collection.
   */
  public MyLinkedList(Collection<E> col){
    this.addAll(col);
  }

  /**
   * Method returns number elements of collections.
   * @return int - collection's size
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Method checks if the collection is empty.
   * @return true or false
   */
  @Override
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Method checks if the collection contains an element.
   * @param el - the input element.
   * @return true or false
   */
  @Override
  public boolean contains(E el) {
    for (E e:this) if (e.equals(el)) return true;
    return false;
  }

  /**
   * Method adds an element in the collection.
   * @param item - the input element.
   */
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

  /**
   * Method does the collection empty.
   */
  @Override
  public void clear() {
    first = null;
    current = null;
    size = 0;
  }

  /**
   * Method removes an element in the collection.
   * @param item - the input element.
   */
  @Override
  public void remove(E item) {
    Node<E> node = first;
    while (node != null) {
      if (node.value.equals(item)) {
        if (node.next != null && node.prev != null) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
          size--;
        } else if (node.next == null) {
          removeLast();
        }
        else {
          removeFirst();
        }
      }
      node = node.next;
    }
  }

  /**
   * Method for implements the functional interface Consumer
   * and used method accept() for every element
   * the collections.
   * @param consumer lambda expressions.
   */
  @Override
  public void forEach(Consumer<? super E> consumer) {
    Node<E> node = first;
    while (node != null) {
      consumer.accept(node.value);
      node = node.next;
    }
  }

  /**
   * Method transforms the collection in an array of Object.
   * @return Object[] with collection's elements.
   */
  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    int i = 0;
    for (E el : this) array[i++] = el;
    return array;
  }

  /**
   * Method transforms the collection in the String.
   * @return String - with collection's elements.
   */
  @Override
  public String toString() {
    StringBuilder listString = new StringBuilder("[");
    int i = 0;
    for (E e:this) {
      listString.append(e);
      if (i < size-1) listString.append(", ");
      i++;
    }
    listString.append("]");
    return listString.toString();
  }

  /**
   * Method returns an iterator for the collection.
   * It has to method - hasNext() and next().
   * It needs for opportunities to use for-each.
   * @return E - the iterator for the collection.
   */
  @Override
  public Iterator<E> iterator() {
    return new Iterator<>() {
      Node<E> node = first;

      /**
       * Method checks if the collection has next element.
       * @return if it has - true, else - false
       */
      @Override
      public boolean hasNext() {
        return node != null;
      }

      /**
       * Method return next element of the collection
       * @return E - element.
       */
      @Override
      public E next() {
        E value = node.value;
        node = node.next;
        return value;
      }
    };
  }

  /**
   * Method adds first element in the collection.
   * @param el - the E - element
   */
  @Override
  public void addFirst(E el) {
    first.prev = new Node<>(el);
    first.prev.next = first;
    first = first.prev;
  }

  /**
   * Method adds last element in the collection.
   * @param el - the E - element
   */
  @Override
  public void addLast(E el) {
    add(el);
  }

  /**
   * Method removes first element of the collection, and returns it.
   * @return E - element.
   */
  @Override
  public E removeFirst() {
    E value = first.value;
    first = first.next;
    first.prev = null;
    size--;
    return value;
  }

  /**
   * Method removes last element of the collection, and returns it.
   * @return E - element.
   */
  @Override
  public E removeLast() {
    E value = current.value;
    if (current.prev != null) {
      current = current.prev;
      current.next = null;
      size--;
    } else clear();
    return value;
  }

  /**
   * Method returns first element of the collection.
   * @return E - element.
   */
  @Override
  public E getFirst() {
    return first.value;
  }

  /**
   * Method returns last element of the collection.
   * @return E - element.
   */
  @Override
  public E getLast() {
    return current.value;
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
