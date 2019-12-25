package com.zeroten.common.util;

public interface Selector {
    boolean end();
    Object current();
    void next();
}
