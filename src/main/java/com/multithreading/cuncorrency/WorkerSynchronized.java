package com.multithreading.cuncorrency;

import java.lang.Runnable;

public class WorkerSynchronized implements  Runnable{

    private BankAccountSynchronized account;
    private final int worNumber;

    public WorkerSynchronized(BankAccountSynchronized account, int worNumber) {
        this.account = account;
        this.worNumber = worNumber;
    }

    public int getWorNumber() {
        return worNumber;
    }

    @Override
    public  void run() {
        for(int i = 0; i < 10; i++) {
            int startBalance = account.getBalance();
            account.deposit(10);
            int endBalance = account.getBalance();
            System.out.println("End Balance: " + endBalance + " Start Balance: " + startBalance + " Worker: " + worNumber);
        }
    }
}
