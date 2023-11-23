package com.company;

public class OrderLine {

    protected int quantity;
    protected String photoFilePath;
    private Order rOrder;
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

    public OrderLine(int quantity, String photoFilePath) {
        this.quantity = quantity;
        this.photoFilePath = photoFilePath;
    }


//    ---------relation(one to many ) Order with OrderLine--------

    public void addOrder(Order order){
        if(!order.getOrderLine().contains(this)){
            if(getOrder() != null)
            {
                removeOrder();
            }
            setOrder(order);
            order.addOrderLine(this);
        }
    }
    public void removeOrder(){ getOrder().removeOrderLine(this); setOrder(null); }
    public Order getOrder(){ return rOrder; }
    public void setOrder(Order order){ this.rOrder = order; }

//    -----------------------------------------------------------------
//    ---------relation(one to many ) Item with OrderLine--------
private Item rItem;
    public void addItem(Item item){
        if(!item.getOrderLine().contains(this)){
            if(getItem() != null) removeItem();
            setItem(item);
            item.addOrderLine(this);
        }
    }
    public void removeItem(){ getItem().removeOrderLine(this); setItem(null); }
    public Item getItem(){ return rItem; }
    public void setItem(Item item){ this.rItem = item; }
}
