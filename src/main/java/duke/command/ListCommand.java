package duke.command;

import java.util.ArrayList;
import duke.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;

public class ListCommand implements Command {

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        return Ui.showList(tasks); // display all tasks
    }

    @Override
    public boolean isExit() {
        return false; // list command does not exit the program
    }
}