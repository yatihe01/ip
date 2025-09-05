package duke.command;

import java.util.ArrayList;
import duke.Task;
import duke.Storage;
import duke.Ui;

public interface Command {
    String execute(ArrayList<Task> tasks, Storage storage, Ui ui);
    boolean isExit();
}
