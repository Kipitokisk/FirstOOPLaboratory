package Lab2.FileActionFolder;

public class FileActionExecutor {
    private FileAction fileAction;

    public FileActionExecutor(FileAction fileAction) {
        this.fileAction = fileAction;
    }

    public void execute(String[] args) {
        fileAction.execute(args);
    }
}