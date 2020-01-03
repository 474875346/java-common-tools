package com.list.demo;

public class Node {
    public String name;
    public Integer age;
    public Node(Integer age, String name){
        this.age = age;
        this.name = name;
        System.out.println(age+name);
    }
}
