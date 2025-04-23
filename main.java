import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        VisitorManager manager = new VisitorManager();
        Scanner scanner = new Scanner(System.in);
        boolean open = true;
        while (open) {
            System.out.println("\nEVERGREEN VISITOR LOG");
            System.out.println("1) Add a visitor");
            System.out.println("2) Display all visitors");
            System.out.println("3) Display visitors by date");
            System.out.println("4) Display visitors by grade");
            System.out.println("5) Display order of arrivals");
            System.out.println("6) Remove a visitor");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":

                    break;

                case "2":
                    manager.displayVisitors();
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":
                    manager.displaySubmissionOrder();
                    break;

                case "6":

                    break;

                case "0":
                    open = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Error! Not an option, please try again :()");
            }
        }
        scanner.close();
    }
}
