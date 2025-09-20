package duke;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public static String showWelcome() {
        return "Good day! I'm ChatHYT.\n" +
                "How can I help you? \n";
    }

    public static String sayGoodbye() {
        return "Bye. Hope to see you again soon!\n";
    }

    public static String showList(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) return "No tasks yet, find yourself some work";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + "." + tasks.get(i) + "\n");
        }
        return sb.toString().trim();
    }

    public static String showListToBeFound(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) return "No matching tasks found. Try other keywords?";
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + "." + tasks.get(i) + "\n");
        }
        return sb.toString().trim();
    }

    public static String showMark(Task task) {
        return "Nice to see that you have completed it:\n  " + task;
    }

    public static String showUnmark(Task task) {
        return "It's ok, take your time:\n  " + task;
    }

    public static String showAddedTask(Task task, int size) {
        return "Got it. I've added this task:\n  "
                + task + "\nNow you have "
                + size + " tasks in the list.";
    }

    public static String showRemovedTask(Task task, int size) {
        return "Noted. I've removed this task:\n  "
                + task + "\nNow you have "
                + size + " tasks in the list.";
    }

    public static String showError(String message) {
        return message;
    }

    public static String displaySchedule(LocalDate date, ArrayList<Task> tasks) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;

        for (Task taskToBeChecked : tasks) {
            if (taskToBeChecked instanceof Deadline) {
                Deadline deadline = (Deadline) taskToBeChecked;
                if (deadline.getBy().toLocalDate().equals(date)) {
                    sb.append(counter++).append(". ").append(taskToBeChecked).append("\n");
                }
            } else if (taskToBeChecked instanceof Event) {
                Event event = (Event) taskToBeChecked;
                if (!date.isBefore(event.getFrom().toLocalDate()) && !date.isAfter(event.getTo().toLocalDate())) {
                    sb.append(counter++).append(". ").append(taskToBeChecked).append("\n");
                }
            } else {
                sb.append(counter++).append(". ").append(taskToBeChecked).append("\n");
            }
        }
        return sb.toString().trim();
    }

}

