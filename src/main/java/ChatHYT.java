import java.util.Scanner;
public class ChatHYT {
    static Scanner scanner = new Scanner(System.in);
    static Task[] tasks = new Task[100];
    static int taskCount = 0;
    public static void main(String[] args) {
        System.out.println("Hello! I'm ChatHYT");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        while(true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
                continue;
            }

            if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if (index >=0 && index < taskCount) {
                    tasks[index].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks[index]);
                    System.out.println("____________________________________________________________");
                }
                continue;
            }

            if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].unmarkAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[index]);
                    System.out.println("____________________________________________________________");
                }
            }

            if (taskCount < 100 && input.startsWith("todo ")) {
                String description = input.substring(4);
                tasks[taskCount] = new Todo(description);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[taskCount - 1]);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");
            }

            if (taskCount < 100 && input.startsWith("deadline ")) {
                String input1 = input.substring(8);
                String description = input1.split(" /by")[0];
                String by = input1.split(" /by")[1];
                tasks[taskCount] = new Deadline(description, by);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[taskCount - 1]);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");
            }

            if (taskCount < 100 && input.startsWith("event ")) {
                String input2 = input.substring(5);
                String description = input2.split(" /from")[0];
                String from_1 = input2.split("/from ")[1];
                String from = from_1.split(" /to")[0];
                String to = input2.split("/to ")[1];
                tasks[taskCount] = new Event(description, from, to);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[taskCount - 1]);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");
            }
        }

        scanner.close();
    }
}
