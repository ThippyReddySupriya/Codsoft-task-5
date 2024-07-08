
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem{
    private static ArrayList<Student>students=new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    
    public static void main(String[]args){
        int choice;
        do{
            displayMenu();
            choice=scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("Existing Student Management System");
                    break;
                default:
                    System.out.println("Invalid choice!");        
            }   
        }while(choice!=5);
    }
    private static void displayMenu(){
        System.out.println("\nStudent Management System");
        System.out.println("1.AddS Student");
        System.out.println("2.Remove student");
        System.out.println("3.Search Student");
        System.out.println("4.Display All Students");
        System.out.println("5.Exit");
        System.out.print("Enter your choice");   
    }
    
    private static void addStudent(){
        System.out.print("Enter student name:");
        String name=scanner.nextLine();
        System.out.print("Enter student roll number:");
        int rollNumber=validateIntegerInput();
        System.out.print("Enter student grade:");
        String grade=scanner.nextLine();
        
        Student student=new Student(name,rollNumber,grade);
        students.add(student);
        System.out.println("Student added successfully!");    
    }
    
    private static void removeStudent(){
        System.out.print("Enter roll number of student to remove:");
        int rollNumber=validateIntegerInput();
        Student studentToRemove=findStudent(rollNumber);
        if(studentToRemove!=null){
            students.remove(studentToRemove);
            System.out.println("Student removed successfully!");
        }else{
            System.out.println("Student not found!");
        }
    }
    private static void searchStudent(){
        System.out.print("Enter roll number of student to search:");
        int rollNumber=validateIntegerInput();
        Student student=findStudent(rollNumber);
        if(student!=null){
            System.out.println(student);
        }else{
            System.out.println("Student not found!");
        }
    }
    
    private static void displayStudents(){
        if(students.isEmpty()){
        System.out.println("No students found!");
        }
        else{
            System.out.println("List of Students:");
            for(Student student:students){
            System.out.println(student);
            }
        }
    }
    
    private static Student findStudent(int rollNumber){
        for(Student student:students){
            if(student.getRollNumber()==rollNumber){
                return student;
            }
        }
        return null;
    }
    
    private static int validateIntegerInput(){
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input!Please enter an integer:");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

  
    
}
class Student{
    private String name;
    private int rollNumber;
    private String grade;
    
    public Student(String name,int rollNumber,string grade){
        this.name=name;
        this.rollNumber=rollNumber;
        this.grade=grade;
    }
    public String getName(){
        return name;
    }
    public int RollNumber(){
        return rollNumber;
    }
    public String getGrade(){
        return grade;
    }
    @Override
    public String toString(){
        return"Student[name="+name+",rollNumber="+rollNumber+",grade="+grade+"]";
    }
}