package onimko;

import java.util.Collection;
import java.util.function.Consumer;

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
  void forEach(Consumer<? super E> consumer);


  default void addAll(Collection<E> collection) {
    collection.forEach(this::add);
  }

  default void removeAll(Collection<E> collection) {
    collection.forEach(this::remove);
  }
}
