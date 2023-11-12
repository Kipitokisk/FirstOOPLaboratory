package Lab2;
import Lab2.FileActionFolder.FileAction;

import java.util.Date;

public class CommitAction implements FileAction {
    private Date snapshotTime;

    public CommitAction() {
        snapshotTime = new Date();
    }

    @Override
    public void execute(String[] args) {
        snapshotTime = new Date();
        System.out.println("Snapshot time updated to: " + snapshotTime);
    }

    public Date getSnapshotTime() {
        return snapshotTime;
    }
}