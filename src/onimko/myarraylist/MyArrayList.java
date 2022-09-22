package onimko.myarraylist;

import onimko.MyList;

import java.util.Collection;

public class MyArrayList<E> implements MyList{
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

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object el) {
    return false;
  }

  @Override
  public void add(Object item) {
    if (array.length == size) {
      E[] bigger = (E[]) new Object[array.length<<1];
      System.arraycopy(array,0,bigger,0, array.length);
      array = bigger;
    }
    array[size++] = (E) item;
  }

  @Override
  public void addAll(Collection collection) {
    collection.forEach(el -> add(el));
  }

  @Override
  public void clear() {
    array = (E[]) new Object[startSize];
    size = 0;
  }

  @Override
  public void remove(Object item) {

  }

  @Override
  public void removeAll(Collection c) {

  }

  public E[] toArray() {
    E[] arrayForReturn = (E[]) new Object[size];
    System.arraycopy(array,0,arrayForReturn,0, size);
    return arrayForReturn;
  }

  public E get(int index) {
    return array[index];
  }


  public Object set(int index, Object element) {
    return array[index] = (E) element;
  }

  public Object remove(int index) {
    return null;
  }


  public int indexOf(Object o) {
    return 0;
  }


  public int lastIndexOf(Object o) {
    return 0;
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
