package onimko;

import onimko.myarraylist.MyArrayList;

public class Test {
  public static void main(String...args) {
    testArrayList();
    testLinkedList();
  }

  private static boolean testLinkedList() {
    return false;
  }

  private static void testArrayList() {
    MyArrayList<Integer> test = new MyArrayList<>();
    System.out.println("Empty = " + isEmptyTest(test));
    System.out.println("Add = " + addTest(test));
    System.out.println("Get = " + getTest(test));
    System.out.println("toString = " +test);

  }

  private static boolean getTest(MyArrayList<Integer> test) {
    return test.get(0) == 0 && test.get(5) == 10 && test.get(test.size()-1) == 28;
  }

  private static boolean addTest(MyArrayList<Integer> test) {
    for (int i = 0; i < 15; i++) test.add(i<<1);
    return test.size() == 15;
  }

  private static boolean isEmptyTest(MyArrayList<Integer> test) {
    return test.isEmpty();
  }


}

