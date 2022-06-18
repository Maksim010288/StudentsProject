package service;

import db.orm.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SessionFactory {


    private SessionFactory() {
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        try {
            StandardServiceRegistry builder =
                    new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(builder).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            System.out.println("Виключення " + e);
            throw new ExceptionInInitializerError(e);
        }
    }


    public static void main(String[] args) {
        org.hibernate.SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        StudentEntity studentEntity = new StudentEntity("Dina", "Zaycewa", 1);
        int s1 = (int) session.save(studentEntity);
        session.getTransaction().commit();
        session.close();

//        Session session1 = factory.openSession();
//        session1.getTransaction().begin();
//        StudentEntity studentEntity1 = new StudentEntity("Dima", "Zaycew", 3);
//        int s2 = (int) session1.save(studentEntity1);
//        session1.getTransaction().commit();
//        session1.close();

        List<Integer> list = new ArrayList<>();
        list.add(s1);
        //list.add(s2);
        Session session2 = factory.openSession();
        for (Integer i : list) {
            StudentEntity entity = session2.get(StudentEntity.class, i);
            System.out.println(entity);
        }
        session2.close();
    }
}
