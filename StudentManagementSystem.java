import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    static String[] studentIDs = new String[100];
    static String[] studentNames = new String[100];
    static int[] studentAges = new int[100];
    static int[] studentAttendance = new int[100];
    static String[] studentDOBs = new String[100];
    static String[] courseNames;
    static int numCourses = 0;
    static int[][] courseMarks;
    static double[] studentGPAs = new double[100];
    
    static int studentCount = 0;
    static final String ADMIN_USERNAME = "admin";
    static final String ADMIN_PASSWORD = "admin123";
    static final String STUDENT_FILE = "students.txt";
    static final String COURSE_FILE = "courses.txt";
    static Scanner scanner = new Scanner(System.in);
    static void adminLogin() {
        try {
            System.out.println("\n----------- ADMIN LOGIN -----------");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("\nLogin successful! Welcome Admin.");
                adminMenu();
            } else {
                System.out.println("\nInvalid username or password!");
            }
        } catch (Exception e) {
            System.out.println("\nError in admin login: " + e.getMessage());
        }
    }
    static void adminMenu() {
        boolean backToMain = false;
        
        while (!backToMain) {
            try {
                System.out.println("\n========== ADMIN MENU ==========");
                System.out.println("1. Configure Courses");
                System.out.println("2. Add New Student");
                System.out.println("3. View All Students");
                System.out.println("4. Update Student Record");
                System.out.println("5. Search Student");
                System.out.println("6. Save Data to File");
                System.out.println("7. Logout");
                System.out.println("=================================");
                System.out.print("Enter your choice (1-7): ");
                
                String input = scanner.nextLine();
                
                if (!isValidNumber(input, 1, 7)) {
                    System.out.println("\nError: Please enter a valid number between 1 and 7!");
                    continue;
                }
                
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        configureCourses();
                        break;
                    case 2:
                        addStudentRecord();
                        break;
                    case 3:
                        viewAllRecords();
                        break;
                    case 4:
                        updateStudentRecord();
                        break;
                    case 5:
                        searchStudentRecord();
                        break;
                    case 6:
                        saveDataToFiles();
                        System.out.println("\nData saved successfully!");
                        break;
                    case 7:
                        backToMain = true;
                        System.out.println("\nLogged out successfully!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError in admin menu: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("\nInput error in admin menu: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nAn unexpected error occurred in admin menu: " + e.getMessage());
            }   
        }
    }
    static void configureCourses() {
        try {
            if (numCourses > 0) {
                System.out.println("\nCourses are already configured:");
                for (int i = 0; i < numCourses; i++) {
                    System.out.println((i + 1) + ". " + courseNames[i]);
                }

                while (true) {
                    System.out.print("\nDo you want to reconfigure courses? (yes/no): ");
                    String answer = scanner.nextLine();

                    if (answer == null) {
                        System.out.println("Input error. Please try again.");
                        continue;
                    }

                    answer = answer.trim();

                    if (answer.equalsIgnoreCase("yes")) {
                        break; 
                    } else if (answer.equalsIgnoreCase("no")) {
                        System.out.println("Course reconfiguration cancelled.");
                        return; 
                    } else {
                        System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                    }
                }
            }

            System.out.println("\n----------- CONFIGURE COURSES -----------");
            System.out.print("How many courses? (1-10): ");
            String input = scanner.nextLine();

            if (!isValidNumber(input, 1, 10)) {
                System.out.println("Error: Please enter a number between 1 and 10!");
                return;
            }

            numCourses = Integer.parseInt(input);
            courseNames = new String[numCourses];
            courseMarks = new int[100][numCourses];

            for (int i = 0; i < numCourses; i++) {
                System.out.print("Enter name for Course " + (i + 1) + ": ");
                courseNames[i] = scanner.nextLine();

                for (int j = 0; j < studentCount; j++) {
                    courseMarks[j][i] = 0;
                }
            }

            System.out.println("\nCourses configured successfully!");
            System.out.println("Total courses: " + numCourses);

        } catch (NoSuchElementException e) {
            System.out.println("Input error occurred. Please try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error configuring courses: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
    static void studentLogin() {
        try {
            System.out.println("\n----------- STUDENT LOGIN -----------");
            System.out.print("Student ID (Username): ");
            String username = scanner.nextLine();
            System.out.print("Date of Birth (Password - DD-MM-YYYY): ");
            String password = scanner.nextLine();
            
            int index = -1;
            
            for (int i = 0; i < studentCount; i++) {
                if (studentIDs[i] != null && studentIDs[i].equals(username)) {
                    index = i;
                    break;
                }
            }
            
            if (index == -1) {
                System.out.println("\nStudent ID not found!");
                return;
            }
            
            if (!studentDOBs[index].equals(password)) {
                System.out.println("\nInvalid Date of Birth!");
                return;
            }
            
            System.out.println("\nLogin successful! Welcome " + studentNames[index]);
            studentMenu(index);
        } catch (Exception e) {
            System.out.println("\nError in student login: " + e.getMessage());
        }
    }
    static void studentMenu(int studentIndex) {
        boolean backToMain = false;
        
        while (!backToMain) {
            try {
                System.out.println("\n========= STUDENT MENU =========");
                System.out.println("1. View My Profile");
                System.out.println("2. View My Attendance");
                System.out.println("3. View My Academics Report");
                System.out.println("4. Logout");
                System.out.println("================================");
                System.out.print("Enter your choice (1-4): ");
                
                String input = scanner.nextLine();
                
                if (!isValidNumber(input, 1, 4)) {
                    System.out.println("\nError: Please enter a valid number between 1 and 4!");
                    continue;
                }
                
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        viewStudentProfile(studentIndex);
                        break;
                    case 2:
                        viewStudentAttendance(studentIndex);
                        break;
                    case 3:
                        viewAcademicsReport(studentIndex);
                        break;
                    case 4:
                        backToMain = true;
                        System.out.println("\nLogged out successfully!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError in student menu: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nAn unexpected error occurred in student menu: " + e.getMessage());
            }
        }
    }
    static void addStudentRecord() {
        try {
            if (studentCount >= 100) {
                System.out.println("\nError: Maximum student limit reached (100 students)!");
                return;
            }
            
            if (numCourses == 0) {
                System.out.println("\nError: Courses not configured yet!");
                System.out.println("Please configure courses first from Admin Menu.");
                return;
            }
            
            System.out.println("\n----------- ADD NEW STUDENT -----------");
            String id;
            while (true) {
                try {
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    
                    if (id.isEmpty()) {
                        System.out.println("Error: Student ID cannot be empty!");
                        continue;
                    }
                    
                    if (findStudentByID(id) != -1) {
                        System.out.println("Error: Student ID already exists!");
                        continue;
                    }
                    break;
                } catch (NoSuchElementException e) {
                    System.out.println("Error: Input error - " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            String name;
            while (true) {
                try {
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();
                    
                    if (name.isEmpty()) {
                        System.out.println("Error: Student Name cannot be empty!");
                        continue;
                    }
                    
                    boolean validName = true;
                    for (int i = 0; i < name.length(); i++) {
                        char c = name.charAt(i);
                        if (!Character.isLetter(c) && c != ' ') {
                            validName = false;
                            break;
                        }
                    }
                    
                    if (!validName) {
                        System.out.println("Error: Name can only contain letters and spaces!");
                        continue;
                    }
                    break;
                } catch (NoSuchElementException | NullPointerException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            int age = 0;
            while (true) {
                try {
                    System.out.print("Enter Student Age (18-25): ");
                    String ageInput = scanner.nextLine();
                    
                    if (!isValidNumber(ageInput, 18, 25)) {
                        System.out.println("Error: Age must be a number between 18 and 25!");
                        continue;
                    }
                    
                    age = Integer.parseInt(ageInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            String dob;
            while (true) {
                try {
                    System.out.print("Enter Date of Birth (DD-MM-YYYY): ");
                    dob = scanner.nextLine();
                    
                    if (dob.length() != 10) {
                        System.out.println("Error: Date of Birth must be in DD-MM-YYYY format!");
                        continue;
                    }
                    if (dob.charAt(2) != '-' || dob.charAt(5) != '-') {
                        System.out.println("Error: Date must be in DD-MM-YYYY format!");
                        continue;
                    }
                    String day = dob.substring(0, 2);
                    String month = dob.substring(3, 5);
                    String year = dob.substring(6, 10);
                    
                    boolean validFormat = true;
                    for (int i = 0; i < day.length(); i++) {
                        if (!Character.isDigit(day.charAt(i))) validFormat = false;
                    }
                    for (int i = 0; i < month.length(); i++) {
                        if (!Character.isDigit(month.charAt(i))) validFormat = false;
                    }
                    for (int i = 0; i < year.length(); i++) {
                        if (!Character.isDigit(year.charAt(i))) validFormat = false;
                    }
                    
                    if (!validFormat) {
                        System.out.println("Error: Date must contain only digits in DD-MM-YYYY format!");
                        continue;
                    }
                    int dayNum = Integer.parseInt(day);
                    if (dayNum < 1 || dayNum > 31) {
                        System.out.println("Error: Day must be between 01 and 31!");
                        continue;
                    }
                    int monthNum = Integer.parseInt(month);
                    if (monthNum < 1 || monthNum > 12) {
                        System.out.println("Error: Month must be between 01 and 12!");
                        continue;
                    }
                    int yearNum = Integer.parseInt(year);
                    if (yearNum < 1900 || yearNum > 2025) {
                        System.out.println("Error: Year must be between 1900 and 2025!");
                        continue;
                    }
                    
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            int attendance = 0;
            while (true) {
                try {
                    System.out.print("Enter Attendance Percentage (0-100): ");
                    String attendanceInput = scanner.nextLine();
                    
                    if (!isValidNumber(attendanceInput, 0, 100)) {
                        System.out.println("Error: Attendance must be a number between 0 and 100!");
                        continue;
                    }
                    
                    attendance = Integer.parseInt(attendanceInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println("\nEnter marks for each course (0-100):");
            int totalMarks = 0;
            for (int i = 0; i < numCourses; i++) {
                while (true) {
                    try {
                        System.out.print(courseNames[i] + " marks: ");
                        String marksInput = scanner.nextLine();
                        
                        if (!isValidNumber(marksInput, 0, 100)) {
                            System.out.println("Error: Marks must be between 0 and 100!");
                            continue;
                        }
                        
                        int marks = Integer.parseInt(marksInput);
                        courseMarks[studentCount][i] = marks;
                        totalMarks += marks;
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                }
            }
            }
            double averageMarks = (double) totalMarks / numCourses;
            studentGPAs[studentCount] = calculateCGPA((int) averageMarks);
            studentIDs[studentCount] = id;
            studentNames[studentCount] = name;
            studentAges[studentCount] = age;
            studentDOBs[studentCount] = dob;
            studentAttendance[studentCount] = attendance;
            studentCount++;
            
            System.out.println("\nStudent record added successfully!");
            System.out.println("Total students: " + studentCount);
             
        } catch (NumberFormatException e) {
            System.out.println("\nError adding student record: " + e.getMessage());
        }
    }
    static void viewAllRecords() {
        try {
            if (studentCount == 0) {
                System.out.println("\nNo student records found!");
                return;
            }
            
            System.out.println("\n----------- ALL STUDENT RECORDS -----------");
            System.out.println("Total Students: " + studentCount);
            System.out.println("===========================================");
            
            for (int i = 0; i < studentCount; i++) {
                System.out.println("\nStudent #" + (i + 1));
                System.out.println("ID: " + studentIDs[i]);
                System.out.println("Name: " + studentNames[i]);
                System.out.println("Age: " + studentAges[i]);
                System.out.println("Date of Birth: " + studentDOBs[i]);
                System.out.println("Attendance: " + studentAttendance[i] + "%");
                System.out.println("GPA: " + studentGPAs[i]);
                
                if (numCourses > 0) {
                    System.out.println("Course Marks:");
                    for (int j = 0; j < numCourses; j++) {
                        System.out.println("  " + courseNames[j] + ": " + courseMarks[i][j] + 
                                          " (" + calculateGrade(courseMarks[i][j]) + ")");
                    }
                }
                System.out.println("-------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("\nError viewing records: " + e.getMessage());
        }
    }
    static void updateStudentRecord() {
        try {
            if (studentCount == 0) {
                System.out.println("\nNo student records found to update!");
                return;
            }
            
            System.out.println("\n----------- UPDATE STUDENT RECORD -----------");
            System.out.print("Enter Student ID to update: ");
            String id = scanner.nextLine();
            
            int index = findStudentByID(id);
            
            if (index == -1) {
                System.out.println("\nStudent ID not found!");
                return;
            }
            
            System.out.println("\nCurrent Record:");
            System.out.println("1. ID: " + studentIDs[index]);
            System.out.println("2. Name: " + studentNames[index]);
            System.out.println("3. Age: " + studentAges[index]);
            System.out.println("4. Date of Birth: " + studentDOBs[index]);
            System.out.println("5. Attendance: " + studentAttendance[index] + "%");
            System.out.println("6. GPA: " + studentGPAs[index]);
            
            if (numCourses > 0) {
                System.out.println("7. Update Course Marks");
            }
            System.out.println("8. Cancel");
            System.out.print("Enter your choice (1-8): ");
            
            String choiceInput = scanner.nextLine();
            
            if (!isValidNumber(choiceInput, 1, 8)) {
                System.out.println("Invalid choice!");
                return;
            }
            
            int choice = Integer.parseInt(choiceInput);
            
            switch (choice) {
                case 1:
                    System.out.print("Enter new ID: ");
                    String newID = scanner.nextLine();
                    if (!newID.isEmpty()) {
                        studentIDs[index] = newID;
                        System.out.println("ID updated successfully!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        studentNames[index] = newName;
                        System.out.println("Name updated successfully!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter new age (18-25): ");
                    String ageInput = scanner.nextLine();
                    if (isValidNumber(ageInput, 18, 25)) {
                        studentAges[index] = Integer.parseInt(ageInput);
                        System.out.println("Age updated successfully!");
                    } else {
                        System.out.println("Invalid age!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter new Date of Birth (DD-MM-YYYY): ");
                    String newDOB = scanner.nextLine();
                    if (newDOB.length() == 10 && newDOB.charAt(2) == '-' && newDOB.charAt(5) == '-') {
                        studentDOBs[index] = newDOB;
                        System.out.println("Date of Birth updated successfully!");
                    } else {
                        System.out.println("Invalid format! Must be DD-MM-YYYY");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter new attendance (0-100): ");
                    String attInput = scanner.nextLine();
                    if (isValidNumber(attInput, 0, 100)) {
                        studentAttendance[index] = Integer.parseInt(attInput);
                        System.out.println("Attendance updated successfully!");
                    } else {
                        System.out.println("Invalid attendance!");
                    }
                    break;
                    
                case 6:
                    System.out.print("Enter new GPA (0.0-4.0): ");
                    String gpaInput = scanner.nextLine();
                    try {
                        double newGPA = Double.parseDouble(gpaInput);
                        if (newGPA >= 0.0 && newGPA <= 4.0) {
                            studentGPAs[index] = newGPA;
                            System.out.println("GPA updated successfully!");
                        } else {
                            System.out.println("GPA must be between 0.0 and 4.0!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA format!");
                    }
                    break;
                    
                case 7:
                    if (numCourses > 0) {
                        updateCourseMarks(index);
                    }
                    break;
                    
                case 8:
                    System.out.println("Update cancelled.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError updating record: " + e.getMessage());
        }
    }
    static void searchStudentRecord() {
        try {
            if (studentCount == 0) {
                System.out.println("\nNo student records found!");
                return;
            }
            
            System.out.println("\n----------- SEARCH STUDENT -----------");
            System.out.println("1. Search by ID");
            System.out.println("2. Search by Name");
            System.out.println("3. Back to Menu");
            System.out.print("Enter your choice (1-3): ");
            
            String choiceInput = scanner.nextLine();
            
            if (!isValidNumber(choiceInput, 1, 3)) {
                System.out.println("Invalid choice!");
                return;
            }
            
            int choice = Integer.parseInt(choiceInput);
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    searchByID(id);
                    break;
                    
                case 2:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    searchByName(name);
                    break;
                    
                case 3:
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError searching student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nAn unexpected error occurred while searching: " + e.getMessage());
        }
    }
    static void viewStudentProfile(int index) {
        try {
            System.out.println("\n----------- MY PROFILE -----------");
            System.out.println("Student ID: " + studentIDs[index]);
            System.out.println("Name: " + studentNames[index]);
            System.out.println("Age: " + studentAges[index]);
            System.out.println("Date of Birth: " + studentDOBs[index]);
            System.out.println("Attendance: " + studentAttendance[index] + "%");
            System.out.println("GPA: " + studentGPAs[index]);
        } catch (Exception e) {
            System.out.println("\nError viewing profile: " + e.getMessage());
        }
    }
    
    static void viewStudentAttendance(int index) {
        try {
            System.out.println("\n----------- MY ATTENDANCE -----------");
            System.out.println("Student: " + studentNames[index] + " (" + studentIDs[index] + ")");
            System.out.println("Attendance Percentage: " + studentAttendance[index] + "%");
        } catch (Exception e) {
            System.out.println("\nError viewing attendance: " + e.getMessage());
        }
    }
    
    static void viewAcademicsReport(int index) {
        try {
            System.out.println("\n----------- ACADEMICS REPORT -----------");
            System.out.println("Student: " + studentNames[index] + " (" + studentIDs[index] + ")");
            System.out.println("Current GPA: " + studentGPAs[index]);
            
            if (numCourses > 0) {
                System.out.println("\nCourse-wise Marks and Grades:");
                System.out.println("==============================");
                for (int i = 0; i < numCourses; i++) {
                    int marks = courseMarks[index][i];
                    String grade = calculateGrade(marks);
                    System.out.println(courseNames[i] + ": " + marks + " marks (" + grade + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("\nError viewing academics report: " + e.getMessage());
        }
    }
    static int findStudentByID(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIDs[i] != null && studentIDs[i].equals(id)) {
                return i;
            }
        }
        return -1;
    }
    
    static void searchByID(String id) {
        int index = findStudentByID(id);
        if (index == -1) {
            System.out.println("\nStudent not found!");
        } else {
            System.out.println("\nStudent Found:");
            System.out.println("ID: " + studentIDs[index]);
            System.out.println("Name: " + studentNames[index]);
            System.out.println("Age: " + studentAges[index]);
            System.out.println("Attendance: " + studentAttendance[index] + "%");
            System.out.println("GPA: " + studentGPAs[index]);
        }
    }
    
    static void searchByName(String name) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i] != null && studentNames[i].toLowerCase().contains(name.toLowerCase())) {
                if (!found) {
                    System.out.println("\nSearch Results:");
                    found = true;
                }
                System.out.println("\nStudent #" + (i + 1));
                System.out.println("ID: " + studentIDs[i]);
                System.out.println("Name: " + studentNames[i]);
                System.out.println("Age: " + studentAges[i]);
                System.out.println("Attendance: " + studentAttendance[i] + "%");
                System.out.println("GPA: " + studentGPAs[i]);
            }
        }
        if (!found) {
            System.out.println("\nNo students found with that name!");
        }
    }
    
    static void updateCourseMarks(int studentIndex) {
        try {
            System.out.println("\n----------- UPDATE COURSE MARKS -----------");
            for (int i = 0; i < numCourses; i++) {
                System.out.println((i + 1) + ". " + courseNames[i] + " (Current: " + 
                                  courseMarks[studentIndex][i] + ")");
            }
            System.out.print("Select course to update (1-" + numCourses + "): ");
            
            String courseInput = scanner.nextLine();
            
            if (!isValidNumber(courseInput, 1, numCourses)) {
                System.out.println("Invalid course selection!");
                return;
            }
            
            int courseIndex = Integer.parseInt(courseInput) - 1;
            
            System.out.print("Enter new marks for " + courseNames[courseIndex] + " (0-100): ");
            String marksInput = scanner.nextLine();
            
            if (!isValidNumber(marksInput, 0, 100)) {
                System.out.println("Invalid marks!");
                return;
            }
            
            int newMarks = Integer.parseInt(marksInput);
            courseMarks[studentIndex][courseIndex] = newMarks;
            int totalMarks = 0;
            for (int i = 0; i < numCourses; i++) {
                totalMarks += courseMarks[studentIndex][i];
            }
            double averageMarks = (double) totalMarks / numCourses;
            studentGPAs[studentIndex] = calculateCGPA((int) averageMarks);
            
            System.out.println("Course marks updated successfully!");
            
        } catch (NumberFormatException e) {
            System.out.println("\nError updating course marks: " + e.getMessage());
        }
    }
    static String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }
    
    static double calculateCGPA(int marks) {
        if (marks >= 90) return 4.0;
        if (marks >= 80) return 3.5;
        if (marks >= 70) return 3.0;
        if (marks >= 60) return 2.5;
        if (marks >= 50) return 2.0;
        return 0.0;
    }
    
    static boolean isValidNumber(String input, int min, int max) {
        try {
            int num = Integer.parseInt(input);
            return num >= min && num <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static void loadDataFromFiles() {
        try {
            File courseFile = new File(COURSE_FILE);
            if (courseFile.exists()) {
                Scanner fileScanner = new Scanner(courseFile);
                if (fileScanner.hasNextLine()) {
                    numCourses = Integer.parseInt(fileScanner.nextLine());
                    courseNames = new String[numCourses];
                    courseMarks = new int[100][numCourses];
                    
                    for (int i = 0; i < numCourses; i++) {
                        if (fileScanner.hasNextLine()) {
                            courseNames[i] = fileScanner.nextLine();
                        }
                    }
                }
                fileScanner.close();
            }
            File studentFile = new File(STUDENT_FILE);
            if (studentFile.exists()) {
                Scanner fileScanner = new Scanner(studentFile);
                studentCount = 0;
                
                while (fileScanner.hasNextLine() && studentCount < 100) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(",");
                    
                    if (data.length >= 5 + numCourses) {
                        studentIDs[studentCount] = data[0];
                        studentNames[studentCount] = data[1];
                        studentAges[studentCount] = Integer.parseInt(data[2]);
                        studentDOBs[studentCount] = data[3];
                        studentAttendance[studentCount] = Integer.parseInt(data[4]);
                        studentGPAs[studentCount] = Double.parseDouble(data[5]);
                        
                        for (int i = 0; i < numCourses; i++) {
                            if (5 + i + 1 < data.length) {
                                courseMarks[studentCount][i] = Integer.parseInt(data[6 + i]);
                            }
                        }
                        
                        studentCount++;
                    }
                }
                fileScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
    
    static void saveDataToFiles() {
        try {
            PrintWriter courseWriter = new PrintWriter(COURSE_FILE);
            courseWriter.println(numCourses);
            for (int i = 0; i < numCourses; i++) {
                courseWriter.println(courseNames[i]);
            }
            courseWriter.close();
            PrintWriter studentWriter = new PrintWriter(STUDENT_FILE);
            for (int i = 0; i < studentCount; i++) {
                String line = studentIDs[i] + "," + 
                             studentNames[i] + "," + 
                             studentAges[i] + "," + 
                             studentDOBs[i] + "," + 
                             studentAttendance[i] + "," + 
                             studentGPAs[i];
                
                for (int j = 0; j < numCourses; j++) {
                    line = line + "," + courseMarks[i][j];
                }
                
                studentWriter.println(line);
            }
            studentWriter.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            loadDataFromFiles();
            
            System.out.println("=======================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("=======================================");
            
            if (numCourses == 0) {
                System.out.println("\nNo courses configured yet.");
                System.out.println("Please login as admin to set up courses first.");
            }
            
            boolean exitSystem = false;
            
            while (!exitSystem) {
                try {
                    System.out.println("\n----------- MAIN MENU -----------");
                    System.out.println("1. Admin Login");
                    System.out.println("2. Student Login");
                    System.out.println("3. Exit System");
                    System.out.println("----------------------------------");
                    System.out.print("Enter your choice (1-3): ");
                    
                    String input = scanner.nextLine();
                    
                    if (!isValidNumber(input, 1, 3)) {
                        System.out.println("\nError: Please enter a valid number between 1 and 3!");
                        continue;
                    }
                    
                    int choice = Integer.parseInt(input);
                    
                    switch (choice) {
                        case 1:
                            adminLogin();
                            break;
                        case 2:
                            if (numCourses == 0) {
                                System.out.println("\nCannot login: Courses not configured yet!");
                                System.out.println("Please ask admin to set up courses first.");
                            } else {
                                studentLogin();
                            }
                            break;
                        case 3:
                            saveDataToFiles();
                            exitSystem = true;
                            System.out.println("\nThank you for using Student Management System!");
                            System.out.println("Data saved successfully!");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nAn unexpected error occurred in main menu: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Critical error in system: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
