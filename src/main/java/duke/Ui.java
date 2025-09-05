package duke;

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
        return "Hello! I'm ChatHYT\n" +
                "What can I do for you?\n" +
                "____________________________________________________________";
    }

    public static String sayGoodbye() {
        return "____________________________________________________________\n" +
        "Bye. Hope to see you again soon!\n" +
        "____________________________________________________________";
    }

    public static String showList(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) return "No tasks in your list.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + "." + tasks.get(i) + "\n");
        }
        return sb.toString().trim();
    }

    public static String showListToBeFound(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) return "No matching tasks found.";
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + "." + tasks.get(i) + "\n");
        }
        return sb.toString().trim();
    }

    public static String showMark(Task task) {
        return "Nice! I've marked this task as done:\n  " + task;
    }

    public static String showUnmark(Task task) {
        return "OK, I've marked this task as not done yet:\n  " + task;
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

}

