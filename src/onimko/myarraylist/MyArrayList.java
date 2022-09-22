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
    for (Object item:array) if (el.equals(item)) return true;
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
    remove(indexOf((E) item));
  }

  @Override
  public void removeAll(Collection collection) {
    collection.forEach(el -> remove(el));
  }

  public Object[] toArray() {
    Object[] arrayForReturn =  new Object[size];
    System.arraycopy(array,0,arrayForReturn,0, size);
    return arrayForReturn;
  }

  public E get(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    return array[index];
  }


  public void set(int index, E element) {
     if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
     array[index] = element;
  }

  public void remove(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    size--;
    for (int i = index; i < size; i++) array[i] = array[i+1];
  }


  public int indexOf(E obj) {
    for (int i = 0; i < size; i++) if (obj.equals(array[i])) return i;
    return -1;
  }


  public int lastIndexOf(E obj) {
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