package com.senlaCourse.autoservice.api.story;

import com.senlaCourse.autoservice.entity.Master;

public interface IMasterStore extends IGeneric<Master>  {


    @Override
    void delete(Master master);

    @Override
    void add(Master master);
}
