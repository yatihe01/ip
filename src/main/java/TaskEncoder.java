import java.util.List;
import java.util.ArrayList;

public class TaskEncoder {
    public static String encode(Task task) {
        if (task instanceof Deadline) {
            return "D | " + (task.isDone ? 1 : 0) + " | "
                    + task.getDescription() + " | " + ((Deadline) task).getBy();
        } else if (task instanceof Event) {
            return "E | " + (task.isDone ? 1 : 0) + " | "
                    + task.getDescription() + " | " + ((Event) task).getFrom() + ((Event) task).getTo();
        } else {
            return "T | " + (task.isDone ? 1 : 0) + " | "
                    + task.getDescription();
        }
    }
}
