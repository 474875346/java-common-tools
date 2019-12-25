package com.zeroten.common.util;

public class ArraySequence {
    private Object[] data;
    private int next = 0;

    public ArraySequence(int size){
        data = new Object[size];
    }

    public void add(Object object){
        if (next<data.length){
            data[next++] = object;
        }
    }

    public SequenceSelector  selector(){
        return new SequenceSelector();
    }
    public RevSequenceSelector selectorRev(){
        return new RevSequenceSelector();
    }

    private class  SequenceSelector implements Selector{
        private int index = 0;

        @Override
        public boolean end() {
            return index==data.length;
        }

        @Override
        public Object current() {
            if (index < data.length){
                return data[index];
            }
            return null;
        }

        @Override
        public void next() {
            index++;
        }
    }

    private class RevSequenceSelector implements Selector{
        private int index;
        public RevSequenceSelector(){
            this.index = data.length-1;
        }
        @Override
        public boolean end() {

            return index<0;
        }

        @Override
        public Object current() {
            if (index >-1){
                return data[index];
            }
            return null;
        }

        @Override
        public void next() {
            index--;
        }
    }
}
