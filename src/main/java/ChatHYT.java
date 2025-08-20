import java.util.Scanner;
public class ChatHYT {
    static Scanner scanner = new Scanner(System.in);
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

            System.out.println("____________________________________________________________");
            System.out.println(input);
            System.out.println("____________________________________________________________");
        }

        scanner.close();
    }
}
