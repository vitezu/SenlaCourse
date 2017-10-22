package com.senlaCourse.autoservice.entity;

import java.io.Serializable;

public class Master implements Serializable {
    private Integer id = 0;
    private String name;
    private Boolean stateFree;
    private Order order;
    private static Integer count = 0;

    public Master(String name) {
        this.name = name;
        this.stateFree = true;
        id = count++;
    }

    public Master(Integer id, String name, Boolean stateFree) {
        this.id = id;
        this.name = name;
        this.stateFree = stateFree;
    }

    public Master() {
    }

    public void setOrder(Order order) {
        this.order = order;
        stateFree = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        sb.append("id='").append(id).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", stateFree=").append(stateFree);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
