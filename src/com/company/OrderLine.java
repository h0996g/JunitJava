package com.company;

public class OrderLine {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;

    protected int quantity;
    protected String photoFilePath;
    private Order rOrder;
    private Item rItem;

    public OrderLine() {

    }

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

    public OrderLine(int quantity, String photoFilePath) {
        this.id = id;

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