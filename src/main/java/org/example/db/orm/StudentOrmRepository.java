package org.example.db.orm;

import org.example.db.StudentRepository;
import org.example.db.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class StudentOrmRepository implements StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(StudentEntity studentEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(studentEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(StudentEntity studentEntity) {
        Session session = sessionFactory.openSession();
        session.update(studentEntity);
        session.close();
    }

    @Override
    public StudentEntity findById(int id) {
        Session session = sessionFactory.openSession();
        StudentEntity studentEntity = session.get(StudentEntity.class, id);
        session.close();
        return studentEntity;
    }

    @Override
    public Collection<StudentEntity> findByFirstName(String name) {
        Collection<StudentEntity> entities = new LinkedList<>();
        Session session = sessionFactory.openSession();
        while (session.isDirty()) {
           entities.add(session.get(StudentEntity.class, name));
        }
        session.close();
        return entities;
    }

    @Override
    public List<StudentEntity> getStudents() {
        return null;
    }
}
