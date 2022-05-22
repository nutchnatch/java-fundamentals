package com.app.execution.environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No file name provided");
            return;
        }

        String filename = args[0];
        if(!Files.exists(Paths.get(filename))) {
            System.out.println("\n File does not exist");
        }
        showFileLines(filename);
    }

    static public void showFileLines(String fileName) {

        try(BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
