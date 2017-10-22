package com.senlaCourse.autoservice.entity;

import java.io.Serializable;

public class Place implements Serializable {
    private Integer id = 0;
    private Integer numPlace;
    private Boolean stateFree;
    private static Integer count = 0;

    public Place(Integer numPlace) {
        this.numPlace = numPlace;
        this.stateFree = true;
        id = count++;
    }

    public Place() {
    }

    public Place(Integer id, Integer numPlace, Boolean stateFree) {
        this.id = id;
        this.numPlace = numPlace;
        this.stateFree = stateFree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumPlace(Integer numPlace) {
        this.numPlace = numPlace;
    }

    public void setStateFree(Boolean stateFree) {
        this.stateFree = stateFree;
    }

    public Integer getNumPlace() {
        return numPlace;
    }

    public Boolean getStateFree() {
        return stateFree;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Place{");
        sb.append("id=").append(id);
        sb.append(", numPlace=").append(numPlace);
        sb.append(", stateFree=").append(stateFree);
        sb.append('}');
        return sb.toString();
    }
}
