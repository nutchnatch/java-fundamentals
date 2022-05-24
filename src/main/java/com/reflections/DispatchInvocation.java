package com.reflections;

public class DispatchInvocation {

    public static void main(String[] args) {
        DispatchInvocation invocation = new DispatchInvocation();
        BankAccount ba = new BankAccount(20, "my_ba");
        invocation.startWork("com.reflections.AccountWorker", ba);
    }

    void startWork(String workerTypeName, Object workerTarget) {
        Class<?> workerType = null;
        try {
            workerType = Class.forName(workerTypeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            TaskWorker workerInstance = (TaskWorker) workerType.newInstance();
            workerInstance.setTarget(workerTarget);
            workerInstance.doWork();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
