package org.example.service;

import org.example.db.StudentRepository;
import org.example.db.entity.StudentEntity;
import org.apache.log4j.Logger;
import org.example.service.converter.StudentConverter;
import org.example.service.dto.StudentDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final Logger log = Logger.getLogger(StudentService.class);


    private final StudentRepository repository;
    private final StudentConverter converter;

    public StudentService(StudentRepository repository, StudentConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public StudentDTO findById(int id) {
        StudentEntity studentEntity = repository.findById(id);
        return converter.convert(studentEntity);
    }

    public void create(StudentDTO newStudent) {
        StudentEntity studentEntity = converter.convert(newStudent);
        repository.save(studentEntity);
    }

    public Collection<StudentDTO> getStudents() {
        List<StudentDTO> students = repository.getStudents()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        log.debug("Students found: " + students.size());
        return students;
    }

    public Collection<StudentDTO> findByFirstName(String name) {
       return repository.findByFirstName(name).stream()
               .filter(studentEntity -> studentEntity.getFirstName().equals(name))
               .map(converter::convert)
               .collect(Collectors.toList());
    }

    public void update(StudentEntity studentEntity){
        repository.update(studentEntity);
    }
}
