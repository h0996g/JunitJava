package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Client {


    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String phoneNumber;
    protected String profilePhotoPath;
    private Set<Order> rOrder;

<<<<<<< HEAD
    public Set<Order> getrOrder() {
        return rOrder;
    }

    public void setrOrder(Set<Order> rOrder) {
        this.rOrder = rOrder;
    }
=======
>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f


    public Client(int id ,String firstName, String lastName, String email, String password, String phoneNumber, String profilePhotoPath) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profilePhotoPath = profilePhotoPath;
        rOrder=new HashSet<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
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

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }




    //relation(one to many ) Client with Order
    public Client(){
        rOrder=new HashSet<>();
    }
    public Set<Order> getOrder(){
        return rOrder;
    }

    public void addOrder(Order order){
        if(!getOrder().contains(order)){
            if(order.getClient() != null){
                order.removeClient();
            }
            order.setClient(this);
            getOrder().add(order);
        }
    }
    public void removeOrder(Order order){
        if(getOrder().contains(order)){
            getOrder().remove(order);
            order.setClient(null);
        }
    }
    public void setOrder(Set<Order> order){
        this.rOrder=order;
    }

    //    ----------------------------Function
    public void updatePassword (String oldPassword ,String newPassword) {
        if(this.password == oldPassword) {
            if(newPassword.length()>5) {
                this.password = newPassword;
            }
        }
    }
    //    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//            "[a-zA-Z0-9_+&*-]+)*@" +
//            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//            "A-Z]{2,7}$";
    public void updateClient(String firstName,String lastName,String email,String phoneNumber,String profilePhotoPath){
//        if(!validateEmail(email)){
//           return;
//        }
        if(!(firstName.isEmpty()&&lastName.isEmpty()&&email.isEmpty()&&phoneNumber.isEmpty()&&profilePhotoPath.isEmpty())){
            this.firstName=firstName;
            this.lastName=lastName;
            this.email=email;
            this.phoneNumber=phoneNumber;
            this.profilePhotoPath=profilePhotoPath;
        }
    }

    public boolean validateEmail(String email ){
        if(email==null || email.isEmpty()){
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern=Pattern.compile(emailRegex);
        if(pattern.matcher(email).matches()){
            return true;
        }else {
            return false;
        }

<<<<<<< HEAD
    }
=======
   }
    public void createOrder(Order order){
        getOrder().add(order);
    }
    public void confirmOrder(Order order){
        order.setStatus(Order.Status.confirmed);
    }
    public void review (Order order, String review){
        order.setReview(review);
    }
    public void updateClient( String firstname, String lastname, String email, String password, String phone_number, String profil_photo_path) {
        if(!(firstname.isEmpty()&&lastname.isEmpty()&&email.isEmpty()&&phone_number.isEmpty()&&profil_photo_path.isEmpty())){
            setFirstName(firstname);
            setLastName(lastname);setEmail(email);setPassword(password);setPhoneNumber(phone_number);setProfilePhotoPath(profil_photo_path);
        }else{System.out.println("Emptyyy");}}

>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f



}