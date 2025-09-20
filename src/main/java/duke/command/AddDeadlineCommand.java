package duke.command;

/**
 *  Represents a command to add a deadline task.
 */

import java.util.ArrayList;
import duke.task.Task;
import duke.task.Deadline;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

public class AddDeadlineCommand implements Command {
    private final String input;

    public AddDeadlineCommand(String input) {
        this.input = input;
    }

    /**
     *
     * @param tasks The list of existing tasks.
     * @param storage The storage handler for saving tasks.
     * @param ui The UI handler for displaying messages.
     * @return A string message confirming the added task,
     *         or an error message if the input is invalid.
     */

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        try {
            if (!input.contains("/by")) {
                throw new InvalidCommandException("Deadline must have an end.");
            }

            String[] parts = input.split(" /by", 2); // split only once
            String description = parts[0].trim();
            String by = parts[1].trim();

            if (description.isEmpty()) {
                throw new EmptyDescriptionException("Haha! You don't want to do anything right?");
            }

            Task task = new Deadline(description, by);
            tasks.add(task);
            storage.save(tasks);
            return Ui.showAddedTask(task, tasks.size());

        } catch (EmptyDescriptionException | InvalidCommandException e) {
            return Ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false; // deadline command does not exit the program
    }
}