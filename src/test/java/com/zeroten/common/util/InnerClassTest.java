package com.zeroten.common.util;

import org.testng.annotations.Test;

public class InnerClassTest {
    @Test
    public void testInnerClass() {
        ArraySequence as = new ArraySequence(5){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        Selector  selector = as.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
        Selector selectorRev = as.selectorRev();

        while (!selectorRev.end()){
            System.out.println(selectorRev.current());
            selectorRev.next();
        }
    }
}
