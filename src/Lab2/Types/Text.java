package Lab2.Types;

import Lab2.FileActionFolder.FileInfo;

import java.io.File;
import java.util.Scanner;

public class Text extends BasicFile{
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);
    int wordCount;
    int lineCount;
    int charCount;

    public Text(String fileName, String extension, String createdDate, String lastModifiedDate) {
        super(fileName, extension, createdDate, lastModifiedDate);
        this.lineCount = getLineCount();
        this.wordCount = getWordCount();
        this.charCount = getCharacterCount();
    }

    public int getLineCount() {
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            return lineCount;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getWordCount() {
        try (Scanner scanner = new Scanner(file)) {
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            return wordCount;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCharacterCount() {
        try (Scanner scanner = new Scanner(file)) {
            int characterCount = 0;
            while (scanner.hasNext()) {
                String word = scanner.next();
                characterCount += word.length();
            }
            return characterCount;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "File name: " + fileName + "\n" +
                "Extension: " + extension + "\n" +
                "Created date: " + createdDate + "\n" +
                "Last modified date: " + lastModifiedDate + "\n" +
                "Line count: " + lineCount + "\n" +
                "Word count: " + wordCount + "\n" +
                "Character count: " + charCount + "\n" ;
    }
}
