package com.zeroten.common.util;

public class OuterClass {
    private Integer index;
    private String name;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName(){
//        System.out.println();
        String method = "printName";
//        class LocalInnerClass {
//            public void println(){
//                System.out.println(method);
//                System.out.println("我的外围类Name=" + OuterClass.this.name);
//                System.out.println("我的外围类Index=" + index);
//                System.out.println("⽅法名=" + method);
//            }
//        }
//        new LocalInnerClass().println();
        new PrintInterface(){

            @Override
            public void println() {
                System.out.println(method);
                System.out.println("我的外围类Name=" + OuterClass.this.name);
                System.out.println("我的外围类Index=" + index);
                System.out.println("⽅法名=" + method);
            }
        };
    }

    public class InnerClass {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public void printName(){
            System.out.println(name);
            System.out.println("我是外围类Name="+OuterClass.this.name);
            System.out.println("我是外部类Index="+index);
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.setIndex(1);
        oc.setName("我是外部类");
        oc.printName();

        OuterClass.InnerClass ic = oc.new InnerClass();
        ic.setName("我是内部类");
        ic.printName();

    }
}
