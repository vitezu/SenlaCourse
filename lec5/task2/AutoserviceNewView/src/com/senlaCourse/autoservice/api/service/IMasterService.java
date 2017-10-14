package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;

import java.util.List;

public interface IMasterService {

    void addMaster(Master master);

    void deleteMaster (Master master);

    List<Master>sortByNameOfMaster();

    List<Master> sortByStateFree ();

    List<Master> getMasterStore ();

    List<Master> getFreeMasters ();

    Master getMasterExecuteOrder (Order order);
}
