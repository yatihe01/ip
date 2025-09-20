package duke;

import duke.task.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TaskTest {

    @Test
    public void markAsDone_setIsDoneTrue() {
        Task task = new Task("read book");
        task.markAsDone();
        Assertions.assertTrue(task.isDone, "Task should be marked as done");
        Assertions.assertEquals("X", task.getStatusIcon());
    }

    @Test
    public void unmarkAsDone_setIsDoneFalse() {
        Task task = new Task("read book");
        task.markAsDone();
        task.unmarkAsDone();
        Assertions.assertFalse(task.isDone, "Task should be unmarked as done");
        Assertions.assertEquals(" ", task.getStatusIcon());
    }

    @Test
    public void toString_formatCorretly() {
        Task task = new Task("read book");
        Assertions.assertEquals("[ ] read book", task.toString());
        task.markAsDone();
        Assertions.assertEquals("[X] read book", task.toString());
    }
}
