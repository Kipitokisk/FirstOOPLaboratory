package Lab2.Types;

import java.io.File;

abstract class BasicFile{
    String fileName;
    String extension;
    String createdDate;
    String lastModifiedDate;

    public BasicFile(String fileName, String extension, String createdDate, String lastModifiedDate) {
        this.fileName = fileName;
        this.extension = extension;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
