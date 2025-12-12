import java.io.*;
import java.util.*;
public class StudentManagementSystem
{
    public static Scanner input = new Scanner(System.in);
    public static String LoggedName = "";
    public static int LoggedAge = 0;
    public static String LoggedDOB = "";
    public static int LoggedRollNo = 0;
    public static double LoggedCGPA = 0.0;
    public static int LoggedAttendance = 0;
    public static String LoggedGrade = "";
    static int count=0;
    static int[] marks = new int[100];
    static int[] attendance = new int[100];
    static String[] names = new String[100];
    static double[] cgpa = new double[100];
    static String[] grade = new String[100];
    static int[] ages = new int[100];
    static int[] ids = new int[100];
    static String [] username = new String [4];
    static String [] password = new String [4];

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
        boolean noerrorstd = false;
        while(!noerrorstd)
        {
          try
          {
            File file = new File("usernames.txt");
            Scanner reader = new Scanner(file);
            int i = 0;
            
            while(reader.hasNextLine() &&  i < 2)
            {
                username [i] =  reader.nextLine();
                i++;
            }
            reader.close();
            noerrorstd = true;
          }
        catch(FileNotFoundException e)
        {
            System.out.println("Error File Not Found: " + e.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println("Error During Reading The File: " + ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
      }
        
      boolean noerrorpassstd = false;
      while(!noerrorpassstd)
      {
        try
        {
            File newfile = new File("passwords.txt");
            Scanner readerpass = new Scanner(newfile);
            int j = 0;
            
            while(readerpass.hasNextLine() &&  j < 2)
            {
                password [j] =  readerpass.nextLine();
                j++;
            }
            readerpass.close();
            noerrorpassstd = true;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error File Not Found: " + e.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println("Error During Reading The File: " + ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
      }
        boolean stderror = false;
        while(!stderror)
        {
          try
          {
            if( stdname.equals(username[0]) && stdpass.equals(password[0])) 
            {
              LoggedName = "Shehryar Khurram";
              LoggedAge = 18;
              LoggedRollNo = 45;
              LoggedDOB = "29 December 2006";
              System.out.println("Student Login Successful!");
              System.out.println("Welcome Shehryar");
              stdPanel();
            }
            else if( stdname.equals(username[1]) && stdpass.equals(password[1]) )
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
          stderror = true;
          }
          catch(Exception e)
          {
            System.out.println("Error : " + e.getMessage());
          }
        }
        stdPanel();
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
        boolean noerroradm = false;
        while(!noerroradm)
        {
          try
          {
            File file = new File("usernames.txt");
            Scanner reader = new Scanner(file);
            reader.nextLine();
            reader.nextLine();
            int p = 2;
            while(reader.hasNextLine() && p < 4)
            {
                username [p] =  reader.nextLine();
                p++;
            }
            reader.close();
            noerroradm = true;
          }
        catch(FileNotFoundException e)
        {
            System.out.println("Error File Not Found: " + e.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println("Error During Reading The File: " + ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
      }
        
      boolean noerrorpassadm = false;
      while(!noerrorpassadm)
      {
        try
        {
            File newfile = new File("passwords.txt");
            Scanner readerpass = new Scanner(newfile);
            readerpass.nextLine();
            readerpass.nextLine();
            int k = 2;
            while(readerpass.hasNextLine() &&  k < 4)
            {
                password [k] =  readerpass.nextLine();
                k++;
            }
            readerpass.close();
            noerrorpassadm = true; 
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error File Not Found: " + e.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println("Error During Reading The File: " + ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
      }
        boolean admerror = false;
        while(!admerror)
        {
          try
          {
            if( admname.equals(username[2]) && admpass.equals(password[2])) 
            {
              System.out.println("Admin Login Successful!");
              System.out.println("Welcome Teacher 1");
              admPanel();
            }
            else if( admname.equals(username[3]) && admpass.equals(password[3]) )
            {
              System.out.println("Admin Login Successful!");
              System.out.println("Welcome Teacher 2");
              admPanel();
            }
            else
            {
              System.out.println("\nInvalid Username or Password");
              System.out.println("\nReturning to Login menu\n\n");
              return;
            }
          admerror = true;
          }
          catch(Exception e)
          {
            System.out.println("Error : " + e.getMessage());
          }
        }
        admPanel();
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
        if(count == 0)
        {
            System.out.println("No records available.");
            return;
        }   
            int index=-1;
            for(int i=0; i<count; i++)
            {
                if(names[i].equalsIgnoreCase(LoggedName))
                {
                    index=i;
                    break;
                }
            }
            if(index==-1) {
                System.out.println("Attendance record for logged in student not found.");
            }
            else {
                System.out.println(LoggedName + "| Attendance: "+ attendance[index] + "%"); 
            }
        System.out.println("\nPress Enter to return to Student Panel...\n\n");
        input.nextLine();
    }
    public static void stdAcademics() 
    {
        System.out.println("\n\n----------> ACADEMICS REPORT <----------");
        if(count == 0)
        {
            System.out.println("No records available.");
            return;
        }
        int index=-1;
        for(int i=0;i<count;i++)
        {
            if(names[i].equalsIgnoreCase(LoggedName))
            {
                index=i;
                break;
            }
        }
        if(index==-1) {
            System.out.println("Record for logged in student not found.");
            return;
        }
        double percentage = marks[index]; 
        grade[index] = calculateGrade(marks[index]);
        cgpa[index] = calculateCGPA(marks[index]);
        System.out.printf("%-15s %-10s %-12s %-10s %-10s\n", "Name", "Marks", "Percentage", "Grade", "CGPA");
        System.out.printf("%-15s %-10d %-12.2f %-10s %-10.2f\n", names[index], marks[index], percentage, grade[index], cgpa[index]);

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
        System.out.print("Enter Student Name: ");
        String name =input.nextLine();
        System.out.print("Enter Age(18-25): ");
        int age=input.nextInt();
        if(age<18 || age>25)
        {
            System.out.println("Invalid Age! Record not added.");
            return;
        }
        System.out.print("Enter Marks(0-100): ");
        int mark=input.nextInt();
        if(mark<0 || mark>100)
        {
            System.out.println("Invalid Marks! Record not added.");
            return;
        }
        System.out.print("Enter Attendance(0-100): ");
        int attend=input.nextInt();
        if(attend<0 || attend>100)
        {
            System.out.println("Invalid Attendance! Record not added.");
            return;
        }
        System.out.print("Enter ID: ");
        int id=input.nextInt();
        for(int i=0;i<count;i++)
        {
            if(ids[i]==id)
            {
                System.out.println("ID already exists! Record not added.");
                return;
            }
        }
        names[count]=name;
        ages[count]=age;
        marks[count]=mark;
        attendance[count]=attend;
        ids[count]=id;
        grade[count]=calculateGrade(mark);
        cgpa[count]=calculateCGPA(mark);
        count++;
        System.out.println("Record added successfully!");
    }
    public static void viewRecord() 
    {
        System.out.println("\n\n----------> STUDENT RECORDS <----------");
        if(count ==0) {
            System.out.println("No records available.");
            return;
        }
           System.out.printf("%-5s %-20s %-5s %-8s %-12s %-10s %-10s\n", "ID", "Name", "Age", "Marks", "Attendance", "Grade", "CGPA");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d %-20s %-5d %-8d %-12d %-10s %-10.2f\n", ids[i], names[i], ages[i], marks[i], attendance[i], grade[i], cgpa[i]);
        }
    }
    public static void updateRecord() 
    {
        System.out.println("\n\n----------> UPDATE RECORD <----------");
        System.out.print("Enter Student ID to update: ");
        int id=input.nextInt();
        int index=-1;
        for(int i=0;i<count;i++)
        {
            if(ids[i]==id)
            {
                index=i;
                break;
            }
        }
        if(index==-1) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }
        System.out.println("Current Record:");
        System.out.printf("Name: %s, Age: %d, Marks: %d, Attendance: %d, Grade: %s, CGPA: %.2f\n", names[index], ages[index], marks[index], attendance[index], grade[index], cgpa[index]);
        input.nextLine();
        System.out.print("Enter new Name(press Enter to keep current): ");
        String name = input.nextLine();
        if(!name.isEmpty()) {
            names[index] = name;
        }
        System.out.print("Enter new Age(18-25, 0 to keep current): ");
        int newAge=input.nextInt();
        if(newAge!=0) {
            if(newAge>=18 && newAge<=25) {
                ages[index] = newAge;
            } else {
                System.out.println("Invalid Age! Keeping current age.");
            }
    }
    System.out.print("Enter new Attendance(0-100, -1 to keep current): ");
    int newAttend=input.nextInt();
    if(newAttend!=-1) {
        if(newAttend>=0 && newAttend<=100) {
            attendance[index] = newAttend;
        } else {
            System.out.println("Invalid Attendance! Keeping current attendence.");
        }
    }
    System.out.print("Enter new Marks(0-100, -1 to keep current): ");
    int newMarks=input.nextInt();
    if(newMarks!=-1) {
        if(newMarks>=0 && newMarks<=100) {
            marks[index] = newMarks;
            grade[index] = calculateGrade(newMarks);
            cgpa[index] = calculateCGPA(newMarks);
        } else {
            System.out.println("Invalid Marks! Keeping current marks.");
        }
    }
    System.out.println("Record updated successfully!");
}
    public static void searchRecord() 
    {
        System.out.println("\n\n----------> SEARCH RECORD <----------");
        System.out.print("Enter Student ID to search: ");
        int id=input.nextInt();
        input.nextLine();
        boolean found = false;
        for (int i=0;i<count;i++) {
            if(ids[i]==id) {
                System.out.println("\nRecord Found:");
                System.out.printf("ID: %d, Name: %s, Age: %d, Marks: %d, Attendance: %d, Grade: %s, CGPA: %.2f\n", ids[i], names[i], ages[i], marks[i], attendance[i], grade[i], cgpa[i]);
                found = true;
                break;
                }
            }
            if(!found) {
                System.out.println("Student with ID " + id + " not found!" );
            }
            System.out.println("\nPress Enter to return to Admin Panel...\n\n");
            input.nextLine();
        }
    public static void saveToFile() 
    {
        System.out.println("\n\n----------> FILE SAVING <----------");
        try {
            FileWriter fw = new FileWriter("students.txt");
            for (int i = 0; i < count; i++) {
            fw.write("Name: " + names[i] + ", Age: " + ages[i] + ", Marks: " + marks[i] + ", Attendance: " + attendance[i] + "%, ID: " + ids[i] + ", Grade: " + grade[i] + ", CGPA: " + cgpa[i] + "\n");}
            fw.close();
            System.out.println("Data Saved Successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error saving file!" + e.getMessage());
        }   
    }
    public static int safeIntInput()
    {
        while(true)
        {
            try
            {
                return input.nextInt();
            }
            catch(Exception e)
            {
                System.out.print("Invalid input! Enter again: ");
                input.nextLine();
            }
        }
    }
    public static String calculateGrade(int marks) 
{
    if(marks >= 90) return "A+";
    if(marks >= 85) return "A";
    if(marks >= 80) return "A-";
    if(marks >= 75) return "B+";
    if(marks >= 70) return "B";
    if(marks >= 65) return "B-";
    if(marks >= 60) return "C+";
    if(marks >= 55) return "C";
    if(marks >= 50) return "C-";
    if(marks >= 45) return "D";
    return "F";
}

public static double calculateCGPA(int marks)
{
    if(marks >= 90) return 4.0;
    if(marks >= 85) return 3.7;
    if(marks >= 80) return 3.3;
    if(marks >= 75) return 3.0;
    if(marks >= 70) return 2.7;
    if(marks >= 65) return 2.3;
    if(marks >= 60) return 2.0;
    if(marks >= 55) return 1.7;
    if(marks >= 50) return 1.0;
    return 0.0;
}
    public static void filesinitialize() 
    {
        try 
        {
            File userFile = new File("usernames.txt");
            File passFile = new File("passwords.txt");
            if (!userFile.exists()) 
            {
                userFile.createNewFile();
                FileWriter writer = new FileWriter(userFile);
                writer.write("FA25-BDS-045\nFA25-BDS-035\nteacher1\nteacher2");
                writer.close();
            }
            
            if (!passFile.exists()) 
            {
                passFile.createNewFile();
                FileWriter writer = new FileWriter(passFile);
                writer.write("28076\n1122\n0011\n1234");
                writer.close();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error initializing files: " + e.getMessage());
        }
    }
    public static void main(String[] args) 
    {
        while(true)
        {
            filesinitialize();
            System.out.println("----------> STUDENT MANAGEMENT SYSTEM <----------");
            System.out.println("----------> SHEHRYAR KHURRAM FA25-BDS-045 <----------");
            System.out.println("----------> MUHAMMAD RAFAY FA25-BDS-035 <----------");
            System.out.println();
            System.out.println();
            System.out.println();
            boolean noerrormain = false;
            while(!noerrormain)
            {
                try
                {
                    System.out.println("----------> LOGIN MENU <----------");
                    System.out.println("--- 1. STUDENT LOGIN ---");
                    System.out.println("--- 2. ADMIN LOGIN ---");
                    System.out.println("--- 3. EXIT ---");
                    System.out.println("\nEnter your choice ( 1 to 3 ) : ");
                    
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
                    noerrormain = true;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Error Invalid Entry   : " + e.getMessage());
                    input.nextLine();
                }      
            }
        }
    }
}
