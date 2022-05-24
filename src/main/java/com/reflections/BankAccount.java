package com.reflections;

import com.metadata.annotations.ProcessedBy;

@ProcessedBy(AccountWorker.class)
public class BankAccount {

    private int balance;
    private final String id;

    public BankAccount(int startBalance, String id) {
        balance = startBalance;
        this.id = id;
    }

    public BankAccount(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int withdrawal(int amount) {
        return balance -= amount;
    }
}
