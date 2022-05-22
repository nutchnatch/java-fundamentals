package com.multithreading.cuncorrency;

public class BankAccountSynchronized {

    private int balance;

    public BankAccountSynchronized(int startBalance) {
        balance = startBalance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }
}
