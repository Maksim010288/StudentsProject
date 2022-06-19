package service;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
}
