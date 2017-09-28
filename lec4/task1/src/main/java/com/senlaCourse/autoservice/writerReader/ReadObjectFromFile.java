package com.senlaCourse.autoservice.writerReader;

import com.senlaCourse.autoservice.running.Runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadObjectFromFile<T> {
    final String DIRECTORY = "E:\\Java homework\\SenlaCourse-lec4\\lec4\\task1\\src\\main\\java\\com\\senlaCourse\\"
            + "autoservice\\files\\";
    public void readFromFile( String fileName, List<T> objects) {

                      try (FileInputStream fin = new FileInputStream(DIRECTORY+fileName)){
                        ObjectInputStream ois = new ObjectInputStream(fin);

                               for (int i = 0; i < objects.size(); i++) {
                                T object = (T) ois.readObject();
                               System.out.println(object);
                            }

                            } catch (FileNotFoundException ex) {
                       Logger.getLogger(Runner.class.getName())
                                        .log(Level.SEVERE, null, ex);
                   } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Runner.class.getName())
                                        .log(Level.SEVERE, null, ex);
                    }
            }
 }