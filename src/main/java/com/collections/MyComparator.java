package com.collections;

import java.util.*;

public class MyComparator implements Comparator<MyComparator> {

    public static void main(String[] args) {

        TreeSet<MyComparator> tree = new TreeSet<>(new MyComparator());
        tree.add(new MyComparator("222", "ghi"));
        tree.add(new MyComparator("333", "abc"));
        tree.add(new MyComparator("111", "def"));
        tree.forEach(System.out::println);
    }

    MyComparator() {}

    String label, value;
    public MyComparator(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public int compare(MyComparator a, MyComparator b) {
        return a.label.compareToIgnoreCase(b.label);
    }

    public boolean equals(Object o) {
        MyComparator other = (MyComparator) o;
        return value.equals(other.value);
    }

    public String toString() {
        return label + " | " + value;
    }
}
