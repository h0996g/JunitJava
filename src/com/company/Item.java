package com.company;

import java.util.HashSet;
import java.util.Set;

public class Item {
    protected int id;
    protected String name;
    protected String description;
    protected double price;
    private Set<OrderLine> rOrderLine;



    public Item(int id,String name, String description, double price) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        rOrderLine = new HashSet<OrderLine>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemId() {
        return 0;
    }


    //relation(one to many ) Item with OrderLine
//    public Item(){ rOrderLine = new HashSet<OrderLine>();}
//    public void addOrderLine(OrderLine orderLine){
//        if( !getOrderLine().contains(orderLine) ){
//            if(orderLine.getItem() != null)
//            {
//                orderLine.removeItem();
//            }
//            orderLine.setItem(this);
//            getOrderLine().add(orderLine);
//        }
//    }
//    public void removeOrderLine(OrderLine orderLine){
//        if( getOrderLine().contains(orderLine) ) { getOrderLine().remove(orderLine); orderLine.setItem(null); }
//    }
//    public Set<OrderLine> getOrderLine(){ return rOrderLine; }
//    public void setOrderLine(Set<OrderLine> orderLines){ this.rOrderLine = orderLines; }
//
}