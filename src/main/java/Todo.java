public class Todo extends Task{
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
