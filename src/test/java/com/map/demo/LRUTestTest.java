package com.map.demo;

public class LRUTestTest {
  public static void main(String[] args) {
    LRUTest.LRU<String, String> lru = new LRUTest.LRU<>();
    lru.put("001", "张三");
    lru.put("002", "李四");
    lru.put("003", "王五");
    lru.put("004", "李六");
    lru.put("005", "谢八");
    System.out.println(lru);

    System.out.println(lru.get("003"));
    System.out.println(lru);

    System.out.println(lru.get("001"));
    System.out.println(lru);

    lru.put("006", "新加");
    System.out.println(lru);

    lru.put("005", "谢8");
    System.out.println(lru);

    lru.put("007", "林零钱");
    System.out.println(lru);
  }
}
