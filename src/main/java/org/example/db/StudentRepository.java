package org.example.db;

import org.example.db.entity.StudentEntity;

import java.util.Collection;
import java.util.List;

public interface StudentRepository {

    void save(StudentEntity studentEntity);
    void update(StudentEntity studentEntity);
    StudentEntity findById(int id);
    Collection<StudentEntity> findByFirstName(String name);
    List<StudentEntity> getStudents();
}
