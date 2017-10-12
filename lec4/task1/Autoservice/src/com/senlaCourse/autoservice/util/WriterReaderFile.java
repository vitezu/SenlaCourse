package com.senlaCourse.autoservice.util;

import com.danco.training.TextFileWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriterReaderFile {
    private TextFileWorker fileWorker;

    public void writeToFile(String file, String[] objects) {
        Path filePath = Paths.get(file);
            if (!Files.exists(filePath)) {
                try {
                    Files.createFile(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        fileWorker = new TextFileWorker(file);
        fileWorker.writeToFile(objects);
    }

    public List<Object> readFromFile() {
        List<Object> objects = new ArrayList<Object>();
        return objects = Arrays.asList(fileWorker.readFromFile());
    }
}
