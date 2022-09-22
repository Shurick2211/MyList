package onimko;

import java.util.Collection;

/**
 * Interface for my Collections
 * @param <E> the tip for data.
 */
public interface MyList<E> {
  int size();
  boolean isEmpty();
  boolean contains(E el);
  void add(E item);
  void clear();
  void remove(E item);

  default void addAll(Collection collection) {
    collection.forEach(el -> add((E) el));
  }

  default void removeAll(Collection collection) {
    collection.forEach(el -> remove((E) el));
  }
}
