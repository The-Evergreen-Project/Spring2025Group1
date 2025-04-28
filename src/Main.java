import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VisitorManager manager = new VisitorManager();
        try (Scanner scanner = new Scanner(System.in); PrintWriter writer = new PrintWriter(new FileWriter("visitor_log.txt"))) {
            boolean open = true;
            
            while (open) {
                System.out.println("\nEVERGREEN VISITOR LOG");
                System.out.println("1) Add a visitor");
                System.out.println("2) Display all visitors");
                System.out.println("3) Display visitors by date");
                System.out.println("4) Display visitors by grade");
                System.out.println("5) Display order of arrivals");
                System.out.println("6) Remove a visitor");
                System.out.println("7) Register a visitor for an event");
                System.out.println("0) Exit");
                
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();
                
                switch (choice) {
                    case "1":
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Visit Date (yyyy-mm-dd): ");
                        LocalDate visitDate=null;
                        
                        while(visitDate==null){
                            try {
                                String dateInput = scanner.nextLine();
                                visitDate = LocalDate.parse(dateInput);
                                
                            } catch (Exception e) {
                                System.out.println("Not a valid date. Please enter the date in the format (yyyy-mm-dd).");
                                
                            }
                        }
                        
                        System.out.print("What is the reason for visiting: ");
                        String reason = scanner.nextLine();
                        
                        System.out.print("Feedback: ");
                        String feedback = scanner.nextLine();
                        
                        System.out.print("Grade Level (if applicable): ");
                        String grade = scanner.nextLine();
                        
                        manager.addVisitor(name, visitDate, reason, feedback, grade, writer);
                        System.out.println("Visitor added.");
                        break;
                        
                    case "2":
                        manager.displayVisitors();
                        break;
                        
                    case "3":
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        String filterDate = scanner.nextLine();
                        try {
                            LocalDate filter = LocalDate.parse(filterDate);
                            manager.displayVisitorsByDate(filter);
                        } catch (DateTimeParseException e) {
                            System.out.println("error! Invalid date format :(");
                        }
                        break;
                        
                    case "4":
                        System.out.print("Enter grade level to filter: ");
                        String level = scanner.nextLine();
                        manager.displayVisitorsByGrade(level);
                        break;
                        
                    case "5":
                        manager.displaySubmissionOrder();
                        break;
                        
                    case "6":
                        System.out.print("Enter visitor name to remove: ");
                        String removeName = scanner.nextLine();
                        manager.removeVisitor(removeName, writer);
                        break;

                    case "7":
                        System.out.print("Enter visitor name to register for an event: ");
                        String nameForEvent = scanner.nextLine();

                        System.out.print("Enter event name: ");
                        String eventName = scanner.nextLine();

                        System.out.print("Enter event date (yyyy-mm-dd): ");
                        LocalDate eventDate = null;
                        
                        while(eventDate==null){
                            try {
                                String dateInput = scanner.nextLine();
                                eventDate = LocalDate.parse(dateInput);
                                
                            } catch (Exception e) {
                                System.out.println("Not a valid date. Please enter the date in the format (yyyy-mm-dd).");
                                
                            }
                        }
                        manager.registerForEvent(nameForEvent, eventName, eventDate, writer);
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
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using the Visitor Log system.");
        }
    }
}
