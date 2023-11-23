package com.company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static com.company.DeliveryGuy.Status.active;
import static com.company.DeliveryGuy.Status.inactive;
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
    ArrayList<DeliveryGuy> deliveryGuyArrayList;
    ArrayList<Order> orderArrayList;
    ArrayList<GeoPosition> geoPositionArrayList;
    ArrayList<Address>addressArrayList;
    ArrayList<Item>itemArrayList;
    ArrayList<OrderLine>orderLineArrayList;
    @BeforeEach
    public void setUp() throws Exception {
        clientArrayList=new ArrayList<>();
        orderArrayList=new ArrayList<>();
        geoPositionArrayList=new ArrayList<>();
        addressArrayList=new ArrayList<>();
        deliveryGuyArrayList=new ArrayList<>();
        itemArrayList=new ArrayList<>();
        orderLineArrayList=new ArrayList<>();

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
        a2=new Address(2,"bousof","oran","25003","alg",p2);
        a3=new Address(3,"boujnan","mila","25004","alg",p3);
        a4=new Address(4,"Nouv","telemsan","25007","alg",p4);
        a5=new Address(5,"jami3a","mostghanem","2001","dz",p4);addressArrayList.add(a1);
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

        //add Delivery

        d1 = new DeliveryGuy(1,"houssem","eddine","h0996g@gmail.com","123456","+2136589483",active);
        d2 = new DeliveryGuy(2,"hamza","eddine","hamza@gmail.com","123456","+212222222",active);
        d3 = new DeliveryGuy(3,"ala","eddine","ala@gmail.com","123456","+213333333",inactive);
        d4 = new DeliveryGuy(4,"hatem","eddine","hatem@gmail.com","123456","+213444444",inactive);
        deliveryGuyArrayList.add(d1);
        deliveryGuyArrayList.add(d2);
        deliveryGuyArrayList.add(d3);
        deliveryGuyArrayList.add(d4);

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

        //add Item

            i1=new Item(1,"item1","description1",111);
        i2=new Item(2,"item2","description2",222);
        i3=new Item(3,"item3","description3",333);
        i4=new Item(4,"item4","description4",444);
        i5=new Item(5,"item5","description5",555);
        itemArrayList.add(i1);
        itemArrayList.add(i2);
        itemArrayList.add(i3);
        itemArrayList.add(i4);
        itemArrayList.add(i5);

        //add OrderLine

        ol1=new OrderLine(11,"path1");
        ol2=new OrderLine(22,"path2");
        ol3=new OrderLine(33,"path3");
        ol4=new OrderLine(44,"path4");
        ol5=new OrderLine(55,"path5");
        orderLineArrayList.add(ol1);
        orderLineArrayList.add(ol2);
        orderLineArrayList.add(ol3);
        orderLineArrayList.add(ol4);
        orderLineArrayList.add(ol5);
        //add client(Order)

            c1.addOrder(o1);
            c1.addOrder(o5);
            c2.addOrder(o2);
            c3.addOrder(o3);
            c4.addOrder(o4);
            o1.addClient(c1);
            o2.addClient(c2);
            o3.addClient(c3);
            o4.addClient(c4);
            o5.addClient(c1);

//add DeliveryGuy(Order)

            d1.addOrder(o1);
            d1.addOrder(o5);
            d2.addOrder(o2);
            d3.addOrder(o3);
            d4.addOrder(o4);
            o1.addDeliveryGuy(d1);
            o2.addDeliveryGuy(d2);
            o3.addDeliveryGuy(d3);
            o4.addDeliveryGuy(d4);
            o5.addDeliveryGuy(d1);

        //add OrderLine(item)

        ol1.addItem(i1);
        ol2.addItem(i2);
        ol3.addItem(i3);
        ol3.addItem(i4);
        ol4.addItem(i5);
        //add Order(OrderLine)
        o1.addOrderLine(ol1);
        o1.addOrderLine(ol2);
//        o2.addOrderLine(ol2);
        o3.addOrderLine(ol3);
        o4.addOrderLine(ol4);
        o5.addOrderLine(ol5);
    }
    public void tearDown() throws Exception {
    }
    @Test
    public void testCountry(){
        assertNotNull(o1);
        assertNotNull(o1.getAddress().getCountry());
        System.out.println(c1.getOrder().size());
//   c2.getOrder().forEach(order -> {System.out.println(order.review);});
        assertEquals("alg", o1.getAddress().getCountry());
    }
    @Test
    public void testNumberOfClientOrder(){
        assertNotNull(c1);
        int counterOrder = 0;
        for (Order o :orderArrayList ) {
            if(o.getClient().getId() == c1.getId()){
                counterOrder = counterOrder + 1;
            }
        }
        assertEquals(2, counterOrder);
    }
    @Test
    public void testNumberOfDeliveryGuyOrder(){
        assertNotNull(d2);
        int counterOrder = 0;
        for (Order o :orderArrayList ) {
            if(o.getDeliveryGuy().getId() == d2.getId()){
                counterOrder = counterOrder + 1;
            }
        }
        assertEquals(1, counterOrder);
    }
    @Test
    public void testChangeAddressOrder(){
        assertNotNull(o1);
        assertEquals("Constantine", o1.getAddress().getCity());
        o1.addAddress(a2);
        assertEquals("oran", o1.getAddress().getCity());
        System.out.println(o1.getOrderLine().size());
    }
    @Test
    public void testCounterOrderLinInOrder(){
        assertNotNull(o1);
        assertNotNull(ol1);
        assertNotNull(ol2);
        assertEquals(2, o1.getOrderLine().size());
    }
}