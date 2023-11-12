package Lab2;
import Lab2.FileActionFolder.FileAction;
import Lab2.FileActionFolder.FileAnalyzer;
import Lab2.FileActionFolder.FileInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoAction implements FileAction {
    private final FileInfo fileInfo = new FileInfo();
    private final FileAnalyzer fileAnalyzer = new FileAnalyzer();

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: info <filename>");
            return;
        }

        String filename = args[1];
        File file = fileInfo.getFile(filename);

        if (file.exists()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String extension = filename.substring(filename.lastIndexOf('.') + 1);

            System.out.println("File Name: " + file.getName());
            System.out.println("Extension: " + extension);
            String createdDate = fileInfo.getCreatedDate(file.toPath());
            System.out.println("Created Date: " + createdDate);
            System.out.println("Last Modified Date: " + dateFormat.format(new Date(file.lastModified())));

            if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                String imageSize = fileAnalyzer.getImageDimensions(file);
                System.out.println("Image Size: " + imageSize);
            } else if (extension.equals("txt")) {
                int lineCount = fileAnalyzer.getLineCount(file);
                int wordCount = fileAnalyzer.getWordCount(file);
                int characterCount = fileAnalyzer.getCharacterCount(file);
                System.out.println("Line Count: " + lineCount);
                System.out.println("Word Count: " + wordCount);
                System.out.println("Character Count: " + characterCount);
            } else if (extension.equals("py") || extension.equals("java")) {
                int lineCount = fileAnalyzer.getLineCount(file);
                int classCount = fileAnalyzer.getClassCount(file);
                int methodCount = fileAnalyzer.getMethodCount(file);
                System.out.println("Line Count: " + lineCount);
                System.out.println("Class Count: " + classCount);
                System.out.println("Method Count: " + methodCount);
            }
        } else {
            System.out.println("File not found: " + filename);
        }
    }
}