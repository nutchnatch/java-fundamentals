package com.multithreading.cuncorrency;

public class TxWorker implements Runnable {

    protected BankAccountSynchronized account;
    protected char txxType; // 'w' -> withdrawal, 'd' -> deposit
    protected int amt;
    public TxWorker(BankAccountSynchronized account, char type, int amt) {
        this.txxType = type;
        this.account = account;
        this.amt = amt;
    }

    @Override
    public void run() {
        if(txxType == 'w') {
            account.withdraw(amt);
        } else if(txxType == 'd') {
            account.deposit(amt);
        }
    }
}
