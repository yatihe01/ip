package duke.command;

import java.util.ArrayList;
import duke.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;

public class FindCommand implements Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword.trim();
    }

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        ArrayList<Task> tasksToBeFound = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                tasksToBeFound.add(task);
            }
        }

        return Ui.showListToBeFound(tasksToBeFound);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}