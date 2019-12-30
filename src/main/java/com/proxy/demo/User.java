package com.proxy.demo;

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(" ");
        if (name != null && name.length() > 0) {
            tmp.append(name); }
        tmp.append(','); tmp.append(" "); if (age != null) {
            tmp.append(age); }
        return tmp.toString();
    }
}
