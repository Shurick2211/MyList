package onimko;

import java.util.Collection;

public interface MyList<E> {
  int size();
  boolean isEmpty();
  boolean contains(E el);
  void add(E item);
  void addAll(Collection<E> c);
  void clear();
  void remove(E item);
  void removeAll(Collection<E> c);
}
