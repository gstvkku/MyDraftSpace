package io.codeforall.kernelfc;

import java.util.Iterator;

public class MyIterator<E> implements Iterator {
    private Integer currentElement;
    private Range range;

    public MyIterator(Range range) {
        this.range = range;
        currentElement = range.getMin();
    }

    public void set(int e) {
        this.currentElement = e;
    }

    public int get() {
        return currentElement;
    }

    @Override
    public boolean hasNext() {
        return currentElement <= range.getMax();
    }

    @Override
    public Object next() {
        Integer[] removedElements = range.getRemovedElements();
        for (Integer removedElement : removedElements) {
            if (removedElement.equals(currentElement + 1)) {
                currentElement++;
            }
        }
        return currentElement++;
    }

   /* @Override
    public void remove() {
        range.setRemovedElements(currentElement);
        currentElement++;
    }*/
}
