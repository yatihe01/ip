package duke.command;

import java.time.LocalDate;
import java.util.ArrayList;

import duke.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;

public class ViewDateCommand implements Command {
    private final LocalDate date;

    public ViewDateCommand(LocalDate date) {
        this.date = date;
    }

    @Override
    public String execute(ArrayList<Task> tasks, Storage storage, Ui ui) {
        String schedule = Ui.displaySchedule(date, tasks);
        if (schedule.isEmpty()) {
            return "No tasks scheduled for " + date.toString();
        } else {
            return "Tasks for " + date.toString() + ":\n" + schedule;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
