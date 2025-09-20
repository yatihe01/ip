package duke.command;

import java.util.ArrayList;
import duke.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;

public interface Command {
    String execute(ArrayList<Task> tasks, Storage storage, Ui ui);
    boolean isExit();
}
