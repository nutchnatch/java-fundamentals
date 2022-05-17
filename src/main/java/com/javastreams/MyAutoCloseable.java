package com.javastreams;
import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{

    public void saySomething() throws IOException {
        throw new IOException("Exception form saysomething");
//        System.out.println("something");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("Exception form close");
//        System.out.println("close");
    }
}
