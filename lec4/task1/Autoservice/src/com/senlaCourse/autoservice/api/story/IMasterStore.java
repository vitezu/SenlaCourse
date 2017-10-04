package com.senlaCourse.autoservice.api.story;

import com.senlaCourse.autoservice.entity.Master;

import java.util.List;

public interface IMasterStore extends IGeneric<Master>  {


    @Override
    void delete(Master master);

    @Override
    void add(Master master);

    @Override
    List<Master> getAll();
}
