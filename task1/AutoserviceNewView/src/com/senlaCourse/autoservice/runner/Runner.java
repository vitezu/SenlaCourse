package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.util.csv.CsvUtil;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws Exception {
        Master master1 = new Master("Pavel");
        Master master2 = new Master("Oleg");
        ControllerImpl.getInstance().addMaster(master1);
        ControllerImpl.getInstance().addMaster(master2);

        String csvFile = "master.csv";
        FileWriter writer = new FileWriter(csvFile);

        List<Master> masters = ControllerImpl.getInstance().getMasterStore();

        //for header
        CsvUtil.writeLine(writer, Arrays.asList("id", "name", "StateFree", "order"));

        for (Master d : masters) {

            List<String> list = new ArrayList<>();
            list.add(d.getId().toString());
            list.add(d.getName());
            list.add(String.valueOf(d.getStateFree()));

            CsvUtil.writeLine(writer, list);

            //try custom separator and quote.
            //CSVUtils.writeLine(writer, list, '|', '\"');
        }

        writer.flush();
        writer.close();

    }

}





