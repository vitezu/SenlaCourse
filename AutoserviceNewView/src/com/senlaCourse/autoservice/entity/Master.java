package com.senlaCourse.autoservice.entity;

import com.senlaCourse.annotation.config.ConfigProperty;

import java.io.Serializable;

public class Master implements Serializable {
    @ConfigProperty(configName = "Annotation\\resources\\configForAnnot.properties", propertyName = "master.id", type = Integer.class)
    private Integer id = 0;
    @ConfigProperty(configName = "Annotation\\resources\\configForAnnot.properties", propertyName = "master.name", type = String.class)
    private String name;
    @ConfigProperty(configName = "Annotation\\resources\\configForAnnot.properties", propertyName = "master.stateFree", type = Boolean.class)
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
        sb.append("id=").append(id).append('\'');
        sb.append(", name=").append(name).append('\'');
        sb.append(", stateFree=").append(stateFree);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
