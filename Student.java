package com.reva.sms.model;

public class Student extends Person {
    private final int id;
    private Department department;
    private double fee;
    private boolean active;
    private static int totalStudents = 0;
    public static final double DEFAULT_FEE = 25000.0;

    public Student() {
        this(0, "Unknown", "Not provided", Department.OTHER, DEFAULT_FEE, true);
    }

    public Student(int id, String name, String phone, Department department) {
        this(id, name, phone, department, DEFAULT_FEE, true);
    }

    public Student(int id, String name, String phone, Department department, double fee, boolean active) {
        super(name, phone);
        this.id = id;
        this.department = department;
        this.fee = fee;
        this.active = active;
        totalStudents++;
    }

    public int getId() { return id; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public static int getTotalStudents() { return totalStudents; }

    @Override
    public String getRole() { return "Student"; }

    public String getFeeStatus() {
        if (active && fee > 0) return "Active";
        return "Inactive / Fee pending";
    }

    // Final because a student's unique ID must not be changed after registration.
    public final String getStudentCode() {
        return "REVA-" + id;
    }

    public void printDetails() {
        int roundedFee = (int) fee; // Explicit double-to-int casting.
        System.out.printf("%-8d %-20s %-15s %-12s Rs.%-10d %-8s%n",
                id, getName(), department, getPhone(), roundedFee, getFeeStatus());
    }

    public void printDetails(boolean showCode) { // Method overloading.
        printDetails();
        if (showCode) System.out.println("Student code: " + getStudentCode());
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + ", id=" + id + ", department=" + department
                + ", fee=" + fee + ", active=" + active + "}";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Student)) return false;
        Student student = (Student) other;
        return id == student.id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }
}
