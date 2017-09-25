package com.senlaCourse.autoservice.control;

import com.senlaCourse.autoservice.repairs.Master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer num;
    private StateOrder  stateOrder;
    private Date dateOfOrder;
    private Date dateOfEnd;
    private Date dateOfPlaningEnd;
    private Float price;
    private List<Master> masters = new ArrayList<Master>();

    public  Order(Integer num, Date dateOfOrder, Date dateOfEnd, Date dateOfPlaningEnd, Float price) {
        this.num = num;
        this.dateOfOrder = dateOfOrder;
        this.dateOfEnd = dateOfEnd;
        this.dateOfPlaningEnd = dateOfPlaningEnd;
        this.price = price;
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
    public void setMaster (Master master) {
        masters.add(master);
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
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
        sb.append(", masters=").append(masters);
        sb.append('}');
        return sb.toString();
    }
}
