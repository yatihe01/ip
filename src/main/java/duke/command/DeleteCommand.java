package duke.command;

import java.util.ArrayList;
import duke.Task;
import duke.Storage;
import duke.Ui;
import duke.exception.InvalidCommandException;

public class DeleteCommand implements Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        try {
            if (index < 0 || index >= tasks.size()) {
                throw new InvalidCommandException("Invalid task number.");
            }

            Task taskToBeDeleted = tasks.get(index);
            tasks.remove(index);
            storage.save(tasks);
            return Ui.showRemovedTask(taskToBeDeleted, tasks.size());

        } catch (InvalidCommandException e) {
            return Ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false; // delete command does not exit the program
    }
}