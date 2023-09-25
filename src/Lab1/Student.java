package Lab1;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private boolean isGraduated;

    public Student(String firstName, String lastName, String email, Date enrollmentDate, Date dateOfBirth, boolean isGraduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.isGraduated = isGraduated;
    }

    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
    }
}
