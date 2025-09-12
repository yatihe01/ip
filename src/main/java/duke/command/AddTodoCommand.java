package duke.command;

import java.util.ArrayList;
import duke.Task;
import duke.Storage;
import duke.Ui;
import duke.Todo;
import duke.exception.EmptyDescriptionException;

public class AddTodoCommand implements Command {
    private final String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        try {
            if (description.isEmpty()) {
                throw new EmptyDescriptionException("Haha! You don't want to do anything right?");
            }
            Task task = new Todo(description);
            tasks.add(task);
            storage.save(tasks);
            return Ui.showAddedTask(task, tasks.size());
        } catch (EmptyDescriptionException e) {
            return Ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}