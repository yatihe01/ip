package chatHYT.command;

/**
 *  Represents a command to mark a task.
 */

import java.util.ArrayList;
import chatHYT.task.Task;
import chatHYT.storage.Storage;
import chatHYT.ui.Ui;
import chatHYT.exception.InvalidCommandException;

public class MarkCommand implements Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     *
     * @param tasks The list of existing tasks.
     * @param storage The storage handler for saving tasks.
     * @param ui The UI handler for displaying messages.
     * @return A string message confirming task marked.
     * or an error message if the input is invalid.
     */
    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        try {
            if (index < 0 || index >= tasks.size()) {
                throw new InvalidCommandException("Invalid task number.");
            }
            Task task = tasks.get(index);
            task.markAsDone();
            storage.save(tasks);
            return Ui.showMark(task);
        } catch (InvalidCommandException e) {
            return Ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}