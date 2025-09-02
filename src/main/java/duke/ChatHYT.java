package duke;

import java.util.Scanner;
import java.util.ArrayList;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

public class ChatHYT {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();
    static Storage storage = new Storage("./data/duke.txt");

    public static void main(String[] args) {
        tasks = storage.load();
        Ui.showWelcome();

        while(true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                Ui.showGoodbye();
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                Ui.showList(tasks);
                continue;
            }

            if (input.startsWith("mark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).markAsDone();
                        storage.save(tasks);
                        Task taskToBeMarked = tasks.get(index);
                        Ui.showMark(taskToBeMarked);
                    } else if (index > tasks.size()){
                        throw new InvalidCommandException("Invalid task number.");
                    } else {
                        throw new EmptyDescriptionException("What?");
                    }
                } catch (InvalidCommandException | EmptyDescriptionException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }

            if (input.startsWith("unmark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index >= 0) {
                        tasks.get(index).unmarkAsDone();
                        storage.save(tasks);
                        Task taskToBeUnmarked = tasks.get(index);
                        Ui.showUnmark(taskToBeUnmarked);
                    } else if (index > tasks.size()){
                        throw new InvalidCommandException("Invalid task number.");
                    } else {
                        throw new EmptyDescriptionException("What?");
                    }
                } catch (InvalidCommandException | EmptyDescriptionException e) {
                    System.out.println("OOPS!!! " + e.getMessage());
                }
                continue;
            }

            try {
                if (input.startsWith("todo")) {
                    String description = input.substring(4);
                    if (description.isEmpty()) {
                        throw new EmptyDescriptionException("Haha! You don't want to do anything right?");
                    }
                    tasks.add(new Todo(description));
                    storage.save(tasks);
                    Task addedTask = tasks.get(tasks.size() - 1);
                    Ui.showAddedTask(addedTask, tasks.size());

                } else if (input.startsWith("deadline")) {
                    String input1 = input.substring(8);
                    if (!input1.contains("/by")) {
                        throw new InvalidCommandException("Deadline must have an end.");
                    }
                    String description = input1.split(" /by")[0];
                    String by = input1.split(" /by")[1];
                    tasks.add(new Deadline(description, by));
                    storage.save(tasks);
                    Task addedTask = tasks.get(tasks.size() - 1);
                    Ui.showAddedTask(addedTask, tasks.size());

                } else if (input.startsWith("event")) {
                    String input2 = input.substring(5);
                    if (!input2.contains("from")||!input2.contains("to")) {
                        throw new InvalidCommandException("Event must have a period.");
                    }
                    String description = input2.split(" /from")[0];
                    String from_1 = input2.split("/from ")[1];
                    String from = from_1.split(" /to")[0];
                    String to = input2.split("/to ")[1];
                    tasks.add(new Event(description, from, to));
                    storage.save(tasks);
                    Task addedTask = tasks.get(tasks.size() - 1);
                    Ui.showAddedTask(addedTask, tasks.size());

                } else if (input.startsWith("delete")) {
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        if (index >= 0) {
                            Task taskToBeDeleted = tasks.get(index);
                            tasks.remove(index);
                            storage.save(tasks);
                            Ui.showRemovedTask(taskToBeDeleted, tasks.size());
                        } else if (index > tasks.size()){
                            throw new InvalidCommandException("Invalid task number.");
                        } else {
                            throw new EmptyDescriptionException("What?");
                        }
                    } catch (InvalidCommandException | EmptyDescriptionException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    throw new InvalidCommandException("What?");
                }
            } catch (EmptyDescriptionException | InvalidCommandException e) {
                Ui.showError(e.getMessage());
            }
        }
        scanner.close();
    }
}
