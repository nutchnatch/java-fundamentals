package com.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

public class ManageTypeReference {

    public static void main(String[] args) throws ClassNotFoundException {
        ManageTypeReference reference = new ManageTypeReference();
        BankAccount account = new BankAccount(10,"1234");
        reference.showName(BankAccount.class);
        reference.doWork(account);

        Class<?> thisClass = Class.forName("com.reflections.BankAccount");
        reference.showName(thisClass);
        Class<BankAccount> anotherClass = BankAccount.class;
        reference.showName(anotherClass);

        HighVolumeAccount volumeAccount = new HighVolumeAccount(10, "1235");
        reference.classInfo(volumeAccount);
        reference.typeModifiers(volumeAccount);
        reference.fieldInfo(volumeAccount);
        reference.methodInformation(volumeAccount);
        reference.methodInfo2(volumeAccount);
        reference.callGetId(volumeAccount);
        reference.callDeposit(account, 20);
        System.out.println(account.getBalance()); // 10 + 20 = 30
    }

    void showName(Class<?> className) {
        System.out.println(className.getSimpleName());
    }

    void doWork(Object obj) {
        Class<?> thisClass = obj.getClass();
        showName(thisClass);
    }

    void classInfo(Object object) {
        Class<?> thisClass = object.getClass();
        System.out.println(thisClass.getSimpleName());
        Class<?> superClass = thisClass.getSuperclass();
        System.out.println(superClass.getSimpleName());

        Class<?>[] interfaces = thisClass.getInterfaces();
        for(Class<?> classInterface: interfaces) {
            System.out.println(classInterface.getSimpleName());
        }
    }

    void typeModifiers(Object object) {
        Class<?> thisClass = object.getClass();
        int modifiers = thisClass.getModifiers();
        if((modifiers & Modifier.FINAL) > 0) {
            System.out.println("bitwise check - final");
        }

        if(Modifier.isFinal(modifiers)) {
            System.out.println("bitwise check - final");
        }
        if(Modifier.isPrivate(modifiers)) {
            System.out.println("bitwise check - private");
        }
        if(Modifier.isProtected(modifiers)) {
            System.out.println("bitwise check - protected");
        }
        if(Modifier.isPublic(modifiers)) {
            System.out.println("bitwise check - public");
        }
    }

    void fieldInfo(Object object) {
        Class<?> thisClass = object.getClass();
        Field[] fields = thisClass.getFields();
        displayFields(fields);
        Field[] declaredFields = thisClass.getDeclaredFields();
        displayFields(declaredFields);
    }

    void displayFields(Field[] fields) {
        for(Field field: fields) {
            System.out.println(field.getName() + ":" + field.getType());
        }
    }

    void methodInformation(Object object) {
        Class<?> thisClass = object.getClass();
        Method[] methods = thisClass.getMethods();
        Method[] declaredMethods = thisClass.getDeclaredMethods();
        for(Method method: declaredMethods) {
            System.out.println(method.getName());
        }
        for(Method method: methods) {
            System.out.println(method.getName());
        }
    }

    void methodInfo2(Object object) {
        Class<?> thisClass = object.getClass();
        Method[] methods = thisClass.getMethods();
        for(Method method: methods) {
            if(method.getDeclaringClass() != Object.class) {
                System.out.println(method.getName());
            }
            System.out.println(method.getName());
        }
    }

    void callGetId(Object object) {
        Class<?> thisClass = object.getClass();
        try {
            Method getId = thisClass.getMethod("getId");
            Object result = getId.invoke(object);
            System.out.println(result);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    void callDeposit(Object object, int amount) {
        Class<?> thisClass = object.getClass();
        try {
            Method deposit = thisClass.getMethod("deposit", int.class);
            deposit.invoke(object, amount);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
