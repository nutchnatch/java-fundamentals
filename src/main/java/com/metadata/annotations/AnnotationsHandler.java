package com.metadata.annotations;

import com.reflections.BankAccount;
import com.reflections.TaskWorker;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnnotationsHandler {

    public static void main(String[] args) throws Exception {
        AnnotationsHandler annotationsHandler = new AnnotationsHandler();
        BankAccount ba = new BankAccount(20, "my_ba");
//        annotationsHandler.startWork("com.reflections.AccountWorker", ba);
        annotationsHandler.startWorkSelfContained(ba);
    }

    private ExecutorService es = Executors.newFixedThreadPool(5);

    void startWork(String workerTypeName, Object workerTarget) throws Exception {
        Class<?> workerType = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);
        WorkHandler workHandler = workerType.getAnnotation(WorkHandler.class);
        if(workHandler == null) {
            throw new Exception("Class must be annotated with WorkerHandler annotation.");
        }
//        if(workHandler.useThreadPool()) {
        if(workHandler.value()) {
            es.submit(() -> {
                System.out.println("Executing into thread pool");
                worker.doWork();
            });
        } else {
            worker.doWork();
        }
    }

    void startWorkSelfContained(Object workerTarget) throws Exception, IOException, InstantiationException, IllegalAccessException {
        Class<?> targetType = workerTarget.getClass();
        ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
        Class<?> workerType = pb.value();
        TaskWorker workerClass = (TaskWorker) workerType.newInstance();

        WorkHandler workHandler = workerType.getAnnotation(WorkHandler.class);
        if(workHandler == null) {
            throw new Exception("Class must be annotated with WorkerHandler annotation.");
        }
        if(workHandler.value()) {
            es.submit(() -> {
                System.out.println("Executing into thread pool");
                workerClass.doWork();
            });
        } else {
            workerClass.doWork();
        }
    }
}
