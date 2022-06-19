package service.converter;

import db.orm.entity.MySessionFactory;
import db.orm.entity.StudentEntity;
import dto.StudentDTO;
import org.hibernate.Session;

public class StudentConverter {

    public StudentDTO convert(StudentEntity entity) {
        return new StudentDTO(entity.getLastName(), entity.getFirstName(), entity.getCourse());
    }

    public StudentEntity convert(StudentDTO dto) {
        return new StudentEntity(dto.getLastName(), dto.getFirstName(), dto.getCourse());
    }
}
