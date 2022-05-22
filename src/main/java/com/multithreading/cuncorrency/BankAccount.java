package com.multithreading.cuncorrency;

public class BankAccount {

    private int balance;

    public BankAccount(int startBalance) {
        balance = startBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
