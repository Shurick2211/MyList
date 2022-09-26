package onimko.myarraylist;

import onimko.MyList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * This my own ArrayList
 * @param <E> - tip of data.
 */
public class MyArrayList<E> implements MyList<E>, InterfaceMyArrayList<E>, Iterable<E>{

  /**The size of collection*/
  private int size;

  /**The start size of entry array*/
  private final static int startSize = 10;

  /**The entry array*/
  private E[] array;

  /**
   * The empty constructor for create MyArrayList.
   */
  public MyArrayList() {
    clear();
  }

  /**
   * The constructor for create MyArrayList
   * with ability adds a given number of elements
   * without expanding the collection.
   * @param capacity - the number of elements.
   */
  public MyArrayList(int capacity) {
    this.array = (E[]) new Object[capacity];
    this.size = 0;
  }

  /**
   * The constructor for create MyArrayList with input collection.
   * @param collection - the input collection.
   */
  public MyArrayList(Collection<? extends E> collection) {
    this(collection.size() + startSize);
    addAll(collection);
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
    return size == 0;
  }

  /**
   * Method checks if the collection contains an element.
   * @param el - the input element.
   * @return true or false
   */
  @Override
  public boolean contains(E el) {
    for (E item:this) if (el.equals(item)) return true;
    return false;
  }

  /**
   * Method adds an element in the collection.
   * @param item - the input element.
   */
  @Override
  public void add(E item) {
    if (array.length == size) {
      E[] bigger = (E[]) new Object[array.length<<1];
      System.arraycopy(array,0,bigger,0, array.length);
      array = bigger;
    }
    array[size++] =  item;
  }

  /**
   * Method does the collection empty.
   */
  @Override
  public void clear() {
    array = (E[]) new Object[startSize];
    size = 0;
  }

  /**
   * Method removes an element in the collection.
   * @param item - the input element.
   */
  @Override
  public void remove(E item) {
    int index;
    while ((index = indexOf(item)) > -1) {
      remove(index);
    }
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
      int i = 0;

      /**
       * Method checks if the collection has next element.
       * @return if it has - true, else - false
       */
      @Override
      public boolean hasNext() {
        return i < size;
      }

      /**
       * Method return next element of the collection
       * @return E - element.
       */
      @Override
      public E next() {
        return array[i++];
      }
    };
  }

  /**
   * Method for implements the functional interface Consumer
   * and used method accept() for every element
   * the collections.
   * @param consumer lambda expressions.
   */
  @Override
  public void forEach(Consumer<? super E> consumer) {
    for (int i = 0; i < size; i++) consumer.accept(array[i]);
  }

  /**
   * Method transforms the collection in an array of Object.
   * @return Object[] with collection's elements.
   */
  @Override
  public Object[] toArray() {
    Object[] arrayForReturn =  new Object[size];
    System.arraycopy(array,0,arrayForReturn,0, size);
    return arrayForReturn;
  }

  /**
   * Method returns the element has a given index.
   * @param index of the element.
   * @return E - element has a given index.
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    return array[index];
  }

  /**
   * Method sets the element in the index.
   * @param index of the element.
   * @param element E - element.
   */
  @Override
  public void set(int index, E element) {
     if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
     array[index] = element;
  }

  /**
   * Method removes the element has a given index.
   * @param index of the element.
   */
  @Override
  public void remove(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    size--;
    if (size > index) System.arraycopy(array, index + 1, array, index, size - index);
  }

  /**
   * Method finds index of the element in the collection.
   * If element not founds - returns -1.
   * @param obj  the E - element.
   * @return int - the index element of the collection.
   */
  @Override
  public int indexOf(E obj) {
    for (int i = 0; i < size; i++) if (obj.equals(array[i])) return i;
    return -1;
  }

  /**
   * Method finds last index of the element in the collection.
   * If element not founds - returns -1.
   * @param obj  the E - element.
   * @return int - the index element of the collection.
   */
  @Override
  public int lastIndexOf(E obj) {
    for (int i = size - 1; i >= 0 ; i--) if (obj.equals(array[i])) return i;
    return -1;
  }

  /**
   * Method transforms the collection in the String.
   * @return String - with collection's elements.
   */
  @Override
  public String toString() {
    StringBuilder arrayString = new StringBuilder("[");
    for(int i = 0; i < size; i++) {
      arrayString.append(array[i]);
      if (i < size-1) arrayString.append(", ");
    }
    arrayString.append("]");
    return arrayString.toString();
  }
}