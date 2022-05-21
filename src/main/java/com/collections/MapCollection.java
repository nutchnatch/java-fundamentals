package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapCollection {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("222", "ghi");
        map.put("333", "abc");
        map.put("111", "def");
        map.replaceAll((k, v) -> v.toUpperCase());
        map.forEach((k, v) -> System.out.println(k + " | " + v));

        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("222", "ghi");
        sortedMap.put("333", "abc");
        sortedMap.put("111", "def");
        sortedMap.forEach((k, v) -> System.out.println(k + " | " + v));

        SortedMap<String, String> hMap = sortedMap.headMap("333");
        System.out.println("-----");
        hMap.forEach((k, v) -> System.out.println(k + " | " + v));

        SortedMap<String, String> tailMap = sortedMap.tailMap("333");
        System.out.println("-----");
        tailMap.forEach((k, v) -> System.out.println(k + " | " + v));
    }
}
