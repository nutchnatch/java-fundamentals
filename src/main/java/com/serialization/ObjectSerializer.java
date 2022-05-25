package com.serialization;

import com.reflections.BankAccount;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectSerializer {

    public static void main(String[] args) {
        ObjectSerializer serializer = new ObjectSerializer();
        BankAccount ba = new BankAccount(30, "123");
        serializer.saveAccount(ba, "baSerialized.txt");
        System.out.println(serializer.loadAccount("baSerialized.txt"));
    }

    void saveAccount(BankAccount ba, String fileName) {

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))){
            objectOutputStream.writeObject(ba);
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    BankAccount loadAccount(String fileName) {

        BankAccount ba = null;
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            ba = (BankAccount) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        return ba;
    }
}
