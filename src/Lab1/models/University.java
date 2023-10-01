package Lab1.models;

import java.util.ArrayList;
import java.util.List;

public class University{
    private List<Faculty> faculties = new ArrayList<>();
    private List<Student> students = new ArrayList<>();


    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public String toStringFaculties() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }

    public String toStringStudents() {
        StringBuilder text = new StringBuilder();
        for (Student student : this.students) {
            if (!student.isGraduated()) {
                text.append(student).append("\n");
            }
        }

        return text.toString();
    }

    public String toStringGraduates() {
        StringBuilder text = new StringBuilder();
        for (Student student : this.students) {
            if (student.isGraduated()) {
                text.append(student).append("\n");
            }
        }

        return text.toString();
    }

    public void assignStudentToFaculty(String email, String abreviation) {
        for (Student student : students){
            if (student.getEmail().equals(email)) {
                for (Faculty faculty : faculties){
                    if (faculty.getAbbreviation().equals(abreviation)) {
                        faculty.addStudent(student);
                    }
                }
            }
        }
    }

    public void graduateStatus(String email, Boolean val){
        for (Student student: students) {
            if (student.getEmail().equals(email)){
                student.setGraduated(val);
            }
        }
    }

    public void isBelongToFaculty(String email, String abreviation) {
        for (Student student : students){
            if (student.getEmail().equals(email)){
                for (Faculty faculty : faculties){
                    if (faculty.getAbbreviation().equals(abreviation)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    return;
                }
            }
        }
        System.out.println("No such email");
    }

    public void belongToFaculty(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    System.out.println(faculty.getAbbreviation());
                }
            }
        }
    }
}
