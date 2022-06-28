package org.example.service.converter;

import org.example.db.entity.StudentEntity;
import org.example.service.dto.StudentDTO;

public class StudentConverter {

    public StudentDTO convert(StudentEntity entity) {
        return new StudentDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getCourse());
    }

    public StudentEntity convert(StudentDTO dto) {
        return new StudentEntity(dto.getFirstName(), dto.getLastName(), dto.getCourse());
    }
}
