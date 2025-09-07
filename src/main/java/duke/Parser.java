package duke;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddTodoCommand;
import duke.command.ByeCommand;
import duke.command.DeleteCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.MarkCommand;
import duke.command.UnmarkCommand;
import duke.command.Command;
import duke.exception.InvalidCommandException;

public class Parser {

    public static Command parse(String input) throws InvalidCommandException {

        if (input.equalsIgnoreCase("bye")) {
            return new ByeCommand();
        } else if (input.equalsIgnoreCase("list")) {
            return new ListCommand();
        } else if (input.startsWith("mark ")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(index);
        } else if (input.startsWith("unmark ")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(index);
        } else if (input.startsWith("todo")) {
            return new AddTodoCommand(input.substring(4));
        } else if (input.startsWith("deadline")) {
            return new AddDeadlineCommand(input.substring(8));
        } else if (input.startsWith("event")) {
            return new AddEventCommand(input.substring(5));
        } else if (input.startsWith("delete")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(index);
        } else if (input.startsWith("find")) {
            return new FindCommand(input.substring(4));
        } else {
            throw new InvalidCommandException("What?");
        }
    }
}