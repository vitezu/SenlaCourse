package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IMasterServiceController;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.MasterServiceImpl;

import java.util.List;

public class MasterServiceController implements IMasterServiceController {

    @Override
    public void sortByNameOfMaster() {
        MasterServiceImpl.getInstance().sortByNameOfMaster();
    }

    @Override
    public void sortByStateFree() {
        MasterServiceImpl.getInstance().sortByStateFree();
    }

    @Override
    public List<Master> getAllMasters() {
        List<Master> masters = MasterServiceImpl.getInstance().getMasterStore();
        for (Master master : masters) {
            System.out.println(master);
        }
        return masters;
    }
}
