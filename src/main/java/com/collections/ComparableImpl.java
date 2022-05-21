package com.collections;

import java.util.TreeSet;

public class ComparableImpl implements Comparable<ComparableImpl> {
    public static void main(String[] args) {

        TreeSet<ComparableImpl> tree = new TreeSet<>();
        tree.add(new ComparableImpl("222", "ghi"));
        tree.add(new ComparableImpl("333", "abc"));
        tree.add(new ComparableImpl("111", "def"));
        tree.forEach(System.out::println);
    }

    public ComparableImpl(String label, String value) {
        this.label = label;
        this.value = value;
    }

    String label, value;
    public String toString() {
        return label + " | " + value;
    }

     public boolean equals(Object o) {
         ComparableImpl other = (ComparableImpl) o;
         return value.equals(other.value);
     }

     public int compareTo(ComparableImpl other) {
         return this.value.compareToIgnoreCase(other.value);
     }
}
