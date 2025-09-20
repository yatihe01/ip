package duke;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

import duke.command.*;
import duke.command.ViewDateCommand;
import duke.exception.InvalidCommandException;
import duke.storage.Storage;
import duke.task.Task;
import duke.ui.Ui;

public class ChatHYT {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();
    static ArrayList<Task> tasks_to_be_found = new ArrayList<>();
    static Storage storage = new Storage("./data/duke.txt");

    public static void main(String[] args) {
        tasks = storage.load();
        Ui.showWelcome();

        while(true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                Ui.sayGoodbye();
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                Ui.showList(tasks);
                continue;
            }

            if (input.startsWith("mark ")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    MarkCommand markCommand = new MarkCommand(index);
                    markCommand.execute(tasks, storage, new Ui());
            }

            if (input.startsWith("unmark ")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    UnmarkCommand unmarkCommand = new UnmarkCommand(index);
                    unmarkCommand.execute(tasks, storage, new Ui());
            }

            try {
                if (input.startsWith("todo")) {
                    String input_todo = input.substring(4);
                    AddTodoCommand todoCommand = new AddTodoCommand(input_todo);
                    todoCommand.execute(tasks,storage, new Ui());

                } else if (input.startsWith("deadline")) {
                    String input_deadline = input.substring(8);
                    AddDeadlineCommand deadlineCommand = new AddDeadlineCommand(input_deadline);
                    deadlineCommand.execute(tasks, storage, new Ui());

                } else if (input.startsWith("event")) {
                    String input_event = input.substring(5);
                    AddEventCommand eventCommand = new AddEventCommand(input_event);
                    eventCommand.execute(tasks, storage, new Ui());

                } else if (input.startsWith("delete")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    DeleteCommand deleteCommand = new DeleteCommand(index);
                    deleteCommand.execute(tasks, storage, new Ui());
                } else if (input.startsWith("find")) {
                    String keyword = input.substring(4);
                    FindCommand findCommand = new FindCommand(keyword);
                    findCommand.execute(tasks, storage, new Ui());
                } else {
                    throw new InvalidCommandException("What?");
                }
            } catch (InvalidCommandException e) {
                Ui.showError(e.getMessage());
            }
        }
        scanner.close();
    }

    public String getResponse(String input) {
        try {
            if (input.equals("bye")) {
                return Ui.sayGoodbye();
            } else if (input.equalsIgnoreCase("list")) {
                return Ui.showList(tasks);
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                MarkCommand markCommand = new MarkCommand(index);
                return markCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                UnmarkCommand unmarkCommand = new UnmarkCommand(index);
                return unmarkCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("todo")) {
                AddTodoCommand todoCommand = new AddTodoCommand(input.substring(4).trim());
                return todoCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("deadline")) {
                AddDeadlineCommand deadlineCommand = new AddDeadlineCommand(input.substring(8).trim());
                return deadlineCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("event")) {
                AddEventCommand eventCommand = new AddEventCommand(input.substring(5).trim());
                return eventCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("delete")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                DeleteCommand deleteCommand = new DeleteCommand(index);
                return deleteCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("find")) {
                FindCommand findCommand = new FindCommand(input.substring(4).trim());
                return findCommand.execute(tasks, storage, new Ui());
            } else if (input.startsWith("view")) {
                LocalDate date = LocalDate.parse(input.substring(5).trim());
                ViewDateCommand view = new ViewDateCommand(date);
                return view.execute(tasks, storage, new Ui());
            } else {
                throw new InvalidCommandException("What?");
            }
        } catch (InvalidCommandException e) {
            return Ui.showError(e.getMessage());
        }
    }
}

