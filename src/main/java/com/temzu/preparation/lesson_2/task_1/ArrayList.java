package com.temzu.preparation.lesson_2.task_1;

import java.util.Arrays;

public class ArrayList<T> {

    private Object[] elements;
    private int length;
    private int capacity;

    public ArrayList() {
        this.capacity = 16;
        this.elements = new Object[capacity];
        this.length = 0;
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.elements = new Object[capacity];
    }

    public void add(T e) {
        if (length == capacity) {
            capacity *= 2;
            elements = Arrays.copyOf(elements, capacity);
        }
        elements[length++] = e;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public T remove(int index) {
        checkIndex(index);
        Object element = elements[index];
        if (--length > index)
            System.arraycopy(elements, index + 1, elements, index, length - index);

        elements[length] = null;
        return (T) element;
    }

    private void checkIndex(int index) {
        if (index >= length || index < 0)
            throw new ArrayIndexOutOfBoundsException(String.format("Your index is not correct or less length: %d (length %d)", index, length));
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        if (elements == null)
            return null;
        int iMax = length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(elements[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
