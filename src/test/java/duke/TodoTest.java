package duke;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodoTest {

    @Test
    public void todo_toStringFormatsCorrectly() {
        Todo todoTest = new Todo("do 2103 ip");
        Assertions.assertEquals("do 2103 ip", todoTest.toString());
    }
}
