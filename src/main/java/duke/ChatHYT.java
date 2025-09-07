package duke;

import java.util.Scanner;
import java.util.ArrayList;

import duke.command.Command;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidCommandException;

public class ChatHYT {
    private static final Scanner scanner = new Scanner(System.in);
    private static Storage storage = new Storage("./data/duke.txt");
    private static TaskList taskList = new TaskList(storage.load());


    public static void main(String[] args) {
        taskList = new TaskList(storage.load());
        System.out.println(Ui.showWelcome());

        while (true) {
            String input = scanner.nextLine();
            try {
                Command command = Parser.parse(input);
                command.execute(taskList.getAllTasks(), storage, new Ui());
                if (command.isExit()) {
                    break;
                }
            } catch (Exception e) {
                Ui.showError(e.getMessage());
            }
        }

        scanner.close();
    }

    /**
     * Generates a response for the user's chat message (for GUI mode)
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            String response = command.execute(taskList.getAllTasks(), storage, new Ui());
            return response;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
