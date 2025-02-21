package io.codeforall.kernelfc;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private Integer min;
    private Integer max;
    private Integer[] removedElements;
    private MyIterator iterator;


    public Range(Integer min, Integer max) {
        this.min = min;
        this.max = max;
        removedElements = new Integer[3];
        iterator = new MyIterator(this);
    }

    @Override
    public MyIterator iterator() {
        return iterator;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Integer[] getRemovedElements() {
        return removedElements;
    }

    public void setRemovedElements(Integer removedElement) {
        for (int i = 0; i < removedElements.length; i++) {
            if (removedElements[i] == null) {
                removedElements[i] = removedElement;
                return;
            }
        }
    }
}