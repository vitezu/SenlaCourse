package com.senlaCourse.autoservice.entity;

import java.io.Serializable;

public class Master implements Serializable {
    private String name;
    private Boolean stateFree;
    private Order order;

    public Master(String name, Boolean stateFree) {
        this.name = name;
        this.stateFree = stateFree;
    }

    public void setOrder (Order order) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Master{");
        sb.append("name='").append(name).append('\'');
        sb.append(", stateFree=").append(stateFree);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
