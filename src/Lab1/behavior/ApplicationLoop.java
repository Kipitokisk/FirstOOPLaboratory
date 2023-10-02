package Lab1.behavior;

import Lab1.models.Faculty;
import Lab1.models.Student;
import Lab1.models.StudyField;
import Lab1.models.University;

import java.util.Scanner;

public class ApplicationLoop {

    private Scanner scanner;
    private University university;
    private String command;

    public ApplicationLoop() {
        this.scanner = new Scanner(System.in);
        this.university = new University();
        this.command = "";
    }

    public void run() {
        while (!this.command.equals("q")) {
            this.command = takeUserInput();

            String[] commandsList = this.command.split("/");

            switch (commandsList[0]) {
                case "f":
                    handleFacultyCreate(commandsList);
                    break;
                case "pf":
                    System.out.println(university.toStringFaculties());
                    break;
                case "s":
                    handleStudentCreate(commandsList);
                    break;
                case "ps":
                    System.out.println(university.toStringStudents());
                    break;
                case "as":
                    university.assignStudentToFaculty(commandsList[1], commandsList[2]);
                    break;
                case "gs":
                    university.graduateStatus(commandsList[1], Boolean.valueOf(commandsList[2]));
                    break;
                case "pg":
                    System.out.println(university.toStringGraduates());
                    break;
                case "bf":
                    university.isBelongToFaculty(commandsList[1], commandsList[2]);
                    break;
                case "df":
                    university.belongToFaculty(commandsList[1]);
                    break;
                case "ff":
                    university.facultyField(StudyField.valueOf(commandsList[1]));
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        scanner.close();
    }

    private String takeUserInput() {
        System.out.print("write command> ");
        return scanner.nextLine();
    }

    private void handleFacultyCreate(String[] commands) {
        if (commands.length == 4) {
            addFaculty(commands);
        } else {
            System.out.println("Input error");
        }
    }

    private void addFaculty(String[] arguments) {
        Faculty faculty = new Faculty(arguments[1], arguments[2], StudyField.valueOf(arguments[3].toUpperCase()));
        this.university.addFaculty(faculty);
    }

    private void addStudent(String[] arguments) {
        Student student = new Student(arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]);
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getAbbreviation().equals(arguments[6])) {
                faculty.addStudent(student);
            }
        }
    }

    private void handleStudentCreate(String[] commands) {
        if (commands.length == 7) {
            addStudent(commands);
        } else {
            System.out.println("Input error");
        }
    }
}