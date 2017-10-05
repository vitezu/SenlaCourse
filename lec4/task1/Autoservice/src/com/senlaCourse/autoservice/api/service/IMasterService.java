package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Master;

import java.util.List;

public interface IMasterService {

    void addMaster(Master master);

    void deleteMaster (Master master);

    void sortByNameOfMaster();

    void sortByStateFree ();

    List<Master> getMasterStore ();
}
