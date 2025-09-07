package duke.command;

import java.util.ArrayList;
import duke.Task;
import duke.Storage;
import duke.Ui;

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