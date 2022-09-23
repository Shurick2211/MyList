package onimko;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
  Object[] toArray();

  default Stream<E> stream() { return (Stream<E>) Arrays.stream(this.toArray()); }

  default void addAll(Collection<E> collection) {
    collection.forEach(this::add);
  }

  default void removeAll(Collection<E> collection) {
    collection.forEach(this::remove);
  }
}
