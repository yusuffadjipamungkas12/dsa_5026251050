package lw01.Latianuts-01;

public class couse {
    //attribute 
    private String courseCode;
    private String title; 
    private String instructor; 
    private int creditHours;  

    //constructor
    public couse(String courseCode, String title, String instructor, int creditHours){
        this.courseCode = courseCode; 
        this.title = title; 
        this.instructor = instructor; 
        this.creditHours= creditHours; 
    }

    //method 
    public void startClass(){
        System.out.println("This course " + title + " is now starting tasks.");
    } 

    public void endClass(){
        System.out.println("This course " + title + " is now ending tasks.");
    }
    public void assignTask(){
        System.out.println("This course " + title + " is now assign tasks."); 
    }
    public void displayInfo()
}
