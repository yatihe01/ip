package chatHYT.command;

import java.util.ArrayList;
import chatHYT.task.Task;
import chatHYT.storage.Storage;
import chatHYT.ui.Ui;

public interface Command {
    String execute(ArrayList<Task> tasks, Storage storage, Ui ui);
    boolean isExit();
}
