package service.converter;

import db.orm.entity.StudentEntity;
import dto.StudentDTO;

public class StudentConverter {

    public StudentDTO convert(StudentEntity entity) {
        return new StudentDTO(entity.getLastName(), entity.getFirstName(), entity.getCourse());
    }

    StudentEntity convert(StudentDTO dto) {
        return null;
    }
}
