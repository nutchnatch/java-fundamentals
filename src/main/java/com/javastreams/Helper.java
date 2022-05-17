package com.javastreams;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

    static public Reader openReader(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName));
    }

    static public Writer openWriter(String filename) throws IOException {
        return Files.newBufferedWriter(Paths.get(filename));
    }
}
