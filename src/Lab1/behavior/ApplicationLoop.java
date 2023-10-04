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
    private String line;
    private Parser parser;

    public ApplicationLoop() {
        this.parser = new Parser();
        this.scanner = new Scanner(System.in);
        this.university = new University();
        this.command = "";
        this.line = "";
    }

    public void run() {
        university = parser.getUniversityFromFile();
        System.out.println("Choose from the following options:");
        System.out.println("f - Faculty operations");
        System.out.println("s - Student operations");
        System.out.println();
        System.out.println("q - Quit");
        while (!this.line.equals("q")) {
            this.line = takeUserInput();
//After inputing f, s or q and doing one of their operations, the user goes back to choosing f, s or q
//TODO make it so user stays in loop for faculty/student operations until he chooses to go back
            switch (line) {
                case "f":
                    System.out.println("Faculty operations:");
                    System.out.println();
                    System.out.println("create/<faculty name>/<faculty abbreviation>/<study field> - create new faculty");
                    System.out.println("list - print list of all faculties");
                    System.out.println("field/<study field> - print all faculties belonging to a study field");
                    System.out.println("students/<faculty abbreviation> - return list of all students belonging to faculty");
                    this.command = takeUserInput();
                    String[] commandsList = this.command.split("/");
                    handleFacultyOperation(commandsList);
                    break;
                case "s":
                    this.command = takeUserInput();
                    System.out.println("Student operations:");
                    System.out.println();
                    System.out.println("create/<name>/<surname>/<email>/<date of enrollment>/<date of birth>/<faculty abreviation> " +
                            "- create new student");
                    System.out.println("list of students - print list of all students");
                    System.out.println("list of graduates - print list of all graduates");
                    System.out.println("assign/<email>/<faculty abbreviation> - assign student to different faculty");
                    System.out.println("graduate/<email> - change graduate status of student");
                    System.out.println("check/<email>/<faculty abbreviation - check if student belongs to faculty");
                    System.out.println("faculty/<email> - check what faculty the student belongs to");
                    String[] commandsList1 = this.command.split("/");
                    handleStudentOperation(commandsList1);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        this.parser.saveUniversityToFile(this.university);
        scanner.close();
    }

    private void handleFacultyOperation(String[] commandsList) {
            switch (commandsList[0]) {
                case "create":
                    handleFacultyCreate(commandsList);
                    break;
                case "list":
                    university.toStringFaculties();
                    break;
                case "field":
                    university.facultyField(StudyField.valueOf(commandsList[1]));
                    break;
                case "students":
                    university.toStringStudentsOfFaculty(commandsList[1]);
                    break;
                default:
                    System.out.println("Invalid faculty operation");
            }
    }

    public void handleStudentOperation(String[] commandsList) {
            switch (commandsList[0]) {
                case "create":
                    handleStudentCreate(commandsList);
                    break;
                case "list of students":
                    university.toStringStudents();
                    break;
                case "list of graduates":
                    university.toStringGraduates();
                    break;
                case "assign":
                    university.assignStudentToFaculty(commandsList[1], commandsList[2]);
                    break;
                case "graduate":
                    university.graduateStatus(commandsList[1], Boolean.valueOf(commandsList[2]));
                    break;
                case "check":
                    university.isBelongToFaculty(commandsList[1], commandsList[2]);
                    break;
                case "faculty":
                    university.belongToFaculty(commandsList[1]);
                    break;
            }
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