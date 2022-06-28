package org.example;

import org.example.db.orm.StudentOrmRepository;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.example.service.StudentService;
import org.example.service.converter.StudentConverter;

public class MainORM {

    private static final Logger log = Logger.getLogger(MainORM.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();
        StudentOrmRepository repository = new StudentOrmRepository(sessionFactory);
        StudentConverter converter = new StudentConverter();
        StudentService studentService = new StudentService(repository, converter);

//        StudentDTO studentDTO = studentService.findStudent(1);
//        log.info(String.format("%s %s %s",
//                studentDTO.getFirstName(),
//                studentDTO.getLastName(),
//                studentDTO.getCourse()));
    }


    private static SessionFactory getSessionFactory() {
        try {
            StandardServiceRegistry builder = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(builder).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            log.info("Виключення " + e);
            throw new ExceptionInInitializerError(e);
        }
    }


}
