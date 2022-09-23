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

  /**
   * Method gives opportunity to use the MyList for Stream API.
   * @return Stream<E> for use.
   */
  default Stream<E> stream() { return (Stream<E>) Arrays.stream(this.toArray()); }

  /**
   * Method adds another collection on the MyList.
   * @param collection the input collection.
   */
  default void addAll(Collection<? extends E> collection) {
    collection.forEach(this::add);
  }

  /**
   * Method removes another collection without the MyList.
   * @param collection the input collection.
   */
  default void removeAll(Collection<? extends E> collection) {
    collection.forEach(this::remove);
  }
}
