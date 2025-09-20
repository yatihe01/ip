package duke;

import duke.task.Deadline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DeadlineTest {

    @Test
    public void deadline_parseDateTimeCorrectly() {
        Deadline deadline1 = new Deadline("return book", "2025-08-30 18:00");
        Assertions.assertEquals(
                LocalDateTime.of(2025, 8, 30, 18, 0),
                deadline1.getBy()
        );
    }

    @Test
    public void deadline_toStringFormatsCorrectly() {
        Deadline deadline2 = new Deadline("get 2103 ip done", "2025-09-05 23:59");
        Assertions.assertEquals(
                "[D][ ] get 2103 ip done (by: Sep 5 2025 23:59)",
                deadline2.toString()
        );
    }
}