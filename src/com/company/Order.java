package com.company;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
    protected int id;
    protected   enum Status{Draft,confirmed,delivered;}
    protected String review;
    protected int evaluation;
    protected Date createdAt;
    protected Date confirmedAt;
    protected Date deliveredAt;
    protected Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Set<OrderLine> rOrderLine;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        if(evaluation >5) {
            this.evaluation = 5;
        }
        else {
            if(evaluation <0) {
                this.evaluation = 0;
            }else {
                this.evaluation = evaluation;
            }

        }

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Date deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Order(int id,String review, int evaluation, Date createdAt, Date confirmedAt, Date deliveredAt, Status status,Address address) {
        this.id=id;
        this.review = review;
//        this.evaluation = evaluation;
        setEvaluation(evaluation);
        this.createdAt = createdAt;
        this.confirmedAt = confirmedAt;
        this.deliveredAt = deliveredAt;
        this.status = status;
        rOrderLine = new HashSet<OrderLine>();
        addAddress(address);
    }
    //---------relation(one to many ) Client with Order---------------
    private Client rClient;
    public void addClient(Client client){
        if(!client.getOrder().contains(this)){
            if(getClient()!=null){
                removeClient();
            }
            setClient(client);
            client.addOrder(this);
        }
}
    public void removeClient(){
        getClient().removeOrder(this);
        setClient(null);
    }
    public Client getClient(){
        return rClient;
}
    public void setClient(Client client){
        this.rClient=client;
}


//-----------------------------------------------------------------
//-------------relation(one to many ) Order with OrderLine----------------------

    public Order(){
        rOrderLine = new HashSet<OrderLine>();
    }

    public void addOrderLine(OrderLine orderLine){
        if( !getOrderLine().contains(orderLine) ){
            if(orderLine.getOrder() != null) orderLine.removeOrder();
            orderLine.setOrder(this);
            getOrderLine().add(orderLine);
        }
    }
    public void removeOrderLine(OrderLine orderLine){
        if( getOrderLine().contains(orderLine) ) { getOrderLine().remove(orderLine); orderLine.setOrder(null); }
    }
    public Set<OrderLine> getOrderLine(){ return rOrderLine; }
    public void setOrderLine(Set<OrderLine> orderLines){ this.rOrderLine = orderLines; }

//------------------------------------------------------------------------------

    //-----------------------relation(one to many ) DeliveryGuy with Order-------------------------------
    private DeliveryGuy rDeliveryGuy;
    public void addDeliveryGuy(DeliveryGuy deliveryGuy){
        if(!deliveryGuy.getOrder().contains(this)){
            if(getDeliveryGuy() != null) removeDeliveryGuy();
            setDeliveryGuy(deliveryGuy);
            deliveryGuy.addOrder(this);
        }
    }
    public void removeDeliveryGuy(){ getDeliveryGuy().removeOrder(this); setDeliveryGuy(null); }
    public DeliveryGuy getDeliveryGuy(){ return rDeliveryGuy; }
    public void setDeliveryGuy(DeliveryGuy deliveryGuy){ this.rDeliveryGuy = deliveryGuy; }

    //----------------------relation(one to one unidirectionnelle (compostion)  ) Order with Address--------------------
    private Address rAddress;
    public void addAddress(Address address) { setAddress(address); }
    public Address getAddress() { return rAddress; }
    public void setAddress(Address address) { if (address != null) this.rAddress = address; }


}
