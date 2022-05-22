package com.multithreading.cuncorrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccountManager {

    public static void main(String[] args) {
        BankAccountManager accountManager = new BankAccountManager();
//        accountManager.manageAccountSync();
        accountManager.manageAccount();
    }


    public void manageAccountSync() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BankAccountSynchronized account = new BankAccountSynchronized(100);
//        Worker worker = new Worker(account); // one worker for all threads
        WorkerSynchronized[] workers = new WorkerSynchronized[5];
        for(int i = 0; i < 5; i ++) {
            WorkerSynchronized worker = new WorkerSynchronized(account, i);
            workers[i] = worker;
            executorService.submit(worker);
        }
    }

    public void managePromotion() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BankAccountSynchronized account = new BankAccountSynchronized(100);
//        Worker worker = new Worker(account); // one worker for all threads
        TxWorker[] workers = new TxPromoWorker[5];
        for(int i = 0; i < 5; i ++) {
            TxWorker worker = new TxPromoWorker(account, 'd', 20);
            workers[i] = worker;
            executorService.submit(worker);
        }
    }

    public void manageAccount() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);
//        Worker worker = new Worker(account); // one worker for all threads
        for(int i = 0; i < 5; i ++) {
            Worker worker = new Worker(account, i);
            executorService.submit(worker);
        }
    }
}
