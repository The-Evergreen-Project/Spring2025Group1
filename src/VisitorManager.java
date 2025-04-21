import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VisitorManager implements VisitorManagerInterface {
    private List<Visitor> visitorList; // List to store all visitors
    private LinkedList<Visitor> visitorQueue; // Queue to manage visitors in order of arrival

    public VisitorManager() {
        visitorList = new ArrayList<>();
        visitorQueue = new LinkedList<>();
    }

    // add a visitor
    @Override
    public void addVisitor(String name, LocalDate visitDate, String reasonForVisiting, String feedback, String gradeLevel) {
        Visitor newVisitor = new Visitor(name, visitDate, reasonForVisiting, feedback, gradeLevel);
        visitorList.add(newVisitor);
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
        if (visitorsOnDate.isEmpty()) {
            System.out.println("No visitors found on " + date + ".");
        } else {
            for (Visitor visitor : visitorsOnDate) {
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
    public void removeVisitor(String name) {
        Visitor toRemove = null;
    for (Visitor visitor : visitorList) {
        if (visitor.getName().equalsIgnoreCase(name)) {
            toRemove = visitor;
            break;
        }
    }

    if (toRemove != null) {
        visitorList.remove(toRemove);
        System.out.println("Visitor \"" + name + "\" removed.");
    } 
    else {
        System.out.println("Visitor \"" + name + "\" not found.");
    }
    }
}
