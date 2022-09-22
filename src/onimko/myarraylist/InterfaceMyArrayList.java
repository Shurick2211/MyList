package onimko.myarraylist;

/**
 * The interface for my own ArrayList
 * @param <E> - tip of data.
 */
public interface InterfaceMyArrayList<E> {
  Object[] toArray();
  E get(int index);
  void set(int index, E element);
  void remove(int index);
  int indexOf(Object obj);
  int lastIndexOf(E obj);

}
