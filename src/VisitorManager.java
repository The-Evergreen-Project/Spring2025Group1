import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VisitorManager implements VisitorManagerInterface {
    private List<Visitor> visitorList; // List to store all visitors
    private LinkedList<Visitor> visitorQueue; // Queue to manage visitors in order of arrival

    public VisitorManager() {
        visitorList = new ArrayList<>();
        visitorQueue = new LinkedList<>();
    }

    // add a visitor
    @Override
    public void addVisitor(String name, LocalDate visitDate, String reasonForVisiting, String feedback, String gradeLevel, PrintWriter writer) {
        Visitor newVisitor = new Visitor(name, visitDate, reasonForVisiting, feedback, gradeLevel);
        visitorList.add(newVisitor);
        visitorQueue.add(newVisitor); // Add to queue as well
        writer.println("Visitor \"" + name + "\" added to the registry.");
    }

    @Override
    public void displayVisitors() {
        if (visitorList.isEmpty()) {
            System.out.println("No visitors to display.");
        } else {
            for (Visitor visitor : visitorList) {
                visitor.print();
            }
        }
    }


    @Override
    public List<Visitor> filterVisitorsByDate(LocalDate date) {
        List<Visitor> filteredList = new ArrayList<>();
        for (Visitor visitor : visitorList) {
            if (visitor.getVisitDate().equals(date)) {
                filteredList.add(visitor);
            }
        }
        return filteredList;
    }


    @Override
    public void displayVisitorsByDate(LocalDate date) {
        List<Visitor> visitorsOnDate = filterVisitorsByDate(date);
        int count = 0; 
        if (visitorsOnDate.isEmpty()) {
            System.out.println("No visitors found on " + date + ".");
        } else {
            for (Visitor visitor : visitorsOnDate) {
                visitor.print();
                count++;
            }
            System.out.println("Total visitors on " + date + ": " + count);
        }

    }

    public void displaySubmissionOrder() {//this displays the default order of visitors in queue based on arrival
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
        } else {
            System.out.println("Visitors in submission order:");
            for (Visitor visitor : visitorQueue) {
                visitor.print();
            }
        }
    }

    @Override
    public void displayVisitorsByGrade(String gradeLevel) {
        boolean found = false;
        for (Visitor visitor : visitorList) {
            if (visitor.getGradeLevel().equalsIgnoreCase(gradeLevel)) {
                visitor.print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No visitors found in grade level: " + gradeLevel);
        }
    }
    
    

    @Override
    public void removeVisitor(String name, PrintWriter writer) {
        Visitor toRemove = null;
    for (Visitor visitor : visitorList) {
        if (visitor.getName().equalsIgnoreCase(name)) {
            toRemove = visitor;
            break;
        }
    }

    if (toRemove != null) {
        visitorList.remove(toRemove);
        visitorQueue.remove(toRemove); // Also remove from the queue
        writer.println("Visitor \"" + name + "\" removed.");
        System.out.println("Visitor \"" + name + "\" removed.");
    } 
    else {
        System.out.println("Visitor \"" + name + "\" not found.");
    }
    }

    @Override
    public void registerForEvent(String name, String eventName, LocalDate eventDate, Scanner scan, PrintWriter writer) {
        for (Visitor visitor : visitorList) {
            if (visitor.getName().equalsIgnoreCase(name)) {
                writer.println("Visitor \"" + name + "\" registered for event: " + eventName + " on " + eventDate);
                System.out.println("Visitor \"" + name + "\" registered for event: " + eventName + " on " + eventDate);
                return;
            }
        }
        System.out.println("Visitor \"" + name + "\" not found. Would you like to add them to the visitor log first? (yes/no)");
        String response = scan.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            addVisitor(name, eventDate, "Event Registration", "", "N/A", writer);
            writer.println("Visitor \"" + name + "\" registered for event: " + eventName + " on " + eventDate);
        } else {
            System.out.println("Visitor not registered for the event.");
        }

    }
}