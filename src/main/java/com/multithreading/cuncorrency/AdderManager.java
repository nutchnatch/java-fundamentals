package com.multithreading.cuncorrency;

import java.util.concurrent.*;

public class AdderManager {

    public static void main(String[] args) {
        AdderManager adderManager = new AdderManager();
        adderManager.runAdder();
    }

    public void runAdder() {
        String[] inFiles = {"file1.txt", "file2.txt", "file3.txt"};
        String[] outFiles = {"file1-out.txt", "file2-out.txt", "file3-out.txt"};
//        Thread[] threads = new Thread[inFiles.length];
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];

        for(int i = 0; i < inFiles.length; i ++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            results[i] = executorService.submit(adder);
//            executorService.submit(adder);
//            threads[i] = new Thread(adder);
//            threads[i].start();
        }

        for(Future<Integer> result: results) {
            try {
                int value = result.get(); // blocks until return value is available
                System.out.println("Total: " + value);
            } catch(ExecutionException | InterruptedException e) {
                System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

//        for(Thread thread: threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
//            }
//        }
    }
}
