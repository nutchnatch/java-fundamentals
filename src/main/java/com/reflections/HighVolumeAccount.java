package com.reflections;

import java.lang.Runnable;

public final class HighVolumeAccount extends BankAccount implements Runnable {


    public HighVolumeAccount(int startBalance, String id) {
        super(startBalance, id);
    }

    public HighVolumeAccount(String id) {
        super(id);
    }

    private int[] readDeposits() {
        return new int[]{200,2,3,4};
    }

    private int[] readWithdrawals() {
        return new int[]{5,6,7,8};
    }

    @Override
    public void run() {
        for(int deposit: readDeposits()) {
            deposit(deposit);
        }

        for(int withdrawal: readWithdrawals()) {
            withdrawal(withdrawal);
        }
    }
}
