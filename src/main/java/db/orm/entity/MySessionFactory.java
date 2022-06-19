package db.orm.entity;

import static service.SessionFactory.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MySessionFactory {

    public Session getSessionOpen() {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        return session;
    }

    public Session getSave(Session session, StudentEntity studentEntity) {
        session.save(studentEntity);
        return session;
    }

    public void getSessionClose(Session session) {
            session.getTransaction().commit();
            session.close();
    }
}
