package com.string.regular.expressions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

public class StringFormating {
    public static void main(String[] args) {
        format();
        formatFlag();
        argumentIndex();
    }

    static public void format() {

        int david = 13, dawson = 11, dillon = 4, gordon = 2;
        String s2 = String.format("My nephews are %d, %d, %d, and %d years old", david, dawson, dillon, gordon);
        System.out.println(s2);

        double avDiff = ((david - dawson) + (dawson - dillon) + (dillon - gordon)) / 3.0d;
        System.out.println(avDiff);
        // %.2f --> 2 decimal numbers (precision) for float
        // [argument index][flags][width][precision] conversion
        String s4 = String.format("The average age between eah is %.2f years", avDiff);
        System.out.println(s4);
    }

    static public void formatFlag() {
        String s1 = String.format("%d", 32);
        String s2 = String.format("%o", 32);
        String s3 = String.format("%x", 32);
        String s4 = String.format("%#o", 32);
        String s5 = String.format("%#x", 32);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        String s6 = String.format("W:%d X:%d", 5, 32);
        String s7 = String.format("Y:%d Z:%d", 481, 12);
        System.out.println(s6);
        System.out.println(s7);

        String s8 = String.format("W:%4d X:%4d", 5, 32);
        String s9 = String.format("Y:%4d Z:%4d", 481, 12);
        System.out.println(s8);
        System.out.println(s9);

        String s10 = String.format("W:%04d X:%04d", 5, 32);
        String s11 = String.format("Y:%04d Z:%04d", 481, 12);
        System.out.println(s10);
        System.out.println(s11);

        String s12 = String.format("W:%-4d X:%-4d", 5, 32);
        String s13 = String.format("Y:%-4d Z:%-4d", 481, 12);
        System.out.println(s12);
        System.out.println(s13);

        // Group separator
        String s14 = String.format("%d", 1234567);
        String s15 = String.format("%,d", 1234567);
        String s16 = String.format("%,.2f", 1234567.0);
        System.out.println(s14);
        System.out.println(s15);
        System.out.println(s16);

        String s17 = String.format("%d", 123);
        String s18 = String.format("%,d", -456);
        String s19 = String.format("% d", 123);
        String s20 = String.format("% d", -456);
        System.out.println(s17);
        System.out.println(s18);
        System.out.println(s19);
        System.out.println(s20);

        String s21 = String.format("%+d", 123);
        String s22 = String.format("%+d", -456);
        System.out.println(s21);
        System.out.println(s22);

        String s23 = String.format("%(d", 123);
        String s24 = String.format("%(d", -456);
        String s25 = String.format("% (d", 123);
        System.out.println(s23);
        System.out.println(s24);
        System.out.println(s25);
    }

    static public void argumentIndex() {
        String s1 = String.format("%d %d %d", 100, 200, 300);
        String s2 = String.format("%3$d %1$d %2$d", 100, 200, 300);
        String s3 = String.format("%2$d %<04d %1$d", 100, 200, 300);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    static void doWrite(int david, int dawson, int dillon, int gordon, double avgDiff) throws IOException {

        BufferedWriter br = Files.newBufferedWriter(Paths.get("myFile.txt"));
        try (Formatter f = new Formatter(br)) {
            f.format("My nephews are %d, %d, %d, and %d years old", david, dawson, dillon, gordon);
            f.format("The average age between each is %.1f years", avgDiff);
            String line;
        }
    }
}
