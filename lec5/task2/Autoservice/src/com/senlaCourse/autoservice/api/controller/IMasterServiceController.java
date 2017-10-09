package com.senlaCourse.autoservice.api.controller;

import com.senlaCourse.autoservice.entity.Master;

import java.util.List;

public interface IMasterServiceController {

    void sortByNameOfMaster();

    void sortByStateFree();

    List<Master> getAllMasters();
}
