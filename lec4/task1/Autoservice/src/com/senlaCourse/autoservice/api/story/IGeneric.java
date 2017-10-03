package com.senlaCourse.autoservice.api.story;

public interface IGeneric <T> {
    void delete(T t);

    void add(T t);

}
