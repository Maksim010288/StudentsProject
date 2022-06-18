package db.orm.entity;

import javax.persistence.*;

@Entity(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "course")
    private int course;

    public StudentEntity(){}

    public StudentEntity(String lastName, String firstName, int course) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", course=" + course +
                '}';
    }
}
