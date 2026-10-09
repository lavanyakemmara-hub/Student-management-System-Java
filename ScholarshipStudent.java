package com.reva.sms.model;

public class ScholarshipStudent extends Student {
    private double scholarshipAmount;

    public ScholarshipStudent(int id, String name, String phone, Department department,
                              double fee, double scholarshipAmount) {
        super(id, name, phone, department, fee, true);
        this.scholarshipAmount = scholarshipAmount;
    }

    public double getScholarshipAmount() { return scholarshipAmount; }
    public void setScholarshipAmount(double scholarshipAmount) { this.scholarshipAmount = scholarshipAmount; }

    @Override
    public String getRole() {
        return "Scholarship Student";
    }

    @Override
    public void printDetails() {
        super.printDetails(); // Parent method call using super.
        System.out.printf("  Scholarship: Rs.%.2f | Net fee: Rs.%.2f%n",
                scholarshipAmount, Math.max(0, getFee() - scholarshipAmount));
    }
}
