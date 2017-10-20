package com.senlaCourse.autoservice.entity;

import java.io.Serializable;

public class Place implements Serializable {
    private Integer numPlace;
    private Boolean stateFree;

    public Place(Integer numPlace) {
        this.numPlace = numPlace;
        this.stateFree = true;
    }
    public Place() {
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
        sb.append("numPlace=").append(numPlace);
        sb.append(", stateFree=").append(stateFree);
        sb.append('}');
        return sb.toString();
    }
}
