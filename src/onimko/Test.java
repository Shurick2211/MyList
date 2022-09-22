package onimko;

import java.util.LinkedList;
import onimko.myarraylist.MyArrayList;

import java.util.List;
import onimko.mylinkedlist.MyLinkedList;

public class Test {
  public static void main(String...args) {
    testArrayList();
    testLinkedList();
    LinkedList<Integer>f;
  }

  private static void testLinkedList() {
    MyLinkedList<Integer> test = new MyLinkedList<>();
    System.out.println("Test for MyLinkedList:");
    System.out.println("Add = " + addTest(test));

  }

  private static void testArrayList() {
    MyArrayList<Integer> test = new MyArrayList<>();
    System.out.println("Test for MyArrayList:");
    System.out.println("Add = " + addTest(test));
    System.out.println("Get = " + getTest(test));
    System.out.println("Set = " + setTest(test));
    System.out.println("IndexOf = " + indexOfTest(test));
    System.out.println("Remove[i] = " + removeITest(test));
    System.out.println("Contains = " + containsTest(test));
    System.out.println("RemoveObj = " + removeObjTest(test));
    System.out.println("Clear = " + clearTest(test));
    System.out.println("LastIndexOf = " + lastIndexOfTest());
    System.out.println("Empty = " + isEmptyTest(test));
    System.out.println("toArray = " + toArrayTest(test));
    System.out.println("toString = " +test);
    System.out.println("____________________________________");
  }

  private static boolean lastIndexOfTest() {
    MyArrayList<Integer> test = new MyArrayList<>(List.of(1,5,6,9,5,4));
    return test.lastIndexOf(5) == 4 && test.lastIndexOf(3) == -1;
  }

  private static boolean containsTest(MyList<Integer> test) {
    return test.contains(555) && !test.contains(345);
  }

  private static boolean removeObjTest(MyList<Object> test) {
    Integer obj = 555;
    test.remove(obj);
    return test.size() == 13 && !test.contains(obj);
  }

  private static boolean removeITest(MyArrayList<Integer> test) {
    test.remove(5);
    return test.size() == 14 && test.get(5) != 10;
  }

  private static boolean indexOfTest(MyArrayList<Integer> test) {
    return test.indexOf(10) == 5;
  }

  private static boolean clearTest(MyList<Object> test) {
    test.clear();
    return test.size() == 0;
  }

  private static boolean toArrayTest(MyArrayList<Integer> test) {
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

  private static boolean addTest(MyList<Object> test) {
    for (int i = 0; i < 15; i++) test.add(i<<1);
    return test.size() == 15;
  }

  private static boolean isEmptyTest(MyList<Object> test) {
    test.clear();
    boolean empty = test.isEmpty();
    test.add(1);
    return empty && !test.isEmpty();
  }


}

