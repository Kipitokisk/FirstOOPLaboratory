package Lab2.FileActionFolder;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileUtility {
    public static Set<String> getSnapshotFiles(File folder) {
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
