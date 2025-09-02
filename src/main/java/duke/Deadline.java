package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private LocalDate by;

    private static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM d yyyy");

    public Deadline(String description, String byString) {
        super(description);
        this.by = LocalDate.parse(byString, inputFormat);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public LocalDate getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by.format(outputFormat) + ")";
    }
}
