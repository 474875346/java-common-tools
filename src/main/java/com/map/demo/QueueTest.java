package com.map.demo;

import java.util.*;

public class QueueTest {
  // 队列 Queue
  //  队列指的是一种在队尾插入元素、在对头删除元素
  //  两端队列：可以在队尾/队头同时进行插入或删除
  // 队列的特点：只能对队头或队尾队元素进行操作，而不能对队列中间的元素进行操作。
  //  先进先出：FIFO
  //  先进先出：
  // 队列的两个接口：Queue、Deque
  // 队列的实现类
  //  1.LinkedList 具有队列、两端队列的功能，内部使用链表来实现
  //  2.ArrayDeque 具有队列、两端队列的功能，内部使用循环数组来实现
  //  3.PriorityQueue 优先级队列，它内部实现结构可以快速把所有元素中最小的元素单独放出来
  // 最典型的应用场景：任务调度
  // 两个应用场景：任务调度、LRU
  // 两个工具：Arrays、Collections

  public static void testQueueOp() {
    // 队列
    // Queue 接口的方法
    Queue<String> queue = new ArrayDeque<>();
    // 增删查改
    // 增
    // add(E)/offer(E)
    // 在队列未满的情况下，添加元素到队列的尾部。
    // 如果队列已满：add 抛异常 IllegalStateException
    //             offer 返回 false
    queue.add("str1");
    queue.add("str3");
    queue.offer("str2");
    queue.offer("str4");
    // 删
    // remove/poll
    // 如果队列不为空，删除并返回队头的元素
    // 如果队列为空，remove 抛异常 NoSuchElementException
    //             poll 返回 null
    // 如果使用 remove 来获取队尾元素时，remove前需要判断队列是否为空
    //    size() = 0，isEmpty()
    // 如果使用 poll 来获取队尾元素时，获取到结果后，先判断结果是否为 null
    //    System.out.println("remove = " + queue.remove());
    //    System.out.println(queue);
    //    System.out.println("remove = " + queue.remove());
    //    System.out.println(queue);
    //    System.out.println("remove = " + queue.remove());
    //    System.out.println(queue);
    //    System.out.println("remove = " + queue.remove());
    //    System.out.println(queue);
    //    System.out.println(queue.isEmpty());
    //    System.out.println("poll = " + queue.poll());
    //    System.out.println("remove = " + queue.remove());

    // 查，仅查看队头元素是什么，不删除
    // element/peek
    // 如果队列不为空，返回队列的头部元素，但不删除
    // 队列为空时：element 抛异常 NoSuchElementException
    //           peek 返回 null
    // 注意：调用 element 方法前判断队列是否为空
    //      调用 peek 方法后先判断返回结果是否为 null

    //    queue.clear();
    //    System.out.println(queue);
    //    System.out.println("对头元素peek() = " + queue.peek());
    //    System.out.println("队头元素element() = " + queue.element());
    //    System.out.println(queue);
  }

  public static void testDequeOp() {
    // 两端队列 Deque：增删查

    Deque<String> deque = new LinkedList<>();

    // 增（Queue：add/offer）
    // addFirst/addLast/offerFirst/offerLast
    // 队列不为空时，在队头或队尾添加元素
    // 如果队列已满：addFirst/addLast 抛异常 IllegalStateException
    //             offerFirst/offerLast 返回 false

    deque.addLast("str1");
    deque.addLast("str3");
    deque.addFirst("str2");
    deque.addFirst("str4");
    System.out.println(deque);

    // 删（queue：remove/poll）
    // removeFirst/removeLast/pollFirst/pollLast
    // 队列非空时，删除并返回队头或队尾的元素
    // 队列为空时，removeFirst/removeLast 抛异常 NoSuchElementException
    //           pollFirst/pollLast 返回 null
    // 注意：removeXXX 方法前判断队列是否为空
    //      pollXXX 方法后先判断返回结果是否为 null
    //    System.out.println(deque.pollFirst());
    //    System.out.println(deque.pollLast());
    //    System.out.println(deque.pollLast());
    //    System.out.println(deque.pollLast());
    //    System.out.println(deque);
    //    System.out.println(deque.removeFirst());
    //    System.out.println(deque.removeLast());
    //    System.out.println(deque.pollFirst());
    //    System.out.println(deque.pollLast());

    // 查：（queue：element/peek）
    // getFirst/getLast/peekFirst/peekLast
    // 队列非空时，返回队头或队尾的元素，但不删除
    // 队列为空时：getFirst/getLast 抛异常 NoSuchElementException
    //           peekFirst/peekLast 返回 null
    // 注意：getXXX 方法前判断队列是否为空
    //      peekXXX 方法后先判断返回结果是否为 null

    deque.clear();
    System.out.println(deque.isEmpty());
    //    System.out.println(deque.getFirst());
    //    System.out.println(deque.getLast());
    System.out.println(deque.peekFirst());
    System.out.println(deque.peekLast());
  }

  public static void Priority() {
    // 优先级队列：任务调度
    // 特点：内部使用了一种堆的数据结构，是自我调整的二叉树
    //      当向队列中添加/删除元素的时候，它能快速找到队列中最小的元素
    //      并且移动到树的根部，而不用对所有元素进行排序
    // 对优先级队列进行遍历的时候，无序
    PriorityQueue<String> pq = new PriorityQueue<>();
    pq.add("1");
    pq.add("3");
    pq.add("5");
    pq.add("7");
    pq.add("2");
    pq.add("4");
    pq.add("8");
    pq.add("6");
    // 数组或者实现了 Iterable 接口的类可以用于 for each 语法
    for (String str : pq) {
      System.out.println("> " + str);
    }
    System.out.println("get");
    // remove 删除并返回队列中最小的元素
    // 如果队列为空则抛 NoSuchElementException 异常
    // remove 方法之前判断队列是否为空
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());
    System.out.println(pq.remove());

    // TreeMap
    // 构建 TreeMap 时，指定 Comparator
    // 未指定 Comparator 时，key 值对象必须实现 Comparable 接口
    // Comparable 和 Comparator 区别？？？
    // Comparable 比较自身和另一对象，compareTo
    // Comparator 比较的是传入的两个对象，compare
    // TreeMap

    // 优先级队列如何找最小元素：构造指定 Comparator
    // 或者存放元素实现 Comparable 接口

    PriorityQueue<Task> taskList =
        new PriorityQueue<>(
            new Comparator<Task>() {
              @Override
              public int compare(Task o1, Task o2) {
                // 小于  等于  大于
                //  -1    0    1
                if (o1.priority < o2.priority) {
                  return -1;
                }
                if (o1.priority == o2.priority) {
                  return 0;
                }
                return 1;
              }
            });

    for (int i = 0; i < 10; i++) {
      int priority = new Random().nextInt(10);
      taskList.add(new Task(priority, "任务" + (i + 1)));
    }
    System.out.println(taskList);

    // 执行任务
    while (true) {
      if (taskList.isEmpty()) {
        System.out.println("任务执行完成，退出");
        break;
      }
      Task task = taskList.remove();
      System.out.println(String.format("执行任务：%s,优先级：%d", task.name, task.priority));
    }
  }

  static class Task {
    private int priority;
    private String name;

    public Task(int priority, String name) {
      this.name = name;
      this.priority = priority;
    }

    @Override
    public String toString() {
      return "任务" + name + "(" + priority + ")";
    }
  }
}
