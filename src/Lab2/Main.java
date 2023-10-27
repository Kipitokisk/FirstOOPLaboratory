package Lab2;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommitAction commitAction = new CommitAction();
        StatusAction statusAction = new StatusAction(null);

        String folderPath = "C:\\JavaProjects\\OOP_UTM\\OOPLaboratory\\src\\Lab2\\Files";
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "commit":
                    commitAction.execute(parts);
                    break;
                case "info":
                    InfoAction infoAction = new InfoAction();
                    infoAction.execute(parts);
                    break;
                case "status":
                    statusAction.execute(parts);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}