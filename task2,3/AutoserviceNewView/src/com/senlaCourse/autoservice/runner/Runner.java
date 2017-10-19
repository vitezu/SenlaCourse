package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.serialization.Serialization;

public class Runner {

    public static void main(String[] args) throws Exception {
        Master master = new Master("Pavel");
        Serialization ser = new Serialization();
        ser.serialize(master);
        ser.deserialize();
    }
}



