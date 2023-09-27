package Lab1.behavior;

import Lab1.models.Faculty;
import Lab1.models.StudyField;
import Lab1.models.University;

import java.net.Proxy;
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
            addFaculty();
        }
    }

    private void addFaculty() {
        // add faculty
        System.out.println("faculty name:");
        String facultyName = scanner.nextLine();
        System.out.println("faculty abbrev:");
        String facultyAbbrev = scanner.nextLine();
        System.out.println("faculty field:");
        StudyField facultyField = StudyField.valueOf(scanner.next().toUpperCase());

        Faculty faculty = new Faculty(facultyName, facultyAbbrev, facultyField);
        this.university.addFaculty(faculty);
    }

    private void addFaculty(String[] arguments) {

        Faculty faculty = new Faculty(arguments[1], arguments[2], StudyField.valueOf(arguments[3].toUpperCase()));
        this.university.addFaculty(faculty);
    }

    private void printFaculties() {
        System.out.println(university);
    }
}
