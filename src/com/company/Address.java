package com.company;

public class Address {
    protected int id;
    protected String street;
    protected String city;
    protected String postalCode;
    protected String country;
    protected double longitude;
    protected double latitude;

<<<<<<< HEAD
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Address(int id, String street, String city, String postalCode, String country, double latitude, double longitude) {
=======
    public Address(int id,String street, String city, String postalCode, String country,double latitude,double longitude) {
>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f
        this.id=id;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.latitude=latitude;
        this.longitude=longitude;
<<<<<<< HEAD

=======
//        addGeoPosition(geoPosition);
>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


<<<<<<< HEAD
=======
    //----------------------relation(one to one unidirectionnelle (compostion)  ) Address with GeoPosition--------------------
//private  GeoPosition rGeoPosition;


//    public void addGeoPosition(GeoPosition geoPosition) { setGeoPosition(geoPosition);
//
//    }
//    public GeoPosition getGeoPosition() { return rGeoPosition; }
//    public void setGeoPosition(GeoPosition geoPosition) { if (geoPosition != null) this.rGeoPosition = geoPosition; }
public String toString() {
    return "Address{" +
            "id=" + id +
            ", street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", postal_code='" + postalCode + '\'' +
            ", country='" + country + '\'' +
            ", lattitude=" + latitude +
            ", longitude=" + longitude +
            '}';
}

    public String getWilayaCode() {
        String wilayaCode ;
        if (postalCode != null && postalCode.length() >= 2) {
            wilayaCode = postalCode.substring(0, 2);
        } else {
            wilayaCode = "Invalid";
        }
        return wilayaCode;
    }
>>>>>>> 8a08c941cf180e4dae1bc64ff68d53d052a1420f


}