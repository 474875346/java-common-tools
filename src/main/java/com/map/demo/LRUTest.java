package com.map.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest {
  // LRU：Least Recently Used 最近最少使用
  // 缓存：缓存热点数据，经常使用的数据
  // 缓存的一种淘汰算法
  // 当缓存已满时，再向缓存内添加内容时
  // 删除（淘汰）掉缓存中已存在元素最近最少被使用的那个
  // LinkedHashMap 支持 LRU 算法
  // LinkedHashMap 具有 HashMap 的所有功能 + 可保持插入顺序(遍历）
  // HashMap + 双向链表
  // 双向链表：head/tail ，after/before
  // LinkedHashMap 是有序的 boolean accessOrder
  // 1. 插入顺序（accessOrder=false）：每次插入元素，将元素放到双向链表的末尾
  // 2. 访问顺序（accessOrder=false）：每次插入元素/获取元素，将插入的元素或者访问的元素放到双向链表的末尾

  static class LRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {
    private int maxCount = 100;

    public LRU() {
      super(10, 0.75F, true);
    }

    public LRU(int maxCount) {
      super(10, 0.75F, true);
      this.maxCount = maxCount;
    }
    // 参数：eldest 最近最少使用的元素
    // 当调用 put 方法时并且key值不存在，调用

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
      boolean remove = size() > maxCount;
      if (remove) {
        System.out.println("淘汰最近最少使用元素：" + eldest);
      }
      return remove;
    }
  }
}
