package com.javastreams;


import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.Throwable;

public class Main {

    public static void main(String[] args) {
//        doTryCatchFinally();
//        doTryWithResources();
//        doTryWithResourcesMulti();
        doCloseThing();
    }

    public static void doTryCatchFinally() {

        char[] buff = new char[8];
        Reader reader = null;
        int length;

        try {
            reader = Helper.openReader("file1.txt");
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for(int i = 0; i < length; i ++) {
                    System.out.println(buff[i]);
                }
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }
    }

    public static void doTryWithResources() {

        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("file1.txt")) {
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for(int i = 0; i < length; i ++) {
                    System.out.println(buff[i]);
                }
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void doTryWithResourcesMulti() {

        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("file1.txt"); Writer writer = Helper.openWriter("file2.txt")) {
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                writer.write(buff, 0, length);
                for(int i = 0; i < length; i ++) {
                    System.out.println(buff[i]);
                }
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void doCloseThing() {
        try(MyAutoCloseable mc = new MyAutoCloseable()) {
            mc.saySomething();
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

            for(Throwable t: e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }
}
