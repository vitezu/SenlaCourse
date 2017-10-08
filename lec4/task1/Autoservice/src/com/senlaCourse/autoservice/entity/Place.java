package com.senlaCourse.autoservice.entity;

public class Place {
    private Integer numPlace;
    private Boolean stateFree = true;

    public Place(Integer numPlace, Boolean stateFree) {
        this.numPlace = numPlace;
        this.stateFree = stateFree;
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
