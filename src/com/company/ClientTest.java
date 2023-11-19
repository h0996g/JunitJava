package com.company;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.company.Order.Status.Draft;
import static com.company.Order.Status.confirmed;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client c1, c2, c3, c4;
    Address a1,a2,a3,a4,a5;
    GeoPosition p1,p2,p3,p4;
    Order o1 , o2 , o3 , o4,o5  ;
    OrderLine ol1,ol2,ol3,ol4,ol5;
    DeliveryGuy d1,d2,d3,d4,d5;
    Item i1,i2,i3,i4,i5;
    ArrayList<Client> clientArrayList;
    ArrayList<Order> orderArrayList;
    ArrayList<GeoPosition> geoPositionArrayList;
    ArrayList<Address>addressArrayList;
    @BeforeEach
    public void setUp() throws Exception {
        clientArrayList=new ArrayList<>();
        orderArrayList=new ArrayList<>();
        geoPositionArrayList=new ArrayList<>();
        addressArrayList=new ArrayList<>();

        //add GeoPosition
        p1=new GeoPosition(1,20.3,20.4);
        p2=new GeoPosition(2,22.3,24.6);
        p3=new GeoPosition(3,13.3,9.2);
        p4=new GeoPosition(4,5,50.7);

        geoPositionArrayList.add(p1);
        geoPositionArrayList.add(p2);
        geoPositionArrayList.add(p3);
        geoPositionArrayList.add(p4);


        //add Address
        a1=new Address(1,"Zwghi","Constantine","25001","alg",p1);
        a2=new Address(2,"bousof","Constantine","25003","alg",p2);
        a3=new Address(3,"boujnan","Constantine","25004","alg",p3);
        a4=new Address(4,"Nouv","Constantine","25007","alg",p4);
        a5=new Address(5,"jami3a","Constantine","2001","dz",p4);

        addressArrayList.add(a1);
        addressArrayList.add(a2);
        addressArrayList.add(a3);
        addressArrayList.add(a4);
        addressArrayList.add(a5);


        //add Clients
        c1 = new Client(1,"houssem","eddine","h0996g@gmail.com","123456","+2136589483","profilePhotoPath1");
        c2 = new Client(2,"hamza","eddine","hamza@gmail.com","123456","+212222222","profilePhotoPath2");
        c3 = new Client(3,"ala","eddine","ala@gmail.com","123456","+213333333","profilePhotoPath3");
        c4 = new Client(4,"hatem","eddine","hatem@gmail.com","123456","+213444444","profilePhotoPath4");

        clientArrayList.add(c1);
        clientArrayList.add(c2);
        clientArrayList.add(c3);
        clientArrayList.add(c4);


//        add Orders
        o1=new Order(1,"5",5,new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),Draft,a1);
        o2=new Order(2,"good",4,new GregorianCalendar(2004, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2005, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),Draft,a2);
        o3=new Order(3,"nice",4,new GregorianCalendar(2003, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2005, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),Draft,a3);

        o4=new Order(4,"b1",4,new GregorianCalendar(2007, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2005, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),Draft,a4);
        o5=new Order(5,"b1",5,new GregorianCalendar(2007, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2005, Calendar.JUNE, 8).getTime(),new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(),confirmed,a4);

        orderArrayList.add(o1);
        orderArrayList.add(o2);
        orderArrayList.add(o3);
        orderArrayList.add(o4);
        orderArrayList.add(o5);
//        o1.addAddress(a1);
//        o2.addAddress(a2);
//c1.addOrder(o1);
//        o1.addClient(c1);
//        o2.addClient(c2);
//c1.addOrder(o3);
//        c1.addOrder(o1);
//        c1.addOrder(o2);
//        o1.addClient(c1);
//        o2.addClient(c1);

    }

    public void tearDown() throws Exception {
    }
    @Test

    public void testCountry(){
        assertNotNull(o1);
        assertNotNull(o1.getAddress().getCountry());
        System.out.println(o1.getClient());
        assertEquals("alg", o1.getAddress().getCountry());
    }
//    @Test
//    public void testTouristVisitNumber(){
//        assertNotNull(o1);
//        int visitNumber = 0;
//        for (Order v :orderArrayList ) {
//            if(v.getClient().getId() == c1.getId()){
//                visitNumber = visitNumber + 1;
//            }
//        }
//        assertEquals(2, visitNumber);
//    }

}