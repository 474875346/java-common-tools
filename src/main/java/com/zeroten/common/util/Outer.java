package com.zeroten.common.util;

public class Outer {
    interface Inner{
        void show();
    }
    public static ShowClass create(){
        return new ShowClass();
    }
    private static class ShowClass implements Inner{
        @Override
        public void show() {
            System.out.println(" helloworld");
        }
    }
    public static void main(String[] args) {
        Outer.create().show();
    }
}
