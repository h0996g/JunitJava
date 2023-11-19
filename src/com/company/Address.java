package com.company;

public class Address {
    protected int id;
    protected String street;
    protected String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String postalCode;
    protected String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    //----------------------relation(one to one unidirectionnelle (compostion)  ) Address with GeoPosition--------------------
private  GeoPosition rGeoPosition;
    public Address(int id,String street, String city, String postalCode, String country,GeoPosition geoPosition) {
        this.id=id;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        addGeoPosition(geoPosition);
    }

    public void addGeoPosition(GeoPosition geoPosition) { setGeoPosition(geoPosition);

    }
    public GeoPosition getGeoPosition() { return rGeoPosition; }
    public void setGeoPosition(GeoPosition geoPosition) { if (geoPosition != null) this.rGeoPosition = geoPosition; }



}
