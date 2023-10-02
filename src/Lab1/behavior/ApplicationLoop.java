package Lab1.behavior;

import Lab1.models.Faculty;
import Lab1.models.Student;
import Lab1.models.StudyField;
import Lab1.models.University;

import java.sql.Date;
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
        while (!this.command.equals("q") ) {
            this.command = takeUserInput();

            String[] commandsList = this.command.split("/");

            switch (commandsList[0]) {
                case "f":
                    handleFacultyCreate(commandsList);
                    break;
                case "pf":
                    printFaculties();
                    break;
                case "s":
                    handleStudentCreate(commandsList);
                    break;
                case "ps":
                    printStudents();;
                    break;
                case "as":
                    assignStudentToFaculty(commandsList);
                    break;
                case "gs":
                    graduateeStatus(commandsList);
                    break;
                case "pg":
                    printGraduates();
                    break;
                case "bf":
                    isBelongToFaculty(commandsList);
                    break;
                case "df":
                    belongToFaculty(commandsList);
                    break;
                case "ff":
                    facultyField(commandsList);
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
        if(commands.length == 4) {
            addFaculty(commands);
        } else {
            System.out.println("Input error");
        }
    }
    private void addFaculty(String[] arguments) {

        Faculty faculty = new Faculty(arguments[1], arguments[2], StudyField.valueOf(arguments[3].toUpperCase()));
        this.university.addFaculty(faculty);
    }

    private void printFaculties() {
        System.out.println(university.toStringFaculties());
    }

    private void addStudent(String[] arguments) {
        Student student = new Student(arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]);
        this.university.addStudent(student);
    }

    private void handleStudentCreate(String[] commands) {
        if (commands.length == 6) {
            addStudent(commands);
        } else {
            System.out.println("Input error");
            return;
        }
    }

    private void printStudents(){
        System.out.println(university.toStringStudents());
    }

    private void assignStudentToFaculty(String[] arguments) {
        university.assignStudentToFaculty(arguments[1], arguments[2]);
    }

    private void graduateeStatus(String[] arguments){
        university.graduateStatus(arguments[1], Boolean.valueOf(arguments[2]));
    }

    private void printGraduates(){
        System.out.println(university.toStringGraduates());
    }

    private void isBelongToFaculty(String[] arguments){
        university.isBelongToFaculty(arguments[1], arguments[2]);
    }

    private void belongToFaculty(String[] arguments) {
        university.belongToFaculty(arguments[1]);
    }

    private void facultyField(String[] arguments) {
        university.facultyField(StudyField.valueOf(arguments[1]));
    }

}
