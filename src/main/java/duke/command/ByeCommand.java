package duke.command;

/**
 *  Represents a command to show goodbye message.
 */

import java.util.ArrayList;
import duke.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;

public class ByeCommand implements Command {

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        return Ui.sayGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}