package com.senlaCourse.autoservice.entity;

import com.senlaCourse.autoservice.util.StateOrder;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Order implements Serializable, Cloneable {
    private Integer id =0;
    private Integer num;
    private StateOrder stateOrder;
    private Date dateOfOrder;
    private Date dateOfExecution;
    private Date dateOfStart;
    private Float price;
    private Master master;
    private Place place;
    private static Integer count =0;

    public Order(Integer num, Date dateOfOrder, Date dateOfStart, Float price) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.dateOfStart = dateOfStart;
        this.price = price;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfStart);
        calendar.add(Calendar.DATE, 1);
        this.dateOfExecution = calendar.getTime();
        this.id = count++;
    }

    public Order(Integer id, Integer num, Date dateOfOrder, Date dateOfExecution, Date dateOfStart, Float price) {
        this.id = id;
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.dateOfExecution = dateOfExecution;
        this.dateOfStart = dateOfStart;
        this.price = price;
    }

    public Order(Integer num) {
        this.num = num;
        this.id = count++;
    }

    public Order() {

    }
    @Override
    public Order clone() throws CloneNotSupportedException {
        return (Order)super.clone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", stateOrder=").append(stateOrder);
        sb.append(", dateOfOrder=").append(dateOfOrder);
        sb.append(", dateOfExecution=").append(dateOfExecution);
        sb.append(", dateOfStart=").append(dateOfStart);
        sb.append(", price=").append(price);
        sb.append(", place=").append(place);
        sb.append('}');
        return sb.toString();
    }
}
