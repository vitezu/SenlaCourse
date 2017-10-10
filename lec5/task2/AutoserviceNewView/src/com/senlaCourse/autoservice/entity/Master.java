package com.senlaCourse.autoservice.entity;

public class Master {

    private String name;
    private Boolean stateFree;
    private Order order;

    public Master(String name) {
        this.name = name;
        this.stateFree = true;
    }

    public Master() {
    }

    public void setOrder(Order order) {
        this.order = order;
        stateFree = false;
    }

    public String getName() {
        return name;
    }

    public Boolean getStateFree() {
        return stateFree;
    }

    public Order getOrder() {
        return order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStateFree(Boolean stateFree) {
        this.stateFree = stateFree;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Master{");
        sb.append("name='").append(name).append('\'');
        sb.append(", stateFree=").append(stateFree);
        sb.append('}');
        return sb.toString();
    }
}
