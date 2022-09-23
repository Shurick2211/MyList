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
  private int size;
  private final static int startSize = 10;
  private E[] array;

  public MyArrayList() {
    clear();
  }

  public MyArrayList(int capacity) {
    this.array = (E[]) new Object[capacity];
    this.size = 0;
  }

  public MyArrayList(Collection<E> collection) {
    this(collection.size() + startSize);
    addAll(collection);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(E el) {
    for (Object item:array) if (el.equals(item)) return true;
    return false;
  }

  @Override
  public void add(E item) {
    if (array.length == size) {
      E[] bigger = (E[]) new Object[array.length<<1];
      System.arraycopy(array,0,bigger,0, array.length);
      array = bigger;
    }
    array[size++] =  item;
  }

  @Override
  public void clear() {
    array = (E[]) new Object[startSize];
    size = 0;
  }

  @Override
  public void remove(Object item) {
    int index;
    while ((index = indexOf(item)) > -1) remove(index);
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<>() {
      int i = 0;
      @Override
      public boolean hasNext() {
        return i < size;
      }

      @Override
      public E next() {
        return array[i++];
      }
    };
  }

  @Override
  public void forEach(Consumer<? super E> consumer) {
    for (int i = 0; i < size; i++) consumer.accept(array[i]);
  }

  @Override
  public Object[] toArray() {
    Object[] arrayForReturn =  new Object[size];
    System.arraycopy(array,0,arrayForReturn,0, size);
    return arrayForReturn;
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    return array[index];
  }

  @Override
  public void set(int index, E element) {
     if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
     array[index] = element;
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    size--;
    System.arraycopy(array, index + 1, array, index, size - index);
  }

  @Override
  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) if (obj.equals(array[i])) return i;
    return -1;
  }

  @Override
  public int lastIndexOf(Object obj) {
    for (int i = size - 1; i >= 0 ; i--) if (obj.equals(array[i])) return i;
    return -1;
  }

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
