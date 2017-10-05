package com.senlaCourse.autoservice.entity;

import com.senlaCourse.autoservice.util.StateOrder;

import java.util.Date;

public class Order {
    private Integer num;
    private StateOrder stateOrder;
    private Date dateOfOrder;
    private Date dateOfExecution;
    private Date dateOfPlaningExecution;
    private Float price;

    public Order(Integer num, Date dateOfOrder, Date dateOfPlaningExecution, Float price) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.dateOfPlaningExecution = dateOfPlaningExecution;
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public StateOrder getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(StateOrder stateOrder) {
        this.stateOrder = stateOrder;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Date getDateOfEnd() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public Date getDateOfPlaningEnd() {
        return dateOfPlaningExecution;
    }

    public void setDateOfPlaningEnd(Date dateOfPlaningExecution) {
        this.dateOfPlaningExecution = dateOfPlaningExecution;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("num=").append(num);
        sb.append(", stateOrder=").append(stateOrder);
        sb.append(", dateOfOrder=").append(dateOfOrder);
        sb.append(", dateOfExecution=").append(dateOfExecution);
        sb.append(", dateOfPlaningExecution=").append(dateOfPlaningExecution);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
