package com.company;

public class Agent {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String phoneNumber;
    protected String ipAddress;





    public Agent(int id,String firstName, String lastName, String email, String password, String phoneNumber, String ipAddress) {
       this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.ipAddress = ipAddress;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    // Function
    public void updatePassword (String oldPassword ,String newPassword) {
        if(this.password == oldPassword) {
            if(newPassword.length()>5) {
                this.password = newPassword;
            }
        }
    }
    public void updateAgent(String firstName,String lastName,String email,String phoneNumber,String ipAddress){

        if(!(firstName.isEmpty()&&lastName.isEmpty()&&email.isEmpty()&&phoneNumber.isEmpty()&&ipAddress.isEmpty())){
            this.firstName=firstName;
            this.lastName=lastName;
            this.email=email;
            this.phoneNumber=phoneNumber;
            this.ipAddress=ipAddress;
        }
    }

    public void createClient(int id, String firstname, String lastname, String email, String password, String phone_number, String profil_photo_path) {
        Client client = new Client(id, firstname, lastname, email, password, phone_number, profil_photo_path);
    }
    public void createDeliveryGuy(int id, String firstname, String lastname, String email, String password, String phone_number, String status) {
        Client client = new Client(id, firstname, lastname, email, password, phone_number, status);
    }

    public void createItem(int id, String name, String description, int price) {
        Item item = new Item(id, name, description, price);
    }
    public void updateAgent( String firstname, String lastname, String email, String password, String phone_number, String ipAddress) {
        if(!(firstname.isEmpty()&&lastname.isEmpty()&&email.isEmpty()&&phone_number.isEmpty()&&ipAddress.isEmpty())){
            setFirstName(firstname);setLastName(lastname);setEmail(email);setPassword(password);setPhoneNumber(phone_number);setIpAddress(ipAddress);
        }else{System.out.println("Emptyyy");}
    }


}
