package Lab2;

import java.io.File;

public class FileSnapshot {
    private String filename;
    private long lastModifiedTime;

    public FileSnapshot(String filename) {
        this.filename = filename;
        this.updateSnapshot();
    }

    public void updateSnapshot() {
        File file = new File(filename);
        if (file.exists()) {
            lastModifiedTime = file.lastModified();
        }
    }

    public boolean hasChanged() {
        File file = new File(filename);
        return file.exists() && file.lastModified() > lastModifiedTime;
    }

    public String getFileName() {
        return filename;
    }

    public void printInfo() {
        System.out.println("File Name: " + filename);
    }
}

