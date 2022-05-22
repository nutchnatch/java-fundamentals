package com.multithreading.cuncorrency;

public class Worker implements  Runnable{

    private BankAccount account;
    private final int worNumber;

    public Worker(BankAccount account, int worNumber) {
        this.account = account;
        this.worNumber = worNumber;
    }

    public int getWorNumber() {
        return worNumber;
    }

    @Override
    public  void run() {
        for(int i = 0; i < 10; i++) {
            synchronized (account) {
                int startBalance = account.getBalance();
                account.deposit(10);
                int endBalance = account.getBalance();
                System.out.println("End Balance: " + endBalance + " Start Balance: " + startBalance + " Worker: " + worNumber);
            }
        }
    }
}
