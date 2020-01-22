package com.list.demo;

import java.util.*;

public class SetSimpleUse {
  public static void main(String[] args) {
    // Set，集，不能有重复元素，可以有 null
    // 可能无序或有序
    // HashSet、TreeSet
    // LinkedHashSet，EnumSet ......
    // 所有的集，都实现了 Set 接口，而 Set 接口继承自 Collection
    // 所以我们可以说所有的集都实现了 Collection
    // Set 和 Collection 接口的方法是完全一样的，仅是用于语义上的用途

    HashSet<String> set = new HashSet<>();
    System.out.println(set instanceof Set);
    System.out.println(set instanceof Collection);
    System.out.println(set instanceof List);

    // 添加
    set.add("A");
    set.add("B");
    set.add("C");
    set.add("G");
    set.add("F");
    set.add("E");

    // 遍历 - for循环
    // 因为是无序的，同样的索引取出来值可能b不一样
    //    for (int i = 0; i < set.size(); i++){
    //      String str = set.get(下标);
    //    }

    // 遍历 - 迭代器
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // List 有序，指的是按插入顺序来保存元素
    // TreeSet 有序，指的是元素按照一定规则来排序，Comparator 接口

    TreeSet<String> set2 = new TreeSet<>();
    set2.add("1");
    set2.add("2");
    set2.add("3");
    set2.add("6");
    set2.add("5");
    set2.add("4");
    for (String str : set2) {
      System.out.print(str + ",");
    }
    System.out.println();

    Iterator<String> iterator2 = set2.iterator();
    while (iterator2.hasNext()) {
      System.out.println(iterator2.next());
    }

    // 如果需要使用 HashSet 的查找元素的高性能
    // 同时又需要按元素插入顺序来排序
    // add 添加成功返回 true，如果要添加的元素已经存在，则返回 false

    LinkedHashSet<String> set3 = new LinkedHashSet<>();
    set3.add("1");
    set3.add(null);
    set3.add("2");
    set3.add("3");
    set3.add("6");
    System.out.println(set3.add("5"));
    set3.add("4");
    set3.add(null);
    System.out.println(set3.add("5"));
    Iterator<String> iterator3 = set3.iterator();
    while (iterator3.hasNext()) {
      System.out.println(iterator3.next());
    }
    //        remove(元素索引);
    //        remove(对象);
    // remove 方法如果成功删除，返回 true，否则返回 false

    Collection<String> removeSet = new HashSet<>();
    removeSet.add("1");
    removeSet.add("2");
    set3.removeAll(removeSet);
    System.out.println(set3.remove("5"));
    System.out.println(set3.remove("7"));
    System.out.println("set3=" + set3);

    List<String> list = new ArrayList<>();
    list.add(null);
    list.add("1");
    list.add("2");
    list.add("1");
    list.add(null);
    list.add(null);
    System.out.println("list=" + list);
    list.remove("3");
    // list.remove(6); // 索引值不在 [0 ~ size()) 区间，抛 IndexOutOfBoundsException 异常
    // list.remove("1");

    List<String> removeList = new ArrayList<>();
    removeList.add("1");
    removeList.add(null);

    list.removeAll(removeList);

    System.out.println("list=" + list);
  }
}
