package com.string.regular.expressions;

import java.util.StringJoiner;

public class StringJoinerSequences {

    public static void main(String[] args) {
        joiner();
    }

    static public void joiner() {
        StringJoiner sj1 = new StringJoiner(", ");
        sj1
                .add("Beta")
                .add("Gama")
                .add("Alfa");
        System.out.println(sj1);

        StringJoiner sj2 = new StringJoiner(", ", "{", "}");
        sj2
                .add("Beta")
                .add("Gama")
                .add("Alfa");
        System.out.println(sj2);

        StringJoiner sj3 = new StringJoiner("], [", "[", "]");
        sj3
                .add("Beta")
                .add("Gama")
                .add("Alfa");
        System.out.println(sj3);

        StringJoiner sj4 = new StringJoiner(", ");
        sj4.setEmptyValue("EMPTY");

        sj4.add("");
        System.out.println(sj4);

        StringJoiner sj5 = new StringJoiner(", ", "{", "}");
        sj5.setEmptyValue("EMPTY");

        sj5.add("");
        System.out.println(sj5);

    }
}
