package com.reflections;

import com.metadata.annotations.ProcessedBy;
import com.metadata.annotations.WorkHandler;

//@WorkHandler(useThreadPool = true)
//@WorkHandler // using the default value of this annotation
//@WorkHandler(false) // adding the "false" value to the annotation attribute
@WorkHandler // adding the default "true" value to the annotation attribute
public class AccountWorker implements Runnable, TaskWorker{

    public static void main(String[] args) {
        AccountWorker accountWorker = new AccountWorker();
        BankAccount account = new BankAccount(10, "my_account");
        accountWorker.setTarget(account);
        System.out.println(accountWorker.ba.getId());
        System.out.println(accountWorker.ba.getBalance());
        HighVolumeAccount account1 = new HighVolumeAccount(30, "second_accunt");
        accountWorker.setTarget(account1);
        accountWorker.doWork();
        System.out.println(accountWorker.ba.getId());
        System.out.println(accountWorker.ba.getBalance());
    }

    BankAccount ba;

    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target)) {
            ba = (BankAccount) target;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void doWork() {
        Thread thread = new Thread(HighVolumeAccount.class.isInstance(ba) ? (HighVolumeAccount) ba: this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Running AccountWorker");
    }


}
