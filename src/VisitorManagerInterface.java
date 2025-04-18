/**************
*  
* Interface that describes the operations for the VisitorRegistry class.
*
* @author Gloriele Mendoza
*
**/
import java.time.LocalDate;
import java.util.List;

public interface VisitorManagerInterface {

    // Adds a new visitor to the registry
    void addVisitor(String name, LocalDate visitDate, String reasonForVisiting, String feedback);

    // Displays all visitors in the registry
    void displayVisitors();

    // Filters visitors by a specific visit date
    List<Visitor> filterVisitorsByDate(LocalDate date);

    // Outputs visitors by visit date
    void displayVisitorsByDate(LocalDate date);
	
	//Outputs visitors by their grade level(first year, second year, third year, fourth year, other)
	void displayVisitorsByGrade(String gradeLevel);
    
    // Optional: Removes a visitor by their name (or ID)
    void removeVisitor(String name);
}