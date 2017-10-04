package com.senlaCourse.autoservice.api.story;

import java.util.List;

public interface IGeneric <T> {

    void delete(T t);

    void add(T t);

    List<T> getAll();

}
