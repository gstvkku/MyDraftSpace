package io.codeforall.bootcamp;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        index++;
        Node iterator = head;
        if (iterator.getNext() != null && index >= 0 && index <= this.length) {
            for (int i = 0; i < index; i++) {
                iterator = iterator.getNext();
            }
            return iterator.data;
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        Node iterator = head;
        if (this.length != 0) {
            iterator = iterator.getNext();
            for (int i = 0; i < this.length; i++) {
                if (iterator.data.equals(data)) {
                    return i;
                }
                iterator = iterator.getNext();
            }
        }
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        int index = indexOf(data);
        Node iterator = head;
        if (iterator.getNext() != null && index >= 0) {
            iterator = iterator.getNext();
            for (int i = 0; i <= index; i++) {
                if (index == 0) {
                    head.setNext(iterator.getNext());
                    iterator.setData(null);
                    this.length--;
                    return true;
                } else if (index == this.length && i == index) {
                    iterator.setData(null);
                    this.length--;
                    return true;
                } else {
                    if (i == index - 1) {
                        Node tempColector = iterator.getNext();
                        iterator.setNext(iterator.getNext().getNext());
                        tempColector.setData(null);
                        this.length--;
                        return true;
                    }
                    iterator = iterator.getNext();
                }
            }
        }
        return false;
    }
    public void replace (int indexToNewData, Object newData) {
        indexToNewData++;
        Node iterator = head;
        if (iterator.getNext() != null && indexToNewData >= 0 && indexToNewData <= this.length) {
            for (int i = 0; i < indexToNewData; i++) {
                iterator = iterator.getNext();
            }
            iterator.setData(newData);
        }
        System.out.println("You can't do this:");
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
