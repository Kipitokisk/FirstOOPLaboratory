package Lab1.models;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class University implements Serializable {
    private List<Faculty> faculties = new ArrayList<>();

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void toStringFaculties() {
        StringBuilder text = new StringBuilder();
        for (Faculty faculty : faculties) {
            text.append(faculty).append("\n");
        }
        System.out.println(text);
    }

    public void toStringGraduates() {
        StringBuilder text = new StringBuilder();
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.isGraduated()) {
                    text.append(student).append("\n");
                }
            }
        }
        System.out.println(text);
    }

    public void toStringStudentsOfFaculty(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                StringBuilder text = new StringBuilder();
                    if (faculty.getStudents() != null) {
                        for (Student student : faculty.getStudents()) {
                            if (!student.isGraduated()) {
                                text.append(student).append("\n");
                            }
                        }
                    }
                System.out.println(text);
                return;
            }
        }
        System.out.println("No such faculty");
    }

    public void toStringStudents() {
        StringBuilder text = new StringBuilder();
        for (Faculty faculty : faculties) {
            if (faculty.getStudents() != null) {
                for (Student student : faculty.getStudents()) {
                    if (!student.isGraduated()) {
                        text.append(student).append("\n");
                    }
                }
            }
        }
        System.out.println(text);
    }

    public void graduateStatus(String email, Boolean val){
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    student.setGraduated(val);
                }
            }
        }
    }

    public void isBelongToFaculty(String email, String abreviation) {
        for (Faculty faculty : faculties){
            if (faculty.getAbbreviation().equals(abreviation)) {
                for (Student student : faculty.getStudents()) {
                    if (student.getEmail().equals(email)) {
                        System.out.println("True");
                        return;
                    }
                }
                System.out.println("False");
                return;
            }
        }
        System.out.println("No such faculty.");
    }

    public void belongToFaculty(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    System.out.println(faculty.getAbbreviation());
                    return;
                }
            }
        }
        System.out.println("No such email");
    }

    public void facultyField(StudyField field) {
        for (Faculty faculty : faculties) {
            if (faculty.getStudyField() == field) {
                System.out.println(faculty.getAbbreviation());
            }
        }
    }

    public List<Faculty> getFaculties() {
        return this.faculties;
    }

    public void assignStudentToFaculty(String email, String abreviation) {
        for (Faculty faculty : faculties) {
            int i = 0;
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    for (Faculty faculty1 : faculties) {
                        if (faculty1.getAbbreviation().equals(abreviation)) {
                            faculty.getStudents().remove(i);
                            faculty1.addStudent(student);
                            return;
                        }
                    }
                    System.out.println("No such faculty");
                    return;
                }
                i++;
            }
        }
        System.out.println("No such email");
    }
}
