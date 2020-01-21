package com.tools.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tools.business.DataFileManager;
import com.tools.conf.Configuration;

public class Util {

    public static Path getPathInput() {
        return Paths.get(System.getProperty("user.dir").concat(Configuration.pathInput));
    }

    public static Path getPathOutput() {
        return Paths.get(System.getProperty("user.dir").concat(Configuration.pathOutput));
    }

    public static Path getPathOutputFile(String filename) {
        return Paths.get(System.getProperty("user.dir")
            .concat(Configuration.pathOutput)
            .concat(filename)
            .concat(Configuration.extensionFIleProcessed));
    }

    public static void createPathStructure() throws IOException {

        if (!Files.exists(Util.getPathInput())) {
            Files.createDirectory(getPathInput());
        }

        if (!Files.exists(Util.getPathOutput())) {
            Files.createDirectory(Util.getPathOutput());
        }

    }

    public static void readFilesAlreadyAdded() throws IOException {

        DataFileManager fileManager = new DataFileManager();

        Files.list(getPathInput())
            .filter(path -> IsNotProcessed(path))
            .forEach(path -> fileManager.transFormatFile(path.toString(), path.getFileName().toString()));

    }

    private static Boolean IsNotProcessed(Path path) {
        final String file = path.getFileName().toString()
            .replace(Configuration.extensionFIle, Configuration.extensionFIleProcessed);
        return Files.notExists(Util.getPathOutputFile(file));
    }
}
