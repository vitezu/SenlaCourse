//package com.senlaCourse.autoservice.util;
//
//import com.danco.training.TextFileWorker;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class WriterReaderFile {
//    String[] arrayPlaces = new String[placeStore.getPlaces().size()];
//        for (int i = 0; i < placeStore.getPlaces().size(); i++) {
//        arrayPlaces[i] = String.valueOf(placeStore.getPlaces().get(i));
//    }
//
//    String[] arrayMasters = new String[masterStore.getMasters().size()];
//        for (int i = 0; i < masterStore.getMasters().size(); i++) {
//        arrayMasters[i] = String.valueOf(masterStore.getMasters().get(i));
//    }
//
//    String[] arrayOrders = new String[orderStore.getOrders().size()];
//        for (int i = 0; i < orderStore.getOrders().size(); i++) {
//        arrayOrders[i] = String.valueOf(orderStore.getOrders().get(i));
//    }
//
//    //Test write/rea file
//    final String TEST_FILE = args[0];
//    final String[] testValues = arrayOrders;
//
//    // Create new file
//    Path filePath = Paths.get(TEST_FILE);
//        if (!Files.exists(filePath)){
//        Files.createFile(filePath);
//    }
//
//    // Work example
//        try {
//        TextFileWorker fileWorker = new TextFileWorker(TEST_FILE);
//        fileWorker.writeToFile(testValues);
//        Object[] readedValues = fileWorker.readFromFile();
//        for (Object s : readedValues) {
//            System.out.println(s);
//        }
//
//        // Check result
//        for (int i = 0; i < testValues.length; i++) {
//
//            if (!readedValues[i].equals(testValues[i])) {
//                throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + testValues[i]);
//            }
//        }
//    } finally {
////            Files.deleteIfExists(filePath);
//    }
//
//}
