package org.example.db.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private int course;

    public StudentEntity() {
    }

    public StudentEntity(String firstName, String lastName, int course) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public StudentEntity(int id, int course, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public StudentEntity(int course, String lastName, String firstName) {
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
