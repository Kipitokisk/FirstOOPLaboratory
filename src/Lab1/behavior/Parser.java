package Lab1.behavior;

import Lab1.models.University;

import java.io.*;

public class Parser {

    public void saveUniversityToFile(University university) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/Lab1/text/University.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(university);
            out.close();
            fileOut.close();
            System.out.println("Saved!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("NO FILE FOUND");
        } catch (IOException ioException) {
            System.out.println("IO EXCEPTION");
        }
    }
    public University getUniversityFromFile() {
        University university = new University();
        try {
            FileInputStream fileIn = new FileInputStream("src/Lab1/text/University.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            university = (University) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Successful load!");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("University Class NOT FOUND");
        } catch (IOException ioException) {
                System.out.println("IO EXCEPTION");
        }
        return university;
    }
}
