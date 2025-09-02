package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    protected LocalDate from;
    protected LocalDate to;

    private static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM d yyyy");

    public Event(String description, String fromString, String toString) {
        super(description);
        this.from = LocalDate.parse(fromString, inputFormat);
        this.to = LocalDate.parse(toString, inputFormat);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(outputFormat) + " to: " + to.format(outputFormat) + ")";
    }
}
