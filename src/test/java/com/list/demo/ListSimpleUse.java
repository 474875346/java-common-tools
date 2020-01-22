package com.list.demo;

import java.util.*;

public class ListSimpleUse {
  public static void main(String[] args) {
    // 集合分为两大类：
    // 1.1 List，列表，有序的，按照插入顺序排序，可以有重复元素，也可以包含null
    // 1.2 Set，集，不可以有重复元素，可以包含null
    // 1.3 Queue，队列，按一定规则进行添加/删除
    // 2 键值对，全部都实现了Map接口

    // 可以通过<>括号来指定列表里要放的元素的类型
    // 如果 add 添加了不同的类型的元素，在编译阶段就会报错
    List<String> list = new ArrayList<String>();
    list.add("A");
    list.add("C");
    list.add("B");
    list.add("F");
    printAllElement(list);

    List<String> list2 = new LinkedList<>();
    list2.add("1");
    list2.add("3");
    list2.add("5");
    list2.add("2");
    list2.add("4");
    list2.add("6");
    printAllElement(list2);

    List list3 = new ArrayList();
    list3.add(1);
    list3.add("字符串");
    list3.add((new ListSimpleUse()).new CustomClass());
    list3.add(new Date());

    // 如果需要进行强制数据类型转换时，需要使用 instanceof 来判断该变量的实际类型
    for (int i = 0; i < list3.size(); i++) {
      Object obj = list3.get(i);
      if (obj instanceof String) {
        String str = (String) obj;
        System.out.println("字符串：" + str);
      } else if (obj instanceof Integer) {
        Integer n = (Integer) obj;
        System.out.println("Int型数值：" + n);
      } else if (obj instanceof Date) {
        Date date = (Date) obj;
        System.out.println("日期：" + date);
      } else {
        System.out.println("不支持的类型：" + obj.getClass().getName());
      }
    }

    // 继承链
    // A -> B -> C -> D
    // 从子类的角度l来看，它的所有父类都是它的继承链上的对象
    // 从 C 来看：C、B、A 是 C 继承链上的对象
    // 从 B 来看：B、A 是 B 继承链上的对象
    // instanceof 判断的是自己是否实现了继承链上的对象
    // C c;
    // c instanceof D == false
    // c instanceof C == true
    // c instanceof B == true
    // c instanceof A == true
    // c instanceof Object == true
    // instanceof 判断的是自己继承链上对象是否实现了某个接口
    // class B implements JK1, JK3
    // class A implements JK0
    // c instanceof JK1 == true
    // c instanceof JK3 == true
    // c instanceof JK0 == true

    List<Integer> list4 = new ArrayList<>();
    list4.add(1); // 0
    list4.add(2); // 1
    list4.add(3); // 2
    list4.add(4); // 3
    list4.add(5); // 4

    Integer index = 3;
    list4.remove(index);
    list4.remove(1);
    System.out.println("list4=" + list4);

    // Void.class.getName();
    // 数值型：byte, short, int, long
    // 浮点型：float, double
    // 字符型：char
    // 布尔型：boolean
    // 特殊：void

    List<double[]> list5 = new ArrayList<>();
    // list5.add(new int[] {1});
    // list5.add(new int[] {2,3});
    list5.add(new double[] {2, 3});
    System.out.println("list5=" + list5);
  }

  public static void printAllElement(List<String> list) {
    System.out.println("list的元素个数：" + list.size());

    System.out.println("使用for循环遍历");
    for (int i = 0; i < list.size(); i++) {
      String str = list.get(i);
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(str);
    }
    System.out.println();

    // 遍历 - 使用迭代器方式
    Iterator<String> iterator = list.iterator();
    // 迭代器的位置是在元素之间
    // 存在 n 个元素的列表，迭代器的位置可能存在 n + 1 个
    // 获取迭代器后，迭代器的位置在第一个元素之前
    // 未调用 next() 方法时，调用 remove 抛 IllegalStateException 异常？？？
    // remove 方法删除的是调用 next() 方法时返回的元素（越过的元素）
    // iterator.remove();
    while (iterator.hasNext()) {
      // next 方法有两个作用
      // 1. 将迭代器的位置移动至下一个位置
      // 2. 同时返回越过的元素
      String str = iterator.next();
      System.out.println(str);
    }
    // 当迭代器达到最后一个元素之后时，
    // 再调用 next() 方法，抛 NoSuchElementException 异常
    // System.out.println(iterator.next());
  }

  class CustomClass {}
}
