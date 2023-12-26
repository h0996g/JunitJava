package com.company;

public class Agenttest {
    protected int AGENT_ID;
    protected String FIRST_NAME;
    protected String LAST_NAME;
    protected String EMAIL;
    protected String PASSWORD;
    protected String PHONE_NUMBER;
    protected String IPADDRESS;





    public Agenttest(int AGENT_ID, String FIRST_NAME, String LAST_NAME, String EMAIL, String PASSWORD, String PHONE_NUMBER, String IPADDRESS) {
        this.AGENT_ID = AGENT_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.IPADDRESS = IPADDRESS;
    }

    public Agenttest() {

    }

    public int getAGENT_ID() {
        return AGENT_ID;
    }

    public void setAGENT_ID(int id) {
        this.AGENT_ID = id;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String firstName) {
        this.FIRST_NAME = firstName;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String lastName) {
        this.LAST_NAME = lastName;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String email) {
        this.EMAIL = email;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String password) {
        this.PASSWORD = password;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(String phoneNumber) {
        this.PHONE_NUMBER = phoneNumber;
    }

    public String getIPADDRESS() {
        return IPADDRESS;
    }

    public void setIPADDRESS(String ipAddress) {
        this.IPADDRESS = ipAddress;
    }

    // Function
    public void updatePassword (String oldPassword ,String newPassword) {
        if(this.PASSWORD == oldPassword) {
            if(newPassword.length()>5) {
                this.PASSWORD = newPassword;
            }
        }
    }
    public void updateAgent(String firstName,String lastName,String email,String phoneNumber,String ipAddress){

        if(!(firstName.isEmpty()&&lastName.isEmpty()&&email.isEmpty()&&phoneNumber.isEmpty()&&ipAddress.isEmpty())){
            this.FIRST_NAME =firstName;
            this.LAST_NAME =lastName;
            this.EMAIL =email;
            this.PHONE_NUMBER =phoneNumber;
            this.IPADDRESS =ipAddress;
        }
    }


}