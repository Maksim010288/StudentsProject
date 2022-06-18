package dto;

import java.util.StringJoiner;

public class StudentDTO {
    private int id;
    private final String lastName;
    private final String firstName;
    private final int course;

    public StudentDTO(int id, String lastName, String firstName, int course) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public StudentDTO(String lastName, String firstName, int course) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public int getId() {
        return id;
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
        return new StringJoiner(", ", StudentDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("lastName='" + lastName + "'")
                .add("firstName='" + firstName + "'")
                .add("course=" + course)
                .toString();
    }


}
