package Lab2;

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
                    commitAction.execute(parts);
                    lastSnapshotFiles = getSnapshotFiles(folder);
                    break;
                case "info":
                    InfoAction infoAction = new InfoAction();
                    infoAction.execute(parts);
                    break;
                case "status":
                    StatusAction statusAction = new StatusAction(commitAction.getSnapshotTime(), lastSnapshotFiles);
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

    private static Set<String> getSnapshotFiles(File folder) {
        Set<String> snapshotFiles = new HashSet<>();
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    snapshotFiles.add(file.getName());
                }
            }
        }
        return snapshotFiles;
    }
}
