package onimko;

import onimko.myarraylist.MyArrayList;
import onimko.mylinkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The test class for my collections.
 */
public class Test {
  public static void main(String...args) {
    testArrayList();
    testLinkedList();
  }

  private static void testLinkedList() {
    MyLinkedList<Integer> test = new MyLinkedList<>();
    System.out.println("Test for MyLinkedList:");
    System.out.println("Add = " + addTest(test));
    System.out.println("Contains = " + containsTest(test));
    System.out.println("Remove = " + removeObjTest(test));
    System.out.println("toArray = " + toArrayTest(test));
    System.out.println("Stream API = " + streamTest(test));
    System.out.println("Add & get first/last = " + addAndGetFirstAndLast());
    System.out.println("forEach = " + forEachTest(test));
    System.out.println("toString = " + test);
    System.out.println("Empty = " + isEmptyTest(test));
    System.out.println("RemoveAll = " + removeAllTest(test));
    System.out.println("____________________________________");
  }

  private static boolean addAndGetFirstAndLast() {
    Integer first = 15;
    Integer last = 25;
    MyLinkedList<Integer> test = new MyLinkedList<>(List.of(1,2,3,4,5));
    test.addFirst(first);
    test.addLast(last);
    return test.getFirst().equals(first) &&  test.getLast().equals(last);
  }

  private static void testArrayList() {
    MyArrayList<Integer> test = new MyArrayList<>();
    System.out.println("Test for MyArrayList:");
    System.out.println("Add = " + addTest(test));
    System.out.println("Get = " + getTest(test));
    System.out.println("Stream API = " + streamTest(test));
    System.out.println("Set = " + setTest(test));
    System.out.println("IndexOf = " + indexOfTest(test));
    System.out.println("Remove[i] = " + removeITest(test));
    System.out.println("Contains = " + containsTest(test));
    System.out.println("RemoveObj = " + removeObjTest(test));
    System.out.println("Clear = " + clearTest(test));
    System.out.println("LastIndexOf = " + lastIndexOfTest());
    System.out.println("Empty = " + isEmptyTest(test));
    System.out.println("toArray = " + toArrayTest(test));
    System.out.println("forEach = " + forEachTest(test));
    System.out.println("toString = " + test);
    System.out.println("RemoveAll = " + removeAllTest(test));
    System.out.println("IndexOfBounds = " + indexOfBoundsTest(test));
    System.out.println("____________________________________");
  }

  private static boolean indexOfBoundsTest(MyArrayList<Integer> test) {
    test.clear();
    test.add(1);
    boolean first = false;
    try {
      if (test.get(0) == 1) first = true;
      test.get(1);
    } catch (IndexOutOfBoundsException e) {
      return first;
    }
    return false;
  }

  private static boolean streamTest(MyList<Integer> test) {
    return test.stream().filter(e-> e < 10).reduce(Integer::sum).get() == 20;
  }

  private static boolean lastIndexOfTest() {
    MyArrayList<Integer> test = new MyArrayList<>(List.of(1,5,6,9,5,4));
    return test.lastIndexOf(5) == 4 && test.lastIndexOf(3) == -1;
  }

  private static boolean containsTest(MyList<Integer> test) {
    test.add(555);
    return test.contains(555) && !test.contains(345);
  }

  private static boolean removeObjTest(MyList<Integer> test) {
    Integer obj = 3456;
    int size = test.size();
    test.add(obj);
    boolean contains = test.contains(obj);
    test.remove(obj);
    return test.size() == size && contains && !test.contains(obj);
  }

  private static boolean removeITest(MyArrayList<Integer> test) {
    test.remove(5);
    return test.size() == 14 && test.get(5) != 10;
  }

  private static boolean indexOfTest(MyArrayList<Integer> test) {
    return test.indexOf(10) == 5;
  }

  private static boolean clearTest(MyArrayList<Integer> test) {
    test.clear();
    return test.size() == 0;
  }

  private static boolean toArrayTest(MyList<Integer> test) {
    return test.toArray().getClass().equals(Object[].class);
  }

  private static boolean setTest(MyArrayList<Integer> test) {
    test.set(1,555);
    return test.get(1) == 555;
  }

  private static boolean getTest(MyArrayList<Integer> test) {
    try{
      test.get(test.size());
    }catch (IndexOutOfBoundsException e) {
      return test.get(0) == 0 && test.get(5) == 10 && test.get(test.size()-1) == 28;
    }
    return false;
  }

  private static boolean addTest(MyList<Integer> test) {
    for (int i = 0; i < 15; i++) test.add(i<<1);
    return test.size() == 15;
  }

  private static boolean isEmptyTest(MyList<Integer> test) {
    test.clear();
    boolean empty = test.isEmpty();
    test.add(1);
    return empty && !test.isEmpty();
  }

  private static boolean forEachTest(MyList<Integer> test) {
    test.clear();
    addTest(test);
    ArrayList<Integer> col = new ArrayList<>();
    test.forEach(i -> col.add(i));
    return Arrays.equals(test.toArray(), col.toArray());
  }

  private static boolean removeAllTest(MyList<Integer> test) {
    test.clear();
    List<Integer> rem = List.of(1,5,8);
    test.addAll(rem);
    boolean noEmpty = !test.isEmpty();
    test.removeAll(rem);
    return test.isEmpty() && noEmpty;
  }
}
