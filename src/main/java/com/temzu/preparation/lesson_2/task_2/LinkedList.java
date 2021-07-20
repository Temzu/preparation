package com.temzu.preparation.lesson_2.task_2;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    private int length;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.previous = prev;
        }
    }

    public boolean addLast(E e) {
        Node<E> tmpLast = last;
        Node<E> newNode = new Node<>(last, e, null);
        last = newNode;
        if (tmpLast == null)
            first = newNode;
        else
            tmpLast.next = newNode;
        length++;
        return true;
    }

    public boolean addFirst(E e) {
        Node<E> tmpFirst = first;
        Node<E> newNode = new Node<>(null, e, first);
        first = newNode;
        if (tmpFirst == null)
            last = newNode;
        else
            tmpFirst.previous = newNode;
        length++;
        return true;
    }

    public boolean add(E e, int index) {
        checkIndex(index);
        if (index == 0) {
            addFirst(e);
            return true;
        }
        if (index == length - 1) {
            addLast(e);
            return true;
        }
        Node<E> oldNodeByIndex = getNodeByIndex(index);
        Node<E> tmpPrevious = oldNodeByIndex.previous;
        Node<E> newNode = new Node<>(tmpPrevious, e, oldNodeByIndex);
        oldNodeByIndex.previous = newNode;
        if (tmpPrevious == null)
            first = newNode;
        else
            tmpPrevious.next = newNode;
        length++;
        return true;
    }

    public E removeLast() {
        if (last == null)
            throw new NoSuchElementException();
        Node<E> tmpLast = last;
        last = last.previous;
        if (last == null)
            return tmpLast.element;
        tmpLast.previous = null;
        last.next = null;
        length--;
        return tmpLast.element;
    }

    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        Node<E> tmpFirst = first;
        first = first.next;
        if (first == null)
            return tmpFirst.element;
        tmpFirst.next = null;
        first.previous = null;
        length--;
        return tmpFirst.element;
    }

    public E remove(int index) {
        checkIndex(index);
        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();
        Node<E> oldNodeByIndex = getNodeByIndex(index);
        Node<E> tmpPrevious = oldNodeByIndex.previous;
        Node<E> tmpNext = oldNodeByIndex.next;
        tmpPrevious.next = tmpNext;
        tmpNext.previous = tmpPrevious;
        oldNodeByIndex.next = null;
        oldNodeByIndex.previous = null;
        return oldNodeByIndex.element;
    }

    public E get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).element;
    }

    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.element;
    }

    public E getLast() {
        if (last == null)
            throw new NoSuchElementException();
        return last.element;
    }

    private void checkIndex(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException(String.format("Index: %s, Length: %s", index, length));
    }

    private Node<E> getNodeByIndex(int index) {
        if (index > (length / 2)) {
            Node<E> tmpLast = last;
            for (int i = length - 1; i > index; i--)
                tmpLast = tmpLast.previous;
            return tmpLast;
        } else {
            Node<E> tmpFirst = first;
            for (int i = 0; i < index; i++)
                tmpFirst = tmpFirst.next;
            return tmpFirst;
        }
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.addLast("1");
        stringLinkedList.addLast("2");
        stringLinkedList.addFirst("3");
        stringLinkedList.addFirst("4");

        System.out.println(stringLinkedList.getFirst());
        System.out.println(stringLinkedList.getLast());
        System.out.println();

        for (int i = 0; i < 4; i++)
            System.out.println(stringLinkedList.get(i));

        System.out.println();

        stringLinkedList.add("5", 1);
        for (int i = 0; i < 5; i++)
            System.out.println(stringLinkedList.get(i));
        System.out.println();
        System.out.println("Length: " + stringLinkedList.getLength());
        System.out.println();

        LinkedList<String> stringLinkedList2 = new LinkedList<>();
        stringLinkedList2.addFirst("1");
        stringLinkedList2.addFirst("2");
        stringLinkedList2.add("3", 0);
        System.out.println(stringLinkedList2.get(0));
        System.out.println(stringLinkedList2.get(1));
        System.out.println(stringLinkedList2.get(2));
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println(stringLinkedList2.remove(0));
        }
    }
}
