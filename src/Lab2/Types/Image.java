package Lab2.Types;

import Lab2.FileActionFolder.FileInfo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends BasicFile{
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);
    String dimension;
    public Image(String imageName, String extension, String createdDate, String lastModifiedDate) {
        super(imageName, extension, createdDate, lastModifiedDate);
        this.dimension = getImageDimensions();
    }

    String getImageDimensions() {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            return width + "x" + height;
        } catch (IOException e) {
            return "N/A";
        }
    }

    @Override
    public String toString() {
        return "Image name: " + fileName + "\n" +
                "Extension: " + extension + "\n" +
                "Created date: " + createdDate + "\n" +
                "Last modified date: " + lastModifiedDate + "\n" +
                "Dimension: " + dimension + "\n";
    }
}
