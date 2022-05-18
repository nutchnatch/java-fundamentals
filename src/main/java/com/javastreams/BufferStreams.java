package com.javastreams;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BufferStreams {

    public static void main(String[] args) throws IOException {
//        readFata();
//        String[] strArr = new String[] {"Hello", "World"};
//        writeData(strArr);
//        bufferStream();
        readThemAll();
    }

    static public void bufferStream() {
        try(BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            int intVal;
            while((intVal = br.read()) >= 0) {
                char charVal = (char) intVal;
                System.out.println(intVal);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void writeData(String[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("file3.txt"))) {
            for(String d: data) {
                bw.write(d);
                bw.newLine();
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void readLine() {
        try(BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void readFata() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("file1.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void readThemAll() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("file1.txt"));
        for(String line: lines) {
            System.out.println(line);
        }
    }
}
