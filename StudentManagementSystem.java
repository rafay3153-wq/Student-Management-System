import java.io.*;
import java.util.*;
public class StudentManagementSystem 
{
  public static Scanner input = new Scanner(System.in);
  static String[] LoggedName = new String[100];
  static int[] LoggedAge = new int[100];
  public static String LoggedDOB = "";
  static int[] LoggedRollNo =  new int[100];
  public static double LoggedCGPA = 0.0;
  static int[] attendance = new int[100];
  public static String LoggedGrade = "";
  static int count=0;
  public static void stdLogin()
  {
    input.nextLine();  
    System.out.println("\n\n----------> STUDENT LOGIN <----------");
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("USERNAME : ");
    String stdname = input.nextLine();
    System.out.println();
    System.out.println();
    System.out.println("PASSWORD : ");
    String stdpass = input.nextLine();
    
    if( stdname.equals("FA25-BDS-045") && stdpass.equals("28076") )
    {
      LoggedName = "Shehryar Khurram";
      LoggedAge = 18;
      LoggedRollNo = 45;
      LoggedDOB = "29 December 2006";
      System.out.println("Student Login Successful!");
      System.out.println("Welcome Shehryar");
      stdPanel();
    }
    else if( stdname.equals("FA25-BDS-035") && stdpass.equals("12345") )
    {
      LoggedName = "Muhammad Rafay";
      LoggedAge = 20;
      LoggedRollNo = 35;
      LoggedDOB = "29 October 2005";
      System.out.println("Student Login Successful!");
      System.out.println("Welcome Rafay");
      stdPanel();
    }
    else
    {
      System.out.println("\nInvalid Username or Password");
      System.out.println("\nReturning to Login menu\n\n");
      return;
    }
      
  }
  public static void admLogin()
  {
    input.nextLine();  
    System.out.println("\n\n----------> ADMIN LOGIN <----------");
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("USERNAME : ");
    String admname = input.nextLine();
    System.out.println();
    System.out.println();
    System.out.println("PASSWORD : ");
    String admpass = input.nextLine();
    if( admname.equals("teacher1") && admpass.equals("0011") )
    {
      System.out.println("Admin Login Successful!");
      System.out.println("Welcome Teacher1");
      admPanel();
    }
    else if( admname.equals("teacher2") && admpass.equals("3322") )
    {
      System.out.println("Admin Login Successful!");
      System.out.println("Welcome Teacher2");
      admPanel();
    }
    else
    {
      System.out.println("\nInvalid Username or Password");
      System.out.println("\nReturning to Login menu\n\n");
      return;
    }
    
  }
  public static void stdPanel()
  {
    while(true)
          {
            System.out.println("\n\n----------> STUDENT PANEL <----------");
            System.out.println("--- 1. View Attendance ---");
            System.out.println("--- 2. View Acadamics Report ---");
            System.out.println("--- 3. View Profile ---");
            System.out.println("--- 4. Log out ---");
            System.out.println("\nEnter your choice ( 1 to 4 ) : ");
            if (!input.hasNextInt()) 
            {
              System.out.println("Please enter numbers only!");
              System.out.println("\nReturning to Student Panel\n\n");
              input.nextLine();
              continue;
            }
            int choice = input.nextInt();
            input.nextLine();  
            switch(choice) 
            {
                case 1: 
                  stdAttendance(); 
                  break;
                case 2: 
                  stdAcademics(); 
                  break;
                case 3: 
                  stdProfile(); 
                  break;
                case 4:
                {
                  System.out.println("\nReturning to Login Menu");
                  return;
                }
                default: 
                  System.out.println("\nInvalid Entry  Enter between 1 to 4\n\n");
              }            
          }
      }
  public static void admPanel() 
      {
        while(true)
          {
            System.out.println("\n\n----------> ADMIN PANEL <----------");
            System.out.println("--- 1. Add Student Record ---");
            System.out.println("--- 2. View All Student Records ---");
            System.out.println("--- 3. Update Student Details ---");
            System.out.println("--- 4. Search Student Records ---");
            System.out.println("--- 5. Save Records to File ---");
            System.out.println("--- 6. Logout ---");
            System.out.println("\nEnter your choice ( 1 to 6 ) : ");
            if (!input.hasNextInt()) 
            {
              System.out.println("\nPlease enter numbers only!");
              System.out.println("\nReturning to Admin Panel\n\n");
              input.nextLine();
              continue;
            }
            int choice = input.nextInt();
            input.nextLine();  
            switch(choice) 
            {
                case 1: 
                  addRecord(); 
                  break;
                case 2: 
                  viewRecord(); 
                  break;
                case 3: 
                  updateRecord(); 
                  break;
                case 4: 
                  searchRecord(); 
                  break;
                case 5: 
                  saveToFile(); 
                  break;
                case 6:
                  System.out.println("\nReturning to Login Menu\n\n");
                  return;
                default: 
                  System.out.println("\nInvalid Entry  Enter between 1 to 6");
              }            
          }
      }
  public static void stdAttendance() 
  {
    System.out.println("\n\n----------> STUDENT ATTENDANCE <----------");
    if(count == 0){
            System.out.println("No records available.");
            return;
    }
        for(int i=0; i<count; i++){
            String[] names;
            System.out.println(names[i] + " | Attendance: " + attendance[i] + "%");
        }
    
    System.out.println("\nPress Enter to return to Student Panel...\n\n");
    input.nextLine();
}
  public static void stdAcademics() 
  {
    System.out.println("\n\n----------> ACADEMICS REPORT <----------");
    int count = 0;
    if(count == 0){
            System.out.println("No records available.");
            return;
    }
    System.out.printf("%-15s %-10s %-12s %-10s %-10s\n", "Name", "Marks", "Percentage", "Grade", "CGPA");
    for(int i=0; i<count; i++){
            int[] marks = null;
            int mark = marks[i];
            double percentage = mark; 
            String grade = calculateGrade(mark);
            double cgpa = calculateCGPA(mark);
            Object[] names = null;
            System.out.printf("%-15s %-10d %-12.2f %-10s %-10.2f\n", names[i], mark, percentage, grade, cgpa);
        }
    
    
    System.out.println("\nPress Enter to return to Student Panel...\n\n");
    input.nextLine();  
  }
  public static void stdProfile() 
  {
    System.out.println("\n\n----------> STUDENT PROFILE <----------");
    System.out.println("\nName : \t" + LoggedName);
    System.out.println("\nAge : \t" + LoggedAge);
    System.out.println("\nDate Of Birth : \t" + LoggedDOB);
    System.out.println("\nRoll Number : \t" + LoggedRollNo);
    System.out.println("\nPress Enter to return to Student Panel...\n\n");
    input.nextLine();
  }
  public static void addRecord() 
  {
    System.out.println("\n\n----------> ADD RECORD <----------");
    
    System.out.println("\nPress Enter to return to Admin Panel...\n\n");
    input.nextLine();
  }
  public static void viewRecord() 
  {
    System.out.println("\n\n----------> VIEW RECORD <----------");
    
    System.out.println("\nPress Enter to return to Admin Panel...\n\n");
    input.nextLine();
  }
  public static void updateRecord() 
  {
    System.out.println("\n\n----------> UPDATE RECORD <----------");
    
    System.out.println("\nPress Enter to return to Admin Panel...\n\n");
    input.nextLine();
  }
  public static void searchRecord() 
  {
    System.out.println("\n\n----------> SEARCH RECORD <----------");
    
    System.out.println("\nPress Enter to return to Admin Panel...\n\n");
    input.nextLine();
  }
  public static void saveToFile() 
  {
    System.out.println("\n\n----------> FILE SAVING <----------");
    
    System.out.println("\nPress Enter to return to Admin Panel...\n\n");
    input.nextLine();
  }
  public static int safeIntInput(){
        while(true){
            try{
                return input.nextInt();
            }catch(Exception e){
                System.out.print("Invalid input! Enter again: ");
                input.nextLine();
            }
        }
    }
  public static void main(String[] args) 
  {
    while(true)
      {
        System.out.println("----------> STUDENT MANAGEMENT SYSTEM <----------");
        System.out.println("----------> SHEHRYAR KHURRAM FA25-BDS-045 <----------");
        System.out.println("----------> MUHAMMAD RAFAY FA25-BDS-035 <----------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------> LOGIN MENU <----------");
        System.out.println("--- 1. STUDENT LOGIN ---");
        System.out.println("--- 2. ADMIN LOGIN ---");
        System.out.println("--- 3. EXIT ---");
        System.out.println("\nEnter your choice ( 1 to 3 ) : ");
        if (!input.hasNextInt()) 
            {
              System.out.println("\nPlease enter numbers only!");
              System.out.println("\nReturning to Login Menu\n\n");
              input.nextLine();
              continue;
            }
        int choice = input.nextInt();
        switch(choice)
        {
          case 1:
            stdLogin();
            break;
          case 2:
            admLogin();
            break;
          case 3:
            {
              System.out.println("\nExiting The Program");
              return;
            }
          default:
            System.out.println("\nInvalid Entry  Enter between 1 to 3\n\n");
        }
      }
  }
}
