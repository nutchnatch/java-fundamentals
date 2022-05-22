package com.multithreading.cuncorrency;

public class TxPromoWorker extends TxWorker{

    public TxPromoWorker(BankAccountSynchronized account, char type, int amt) {
        super(account, type, amt);
    }

    public void run() {
        if(txxType == 'w') {
            account.withdraw(amt);
        } else if(txxType == 'd') {
            synchronized (account) {
                account.deposit(amt);
                if(account.getBalance() > 500) {
                    int bonus = (int)((account.getBalance() - 500) * 0.1);
                    account.deposit(bonus);
                }
            }
        }
    }
}
