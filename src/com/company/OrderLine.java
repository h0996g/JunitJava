package com.company;

public class OrderLine {

    protected int quantity;
    protected String photoFilePath;
    private Order rOrder;
    private Item rItem;

<<<<<<< HEAD
    public Item getrItem() {
        return rItem;
    }

    public void setrItem(Item rItem) {
        this.rItem = rItem;
    }

    public Order getrOrder() {
        return rOrder;
    }

    public void setrOrder(Order rOrder) {
        this.rOrder = rOrder;
    }
=======

>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f

    public OrderLine(int quantity, String photoFilePath) {
        this.quantity = quantity;
        this.photoFilePath = photoFilePath;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }

<<<<<<< HEAD



    public Item getItem() {return rItem;}
    public void setItem(Item item) {
        this.rItem = item;
    }
    public void addItem(Item item) {
        this.setItem(item);
    }
    public void removeItem(Item item) {
        this.setItem(null);
    }








}
=======


//    ---------relation(one to many ) Order with OrderLine--------
//
//    public void addOrder(Order order){
//        if(!order.getOrderLine().contains(this)){
//            if(getOrder() != null)
//            {
//                removeOrder();
//            }
//            setOrder(order);
//            order.addOrderLine(this);
//        }
//    }
//    public void removeOrder(){ getOrder().removeOrderLine(this); setOrder(null); }
//    public Order getOrder(){ return rOrder; }
//    public void setOrder(Order order){ this.rOrder = order; }

//    -----------------------------------------------------------------
//    ---------relation(one to many ) Item with OrderLine--------

    public Item getItem() {return rItem;}
    public void setItem(Item item) {
        this.rItem = item;
    }
    public void addItem(Item item) {
        this.setItem(item);
    }
    public void removeItem(Item item) {
        this.setItem(null);
    }




//    public void addItem(Item item){
////        if(!item.getOrderLine().contains(this)){
////            if(getItem() != null) removeItem();
//            setItem(item);
////            item.addOrderLine(this);
////        }
//    }
//    public void removeItem(){ getItem().removeOrderLine(this); setItem(null); }
//    public Item getItem(){ return rItem; }
//    public void setItem(Item item){ this.rItem = item; }




}
>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f
