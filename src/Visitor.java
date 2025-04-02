/**************
*  
* Visitor class that stores info about each visitor.
*
* @author Gloriele Mendoza
*
**/

import java.time.LocalDate;

public class Visitor{

    private String name;
    private LocalDate visitDate;
    private String reasonForVisiting;
    private String feedback;
    private String gradeLevel;  // First year, second year, etc.

    // Constructor
    public Visitor(String name, LocalDate visitDate, String reasonForVisiting, String feedback, String gradeLevel) {
        this.name = name;
        this.visitDate = visitDate;
        this.reasonForVisiting = reasonForVisiting;
        this.feedback = feedback;
        this.gradeLevel = gradeLevel;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public String getReasonForVisiting() {
        return reasonForVisiting;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void print() {
        System.out.println("Visitor Info:");
        System.out.println("Name: " + name);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Reason for Visiting: " + reasonForVisiting);
        System.out.println("Feedback: " + feedback);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println(); // Empty line after the visitor's info to for easier readability
    }
}