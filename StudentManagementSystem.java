import java.util.*;
public class StudentManagementSystem 
{
  public static Scanner input = new Scanner(System.in);
  public static void stdLogin()
  {
    System.out.println("----------> STUDENT LOGIN <----------");
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("USERNAME : ");
    String stdname = input.nextLine();
    System.out.println();
    System.out.println();
    System.out.println("PASSWORD : ");
    String stdpass = input.nextLine();
    System.out.println("Login Successful!");
    studentMenu();
  }
  public static void admLogin()
  {
    System.out.println("----------> ADMIN LOGIN <----------");
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("USERNAME : ");
    String admname = input.nextLine();
    System.out.println();
    System.out.println();
    System.out.println("PASSWORD : ");
    String admpass = input.nextLine();
    System.out.println("Admin Login Successful!");
    adminMenu();
  }
  public static void main(String[] args) 
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
    System.out.println("Enter your choice: ");
    int choice = input.nextInt();
    switch(choice)
      {
        case 1:
          stdLogin();
        case 2:
          admLogin();
        case 3:
          {
            System.out.println("Exiting The Program");
            return;
          }
        default:
          {
            System.out.println("Invalid Entry  Enter between 1 to 3");
          }
      }
      public static void adminMenu() {
        while(true)
          {
             System.out.println("\n----------> ADMIN MENU <----------");
            System.out.println("1. Add Student Record");
            System.out.println("2. View All Student Records");
            System.out.println("3. Update Student Details");
            System.out.println("4. Search Student Records");
            System.out.println("5. Save Records to File");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch(choice) {
                case 1: addRecord(); break;
                case 2: viewRecord(); break;
                case 3: updateRecord(); break;
                case 4: searchRecord(); break;
                case 5: saveToFile(); break;
                case 6: return;
                default: System.out.println("Invalid Input!");
              }            
          }
      }
   
  }
}
