package duke.command;

import java.util.ArrayList;
import duke.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.exception.InvalidCommandException;

public class UnmarkCommand implements Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        try {
            if (index < 0 || index >= tasks.size()) {
                throw new InvalidCommandException("Invalid task number.");
            }

            Task task = tasks.get(index);
            task.unmarkAsDone();
            storage.save(tasks);
            return Ui.showUnmark(task);

        } catch (InvalidCommandException e) {
            return Ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}