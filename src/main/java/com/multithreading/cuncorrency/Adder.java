package com.multithreading.cuncorrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> /**Runnable*/ {

    private final String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public int doAdd() throws IOException {
        int total = 0;
        String line;
        try(BufferedReader br = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = br.readLine()) != null) {
//                total += Integer.parseInt(line);
                total ++;
            }
        }

        return total;
//        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile))) {
//            bw.write("Total: " + total);
//        } catch (IOException e) {
//            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
//        }
    }

    public Integer call() throws IOException {
        return doAdd();
    }

//    public void run() {
//        doAdd();
//    }
}
