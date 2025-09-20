package duke.command;

import java.util.ArrayList;
import duke.task.Task;
import duke.task.Event;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

public class AddEventCommand implements Command {
    private final String input; // full input after "event"

    public AddEventCommand(String input) {
        this.input = input.trim();
    }

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        try {
            if (!input.contains("/from") || !input.contains("/to")) {
                throw new InvalidCommandException("Event must have a period.");
            }

            // Split the input into description, from, and to
            String[] descAndFrom = input.split(" /from", 2);
            String description = descAndFrom[0].trim();

            String[] fromAndTo = descAndFrom[1].split(" /to", 2);
            String from = fromAndTo[0].trim();
            String to = fromAndTo[1].trim();

            if (description.isEmpty()) {
                throw new EmptyDescriptionException("Haha! You don't want to do anything right?");
            }

            Task task = new Event(description, from, to);
            tasks.add(task);
            storage.save(tasks);
            return Ui.showAddedTask(task, tasks.size());

        } catch (EmptyDescriptionException | InvalidCommandException e) {
            return Ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false; // event command does not exit the program
    }
}