import java.util.*;
public class StudentManagementSystem 
{
  public static Scanner input = new Scanner(System.in);
  public static void stdLogin()
  {
    input.nextLine();  
    System.out.println("\n----------> STUDENT LOGIN <----------");
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
      System.out.println("Student Login Successful!");
      System.out.println("Welcome Shehryar");
      stdPanel();
    }
    else if( stdname.equals("FA25-BDS-035") && stdpass.equals("12345") )
    {
      System.out.println("Student Login Successful!");
      System.out.println("Welcome Rafay");
      stdPanel();
    }
    else
    {
      System.out.println("\nInvalid Username or Password");
      System.out.println("\nReturning to Login menu");
      return;
    }
      
  }
  public static void admLogin()
  {
    input.nextLine();  
    System.out.println("\n----------> ADMIN LOGIN <----------");
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
      System.out.println("\nReturning to Login menu");
      return;
    }
    
  }
  public static void stdPanel()
  {
    while(true)
          {
            System.out.println("\n----------> STUDENT PANEL <----------");
            System.out.println("--- 1. View Attendance ---");
            System.out.println("--- 2. View Acadamics Report ---");
            System.out.println("--- 3. View Profile ---");
            System.out.println("--- 4. Log out ---");
            System.out.print("Enter your choice ( 1 to 6 ) : ");
            int choice = input.nextInt();
            input.nextLine();  
            switch(choice) 
            {
                case 1: 
                  stdAttendance(); 
                  break;
                case 2: 
                  stdAcadamics(); 
                  break;
                case 3: 
                  stdProfile(); 
                  break;
                case 4:
                {
                  System.out.println("Exiting The Program");
                  return;
                }
                default: 
                  System.out.println("Invalid Input!");
              }            
          }
      }
  public static void admPanel() 
      {
        while(true)
          {
            System.out.println("\n----------> ADMIN PANEL <----------");
            System.out.println("--- 1. Add Student Record ---");
            System.out.println("--- 2. View All Student Records ---");
            System.out.println("--- 3. Update Student Details ---");
            System.out.println("--- 4. Search Student Records ---");
            System.out.println("--- 5. Save Records to File ---");
            System.out.println("--- 6. Logout ---");
            System.out.print("Enter your choice ( 1 to 6 ) : ");
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
                  return;
                default: 
                  System.out.println("Invalid Input!");
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
        System.out.println("Enter your choice ( 1 to 3 ) : ");
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
              System.out.println("Exiting The Program");
              return;
            }
          default:
            System.out.println("Invalid Entry  Enter between 1 to 3");
          
        }
      }
    
    
      
   
  }
}
