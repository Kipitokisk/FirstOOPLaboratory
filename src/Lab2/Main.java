package Lab2;

import Lab2.FileActionFolder.FileActionExecutor;
import Lab2.FileActionFolder.FileUtility;

import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CommitAction commitAction = new CommitAction();
        Set<String> lastSnapshotFiles = new HashSet<>();

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
                    FileActionExecutor commitExecutor = new FileActionExecutor(commitAction);
                    commitExecutor.execute(parts);
                    lastSnapshotFiles = FileUtility.getSnapshotFiles(folder);
                    break;
                case "info":
                    FileActionExecutor infoExecutor = new FileActionExecutor(new InfoAction());
                    infoExecutor.execute(parts);
                    break;
                case "status":
                    FileActionExecutor statusExecutor = new FileActionExecutor(
                            new StatusAction(commitAction.getSnapshotTime(), lastSnapshotFiles));
                    statusExecutor.execute(parts);
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
