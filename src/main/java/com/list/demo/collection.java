package com.list.demo;


import java.util.*;

public class collection {
    public static void ArrayListDemo() {
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        collection.add("D");
        collection.add("E");
        collection.add("F");
        System.out.println(collection);

        Iterator<String> iterator = collection.iterator();
//        iterator.remove();
//        iterator.next();
//        iterator.remove();
//        System.out.println(collection);
        while (iterator.hasNext()) {
            System.out.println("删除" + iterator.next());
            iterator.remove();
            System.out.println(",结果" + collection);
        }
    }

    public static void ArrayListDemo1() {
        Collection<Node> collection = new ArrayList<>();
        collection.add(new Node(1, "A"));
        collection.add(new Node(2, "B"));
        collection.add(new Node(3, "C"));
        System.out.println(collection);

        Iterator<Node> iterator = collection.iterator();
        Node nodeA = iterator.next();
        // 直接从序列中删除对象，属于结构修改
//         collection.remove(nodeA);
        // 直接向序列中添加对象，属于结构修改
//         collection.add(new Node(4, "D"));
        // 修改序列中已存在对象的状态，不属于结构修改
        nodeA.name = "字⺟" + nodeA.name;
        System.out.println(iterator.next());
        System.out.println(collection);

        collection.add(new Node(5, "E"));
        Iterator<Node> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            Node node = iterator2.next();
            System.out.println(node.name);
        }
    }

    public static void ArrayListDemo2() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);


        // 双向迭代器
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("hasPrevious=" + listIterator.hasPrevious());
        System.out.println("hasNext=" + listIterator.hasNext());
        System.out.println("previousIndex=" + listIterator.previousIndex());
        System.out.println("nextIndex=" + listIterator.nextIndex());


//        System.out.println("previous="+listIterator.previous());
        System.out.println("next=" + listIterator.next());

        System.out.println("hasPrevious=" + listIterator.hasPrevious());
        System.out.println("hasNext=" + listIterator.hasNext());
        System.out.println("previousIndex=" + listIterator.previousIndex());
        System.out.println("nextIndex=" + listIterator.nextIndex());

        listIterator.set("A-Update");
        listIterator.add("A-New");

        System.out.println(list);
        System.out.println("previousIndex=" + listIterator.previousIndex());
        System.out.println("nextIndex=" + listIterator.nextIndex());

        System.out.println("previous=" + listIterator.previous());
        listIterator.set("A-Update2");

        System.out.println(list);
        System.out.println("previousIndex=" + listIterator.previousIndex());
        System.out.println("nextIndex=" + listIterator.nextIndex());

        listIterator.remove();
        System.out.println(list);


        System.out.println("next=" + listIterator.next());
        listIterator.remove();
        System.out.println(list);

    }

    public static void ArrayListAndLinkedList() {
        testListOpTime(new ArrayList());
        testListOpTime(new LinkedList());
    }

    public static void BubbleSort() {
        List<Integer> list = new ArrayList<>();
        RandomList(list);
        System.out.println(list);
        int size = list.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int a = list.get(j);
                int b = list.get(j + 1);
                if (a > b) {
                    list.set(j, b);
                    list.set(j + 1, a);
                }
            }
        }
        System.out.println(list);
    }

    public static void InsertionSort() {
        List<Integer> list = new ArrayList();
        RandomList(list);

        System.out.println(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    int tmp = list.get(j);
                    list.set(j,list.get(j-1));
                    list.set(j-1,tmp);
                }
            }


        }
        System.out.println(list);
    }

    public static void SelectionSort() {
        List<Integer> list = new ArrayList();
        RandomList(list);

        System.out.println(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int minIdx = i;
            for (int j = i; j < size; j++) {
                if (list.get(j) < list.get(minIdx)) {
                    minIdx = j;
                }
            }
            int tmp = list.get(i);
            list.set(i,list.get(minIdx));
            list.set(minIdx,tmp);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        System.out.println("冒泡排序:");
        BubbleSort();
        System.out.println("插入排序:");
        InsertionSort();
        System.out.println("选择排序:");
        SelectionSort();
    }

    public static void RandomList(List list) {
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(100));
        }
    }

    public static void testListOpTime(List list) {
        for (int i = 0; i < 100000; i++) {
            list.add("A");
        }
        int times = list.size();
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            list.add(10, "B");
        }
        System.out.printf("%s：在索引为 10 的位置处插⼊%d个 B，耗时%dms\n",
                list.getClass().getSimpleName(),
                times,
                System.currentTimeMillis() - start);

        // 遍历 - for循环随机访问⽅式
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.printf("%s：for循环随机访问⽅式遍历，耗时%dms\n",
                list.getClass().getSimpleName(),
                System.currentTimeMillis() - start);
        // 遍历 - 迭代器⽅式
        start = System.currentTimeMillis();
        ListIterator listIterator = list.listIterator();
        while (!listIterator.hasNext()) {
            listIterator.next();
        }
        System.out.printf("%s：迭代器⽅式遍历，耗时%dms\n",
                list.getClass().getSimpleName(),
                System.currentTimeMillis() - start);
    }

}
