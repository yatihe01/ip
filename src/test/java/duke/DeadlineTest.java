package duke;

import duke.task.Deadline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class DeadlineTest {

    @Test
    public void deadline_parseDateCorretly() {
        Deadline deadline1 = new Deadline("return book", "2025-08-30");
        Assertions.assertEquals(LocalDate.of(2025, 8, 30), deadline1.getBy());
    }

    @Test
    public void deadline_toStringFormatsCorrectly() {
        Deadline deadline2 = new Deadline("get 2103 ip done", "2025-09-05");
        Assertions.assertEquals("[D][ ] get 2103 ip done (by: Sep 05 2025)", deadline2.toString());
    }
}
