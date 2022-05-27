package com.serialization;

import com.reflections.BankAccount;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountGroup implements Serializable {

    public static void main(String[] args) {
        AccountGroup group = new AccountGroup();
        BankAccount account = new BankAccount(20, "123");
        group.addAccount(account);
    }

    Map<String, BankAccount> accountMap = new HashMap<>();
    private transient int totalBalance;

    public int getTotalBalance() {
        return totalBalance;
    }

    public void addAccount(BankAccount account) {
        totalBalance += account.getBalance();
        accountMap.put(account.getId(), account);
    }

    /**
     * Override the read process of the serialization process
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Since totalBalance is transient, it is not serialized. Then this is a custom way to serialize and calculate its value
        // during the serialization process
        for(BankAccount account: accountMap.values()) {
            totalBalance += account.getBalance();
        }
    }
}
