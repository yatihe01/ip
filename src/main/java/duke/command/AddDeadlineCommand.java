package duke.command;

import java.util.ArrayList;
import duke.Task;
import duke.Deadline;
import duke.Storage;
import duke.Ui;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

public class AddDeadlineCommand implements Command {
    private final String input; // full input after "deadline"

    public AddDeadlineCommand(String input) {
        this.input = input;
    }

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