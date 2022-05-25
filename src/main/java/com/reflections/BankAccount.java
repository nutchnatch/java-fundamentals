package com.reflections;

import com.metadata.annotations.ProcessedBy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@ProcessedBy(AccountWorker.class)
public class BankAccount implements Serializable {

    private static final long serialVersionUID = -4119711385213007425L;
    private int balance;
    private String id;
    private char lastTxType;
    private int lastTxAmount;
    private transient int otherValue;

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

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", id='" + id + '\'' +
                '}';
    }

    /**
     * Override the read process of the serialization process
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        ObjectInputStream.GetField fields = in.readFields();
        id = (String)fields.get("id", null);
        balance = fields.get("balance", 0);
        lastTxType = fields.get("lastTxType", 'u');
        lastTxAmount = fields.get("lastTxAmount", -1);
    }

    /**
     * Override the write process of the serialization process
     * @param oos
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }
}
