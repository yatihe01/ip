package duke;

import java.util.Scanner;
import java.util.ArrayList;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

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
                        assert index >= 0 : "Index should be non-negative";
                        assert index < tasks.size() : "Index should be within task list bounds";
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
                    addTask(new Todo(description));

                } else if (input.startsWith("deadline")) {
                    String input_deadline = input.substring(8);
                    if (!input_deadline.contains("/by")) {
                        throw new InvalidCommandException("Deadline must have an end.");
                    }
                    String description = input_deadline.split(" /by")[0];
                    String by = input_deadline.split(" /by")[1];
                    addTask(new Deadline(description, by));

                } else if (input.startsWith("event")) {
                    String input_event = input.substring(5);
                    if (!input_event.contains("from")||!input_event.contains("to")) {
                        throw new InvalidCommandException("Event must have a period.");
                    }
                    String description = input_event.split(" /from")[0];
                    String from_1 = input_event.split("/from ")[1];
                    String from = from_1.split(" /to")[0];
                    String to = input_event.split("/to ")[1];
                    assert !description.isEmpty() : "Event description cannot be empty";
                    assert !from.isEmpty() : "Event start time cannot be empty";
                    assert !to.isEmpty() : "Event end time cannot be empty";
                    addTask(new Event(description, from, to));

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
                } else if (input.startsWith("find")) {
                        String keyword = input.substring(4);
                        for (int i = 0; i < tasks.size(); i++) {
                            if (tasks.get(i).getDescription().contains(keyword)) {
                                tasks_to_be_found.add(tasks.get(i));
                            }
                        }
                    Ui.showListToBeFound(tasks_to_be_found);
                } else {
                    throw new InvalidCommandException("What?");
                }
            } catch (EmptyDescriptionException | InvalidCommandException e) {
                Ui.showError(e.getMessage());
            }
        }
        scanner.close();
    }

    private static void addTask(Task task) {
        tasks.add(task);
        storage.save(tasks);
        Ui.showAddedTask(task, tasks.size());
    }
}
