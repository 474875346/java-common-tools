package com.map.demo;

import java.util.*;

public class TreeMapTest {
  public static void main(String[] args) {
    // HashMap 无序
    // TreeMap 有序，和前边的List有序不一样
    // 1, 构造
    // 2. 添加/删除/遍历/修改（CRUD - 增删改查）
    TreeMap<XuHao, String> map = new TreeMap<>();
    // key - 学生的序号
    // value - 学生的信息
    // 对应 TreeMap，key值对象必须实现了 Comparable 接口
    map.put(new XuHao(1), "张三，20");
    map.put(new XuHao(3), "李四，21");
    map.put(new XuHao(2), "王五，22");
    map.put(new XuHao(9), "赵六，24");
    map.put(new XuHao(5), "刘七，25");
    // Map 严格来说不是一个集合，但是它有三个视图，我们可以把这三个视图当成集合来使用
    // 1. Key集
    // 2. 值集合
    // 3. 键值对集

    //    System.out.println(map.keySet());
    //    System.out.println(map.values());
    //    System.out.println(map.entrySet());

    for (Map.Entry<XuHao, String> item : map.entrySet()) {
      System.out.println(item.getKey() + "=" + item.getValue());
    }
    // TreeMap 是有序的，这个有序的指的是 key 值的排序
    // 那么 key 是如何排序?
    // 1. 构造TreeMap时，未指定排序器（即Comparator接口实现），那么 key 值对象就必须实现排序接口 Comparable
    // 2. 构造TreeMap时，指定了排序器，那么 key 值对象可以不实现接口Comparable
    // 存放元素的时候，会调用 Comparable 接口的 compareTo 方法，默认按升序进行排序
    // Comparable / Comparator 这两个接口的区别?
    //   Comparable int compareTo(T o)o
    //   Comparable 比较的是自身和传入对象的大小
    // Comparator 接口比较的是两个传入对象的大小
    // 当 put 添加元素或 remove 元素时，是使用比较器来进行比较两个元素是否相等，而不是使用 equals
    // 优先使用构造时传入的 Comparator 的 compare 方法，如果未指定，则使用 Key 值对象的 Comparable 接口的 compareTo 方法
    map.remove(new XuHao(5));
    System.out.println(map);

    System.out.println("使用 HashMap");
    HashMap<XuHao, String> hashMap = new HashMap<>();
    hashMap.put(new XuHao(1), "我是第一个学生");
    XuHao xh51 = new XuHao(5);
    System.out.println("hashCode=" + xh51.hashCode());
    hashMap.put(xh51, "我是第五个学生");
    System.out.println("删除前：" + hashMap);
    XuHao xh52 = new XuHao(5);
    System.out.println("hashCode=" + xh52.hashCode());
    hashMap.remove(xh52);
    hashMap.put(xh52, "我是第五个替换学生");
    // put/get/remove, key
    // 1. 计算 key 的 hash 值，即调用 hashCode 方法；而自定义对象默认的 Object.hashCode 是返回它的地址
    // 2. hash % 桶数 = 桶索引
    // 3. 比较 key 值是否相等，equals
    System.out.println("删除后：" + hashMap);

    // 学生列表，既可以按学号正序排列，也可以反序排列？？？
    //        排序器 v;
    //        if (排序规则1) {
    //            v = new 排序器1();
    //        } else if (排序规则2) {
    //            v = new 排序器2();
    //        } else if (排序规则3) {
    //            v = new 排序器3();
    //        } else {
    //            v = new 排序器default();
    //        }
    // 排序器 v = 排序器工厂类.创建(排序规则);
    // 或者使用策略模式
    //    TreeMap<BaseXuHao, String> treeMap2 = new TreeMap(XuHaoOrderFactory.getComparator(true));
    //    TreeMap<BaseXuHao, String> treeMap2 = new TreeMap();
    //    treeMap2.put(new BaseXuHao(1), "第一个学生");
    //    treeMap2.put(new BaseXuHao(3), "第三个学生");
    //    treeMap2.put(new BaseXuHao(2), "第二个学生");
    //    treeMap2.put(new BaseXuHao(5), "第五个学生");
    //    System.out.println(treeMap2);

    // LinkedHashMap 具有和 HashMap 一样的功能
    // 增强：保持元素的插入顺序
    // LinkedHashMap 在 HashMap 的基础上增加了如下内容：
    // head 指向按插入顺序，第一个元素的引用
    // tail 指向按插入顺序，后一个元素的引用
    // 对每一个元素的对象，Entry or Node 增加了两个属性
    // 1. before 指向按插入顺序，前一个元素的引用
    // 2. after 指向按插入顺序，后一个元素的引用
    LinkedHashMap<XuHao, String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(new XuHao(1), "第一");
    linkedHashMap.put(new XuHao(5), "第五");
    linkedHashMap.put(new XuHao(3), "第三");
    for (Map.Entry<XuHao, String> entry : linkedHashMap.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }

    // WeakHashMap，当里面的某个元素不在被使用时，可以被垃圾回收器回收
    // EnumMap，Key值必须是枚举类型
    // IdentityHashMap，Key值的哈希值计算方式：通常：key值对象.hasCode()，
    // IdentityHashMap 中 Key值的哈希值计算方式：System.identityHashCode(key);
    BaseXuHao bxh = new BaseXuHao(1);
    System.out.println(bxh);
    System.out.println(bxh.hashCode());
    System.out.println(System.identityHashCode(bxh));
    int hashCode = bxh.hashCode();
    System.out.println(Integer.toHexString(hashCode));
  }

  static class XuHaoOrderFactory {
    public static Comparator getComparator(boolean isAsc) {
      return new Comparator() {

        @Override
        public int compare(Object one, Object two) {
          if (one instanceof BaseXuHao && two instanceof BaseXuHao) {
            BaseXuHao o1 = (BaseXuHao) one;
            BaseXuHao o2 = (BaseXuHao) two;
            if (o1.index < o2.index) {
              return isAsc ? -1 : 1;
            }
            if (o1.index == o2.index) {
              return 0;
            }
            return isAsc ? 1 : -1;
          }
          return -1;
        }
      };
    }
  }

  static class BaseXuHao {
    protected Integer index; // 学号

    public BaseXuHao(Integer index) {
      if (index == null) {
        this.index = 0;
      } else {
        this.index = index;
      }
    }

    @Override
    public String toString() {
      return String.format("学号：%d", index);
    }
  }

  static class XuHao extends BaseXuHao implements Comparable {

    public XuHao(Integer index) {
      super(index);
    }

    @Override
    public boolean equals(Object obj) {
      System.out.println("调用了 equals 方法");
      return true;
    }

    @Override
    public int compareTo(Object other) {
      // -1 0 1
      // 小于 other 时返回小于0的数：-1
      // 等于 other 时返回0
      // 大于 other 是返回大于0的数：1
      if (other instanceof XuHao) {
        XuHao xh = (XuHao) other;
        if (this.index < xh.index) {
          return -1;
        }
        if (this.index == xh.index) {
          System.out.println("相等了：" + xh.index);
          return 0;
        }
        return 1;
      }
      return -1;
    }
  }
}
