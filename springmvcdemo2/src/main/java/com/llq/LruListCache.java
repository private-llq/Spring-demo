package com.llq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LruListCache<E> {

    private final int maxSize;

    private final LinkedList<E> list = new LinkedList<>();

    public LruListCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(E e) {
        if (list.size() < maxSize) {
            list.addFirst(e);
        } else {
            list.removeLast();
            list.addFirst(e);
        }
    }

    public E get(int index) {
        E e = list.get(index);
        list.remove(e);
        add(e);
        return e;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        List<Object> list1 = list.subList(0, 1);
        System.out.println(list1);
    }
}