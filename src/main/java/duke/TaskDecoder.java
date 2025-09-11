package duke;

public class TaskDecoder {
    public static Task decode(String line) {
        String[] parts = line.split(" \\| ");
        String taskType = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task;
        switch (taskType) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                task = new Deadline(description, parts[3]);
            case "E":
                task = new Event(description, parts[3], parts[4]);
                break;
            default:
                throw new IllegalArgumentException("Unknown task type: " + taskType);
        }
        if (isDone) {
            task.markAsDone();
        }
        return task;
    }
}
