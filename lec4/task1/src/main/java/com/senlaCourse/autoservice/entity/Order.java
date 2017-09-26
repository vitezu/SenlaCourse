package com.senlaCourse.autoservice.entity;

import com.senlaCourse.autoservice.service.StateOrder;
import java.util.Date;

public class Order {
    private Integer num;
    private StateOrder stateOrder;
    private Date dateOfOrder;
    private Date dateOfEnd;
    private Date dateOfPlaningEnd;
    private Float price;

    public  Order(Integer num, Date dateOfOrder, Date dateOfPlaningEnd, Float price) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.dateOfPlaningEnd = dateOfPlaningEnd;
        this.price = price;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public void setDateOfPlaningEnd(Date dateOfPlaningEnd) {
        this.dateOfPlaningEnd = dateOfPlaningEnd;
    }

    public StateOrder getStateOrder() {
        return stateOrder;
    }
    public void setStateOrder(StateOrder stateOrder) {
        this.stateOrder = stateOrder;
    }
    public Integer getNum() {
        return num;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public Date getDateOfPlaningEnd() {
        return dateOfPlaningEnd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("num=").append(num);
        sb.append(", stateOrder=").append(stateOrder);
        sb.append(", dateOfOrder=").append(dateOfOrder);
        sb.append(", dateOfEnd=").append(dateOfEnd);
        sb.append(", dateOfPlaningEnd=").append(dateOfPlaningEnd);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
