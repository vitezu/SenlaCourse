
package com.senlaCourse.autoservice.writerReader;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class  WriteObjectToFile<T>  {
        final String DIRECTORY = "E:\\Java homework\\SenlaCourse-lec4\\lec4\\task1\\src\\main\\java\\com\\senlaCourse\\"
                + "autoservice\\files\\";

        public void writeToFile(final String nameFile, List<T> objects) {
                    try {
                            final FileOutputStream fos = new FileOutputStream(DIRECTORY + nameFile);
                            final ObjectOutputStream oos = new ObjectOutputStream(fos);

                        for (int i = 0; i < objects.size(); i++) {
                            if (objects.get(i) != null) {
                                oos.writeObject(objects.get(i));
                            }
                        }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(WriteObjectToFile.class.getName()).log(Level.SEVERE, null, ex);

                    } catch (IOException ex) {
                        Logger.getLogger(WriteObjectToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

