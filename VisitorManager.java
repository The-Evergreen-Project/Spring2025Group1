import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorManager implements VisitorManagerInterface {
    private List<Visitor> visitorList;

    public VisitorManager() {
        visitorList = new ArrayList<>();
    }

    // add a visitor
    @Override
    public void addVisitor(String name, LocalDate visitDate, String reasonForVisiting, String feedback, String gradeLevel) {
        Visitor newVisitor = new Visitor(name, visitDate, reasonForVisiting, feedback, gradeLevel);
        visitorList.add(newVisitor);
    }

    @Override
    public void displayVisitors() 


    @Override
    public List<Visitor> filterVisitorsByDate(LocalDate date) 


    @Override
    public void displayVisitorsByDate(LocalDate date) 


    @Override
    public void displayVisitorsByGrade(String gradeLevel) 
    

    @Override
    public void removeVisitor(String name) 
}
