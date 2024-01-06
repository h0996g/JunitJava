package com.company;

import java.util.HashSet;
import java.util.Set;

public class DeliveryGuy {
    int id;
    public enum Status{
        active,inactive;
    }
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String phoneNumber;
    protected Status status;

    public DeliveryGuy(int id,String firstName, String lastName, String email, String password, String phoneNumber, Status status) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;
        rOrder = new HashSet<Order>();
    }


    public String getFirstName() {
        return firstName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    //-----------------------relation(one to many ) DeliveryGuy with Order-------------------------------
    private Set<Order> rOrder;

    public Set<Order> getrOrder() {
        return rOrder;
    }

    public void setrOrder(Set<Order> rOrder) {
        this.rOrder = rOrder;
    }

    public DeliveryGuy(){ rOrder = new HashSet<>();}
    public void addOrder(Order order){
        if( !getOrder().contains(order) ) {
            if (order.getDeliveryGuy() != null)
            {
                order.removeDeliveryGuy();
            }
            order.setDeliveryGuy(this);
            getOrder().add(order);
        }
    }

    public void removeOrder(Order order){
        if( getOrder().contains(order) ) { getOrder().remove(order); order.setDeliveryGuy(null); }
    }
    public Set<Order> getOrder(){ return rOrder; }
    public void setOrder(Set<Order> order){ this.rOrder = order; }


    // Function
    public void updatePassword (String oldPassword ,String newPassword) {
        if(this.password == oldPassword) {
            if(newPassword.length()>5) {
                this.password = newPassword;
            }
        }
    }
    public void updateAgent(String firstName,String lastName,String email,String phoneNumber,String ipAddress,Status status){

        if(!(firstName.isEmpty()&&lastName.isEmpty()&&email.isEmpty()&&phoneNumber.isEmpty()&&ipAddress.isEmpty())){
            this.firstName=firstName;
            this.lastName=lastName;
            this.email=email;
            this.phoneNumber=phoneNumber;
            this.status=status;
        }
    }

}
