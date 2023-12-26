package com.company;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
	// write your code
        System.out.println("hi");
        SessionFactory sessionFactory =
                new Configuration().configure("dz/delivery/hibernate/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Agenttest b = new Agenttest(6,"hosugssesm", "fedxine","h0d9g96g@gmail.com","1234456","06561g834133","e127.g0.0.1");
        session.persist(b);

        tx.commit();
//        Query q = session.createQuery("select * from ");
//                List<A> result = (List<A>) q.list();
        session.close(); sessionFactory.close();
    }
}
