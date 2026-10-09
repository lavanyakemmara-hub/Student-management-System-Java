package com.reva.sms.app;

import com.reva.sms.model.*;
import com.reva.sms.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final String COLLEGE = "REVA UNIVERSITY";
    private final StudentService service = new StudentService();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem app = new StudentManagementSystem();
        app.seedDemoData();
        app.run();
    }

    private void seedDemoData() {
        service.addStudent(new Student(101, "Asha Rao", "9876543210", Department.BSC_BSTCS, 25000, true));
        service.addStudent(new ScholarshipStudent(102, "Rohan Kumar", "9988776655",
                Department.BCA, 30000, 5000));
    }

    private void run() {
        System.out.println("\n======================================");
        System.out.println("       " + COLLEGE);
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================");
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String raw = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(raw);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updatePhone(); break;
                case 5: removeStudent(); break;
                case 6: showTotalFees(); break;
                case 7: showOopDemo(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Thank you for using the Student Management System!");
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search student by name");
        System.out.println("4. Update student phone");
        System.out.println("5. Delete student");
        System.out.println("6. Calculate total active fees");
        System.out.println("7. Demonstrate OOP features");
        System.out.println("0. Exit");
    }

    private void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine().trim();
            System.out.println("Departments: 1.BSC_BSTCS  2.BCA  3.BCOM  4.BBA  5.OTHER");
            System.out.print("Choose department: ");
            int deptChoice = Integer.parseInt(scanner.nextLine().trim());
            Department department;
            switch (deptChoice) {
                case 1: department = Department.BSC_BSTCS; break;
                case 2: department = Department.BCA; break;
                case 3: department = Department.BCOM; break;
                case 4: department = Department.BBA; break;
                default: department = Department.OTHER;
            }
            System.out.print("Enter fee amount: ");
            double fee = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Scholarship student? (y/n): ");
            String answer = scanner.nextLine().trim();
            Student student;
            if (answer.equalsIgnoreCase("y")) {
                System.out.print("Scholarship amount: ");
                double scholarship = Double.parseDouble(scanner.nextLine().trim());
                student = new ScholarshipStudent(id, name, phone, department, fee, scholarship);
            } else {
                student = new Student(id, name, phone, department, fee, true);
            }
            if (service.addStudent(student)) System.out.println("Student added successfully.");
            else System.out.println("Could not add student. ID may already exist or capacity is full.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid numeric input. Student was not added.");
        }
    }

    private void viewStudents() {
        List<Student> students = service.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.printf("%-8s %-20s %-15s %-12s %-13s %-8s%n",
                "ID", "NAME", "DEPARTMENT", "PHONE", "FEE", "STATUS");
        System.out.println("-------------------------------------------------------------------------------");
        // Parent references holding child objects demonstrate dynamic binding.
        for (Student student : students) student.printDetails();
        System.out.println("Total student records: " + students.size());
    }

    private void searchStudent() {
        System.out.print("Enter all or part of the student's name: ");
        String query = scanner.nextLine().trim();
        List<Student> matches = service.searchByName(query);
        if (matches.isEmpty()) System.out.println("No matching student found.");
        else for (Student student : matches) student.printDetails(true);
    }

    private void updatePhone() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter new phone: ");
            String phone = scanner.nextLine().trim();
            System.out.println(service.updatePhone(id, phone) ? "Phone updated." : "Student not found.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid student ID.");
        }
    }

    private void removeStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(service.removeStudent(id) ? "Student deleted." : "Student not found.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid student ID.");
        }
    }

    private void showTotalFees() {
        System.out.printf("Total active student fees: Rs.%.2f%n", service.calculateTotalFees());
    }

    private void showOopDemo() {
        System.out.println("\n--- OOP demonstration ---");
        Person person = new ScholarshipStudent(999, "Demo Student", "9000000000",
                Department.BSC_BSTCS, 20000, 2500);
        System.out.println("Dynamic role: " + person.getRole());
        person.displayBasicInfo();

        FeePayable payable = new FeeRecord(999, 1000);
        System.out.printf("FeePayable interface result: Rs.%.2f%n", payable.calculateNetFee());
        System.out.println("Static total Student objects created: " + Student.getTotalStudents());
        System.out.println("Example toString(): " + person.toString());
    }
}
