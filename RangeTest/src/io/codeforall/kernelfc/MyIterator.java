package io.codeforall.kernelfc;

import java.util.Iterator;

public class MyIterator<E> implements Iterator {
    private Integer currentElement;
    private Range range;

    public MyIterator(Range range) {
        this.range = range;
        currentElement = range.getMin() - 1;
    }

    public void set(int e) {
        this.currentElement = e;
    }

    public int get() {
        return currentElement;
    }

    @Override
    public boolean hasNext() {
        while (currentElement != range.getMax()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Integer[] removedElements = range.getRemovedElements();
        for (Integer removedElement : removedElements) {
            if ((currentElement + 1) == removedElement) {
                currentElement++;
            }
        }
        return currentElement++;
    }

    @Override
    public void remove() {
        range.setRemovedElements(currentElement);
        currentElement++;
    }
}
