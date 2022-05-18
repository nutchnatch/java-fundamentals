package com.javastreams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.net.URI;
//import java.nio.charset.Charset;

public class ZipFileSystem {

    public static void main(String[] args) {
        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };

        try(FileSystem zips = openZip(Paths.get("myData.zip"))) {
            copyZip(zips);
            writeToFileInZip1(zips, data);
            writeToFileInZip2(zips, data);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providersProps = new HashMap<>();
        providersProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri, providersProps);
        return  zipFs;
    }

    private static void copyZip(FileSystem zipFs) throws IOException {
        Path sourceFile = Paths.get("file1.txt");
//        Path sourceFile = FileSystems.getDefault().getPath("file1.txt");
        Path destFile = zipFs.getPath("/file1copied.txt");
        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Traditional way
     * @param zipFs
     * @param data
     * @throws IOException
     */
    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {
        try(BufferedWriter bw = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))) {
            for(String d: data) {
                bw.write(d);
                bw.newLine();
            }
        }
    }

    /**
     * Recent way
     * @param zipFs
     * @param data
     * @throws IOException
     */
    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }
}
