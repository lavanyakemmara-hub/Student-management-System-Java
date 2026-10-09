package com.reva.sms.service;

import com.reva.sms.model.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private static final int MAX_STUDENTS = 500;

    public boolean addStudent(Student student) {
        if (students.size() >= MAX_STUDENTS || findById(student.getId()) != null) return false;
        students.add(student);
        return true;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public boolean removeStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Student> searchByName(String query) {
        List<Student> matches = new ArrayList<>();
        String cleaned = query.trim().toLowerCase();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(cleaned)) matches.add(student);
        }
        return matches;
    }

    public boolean updatePhone(int id, String phone) {
        Student student = findById(id);
        if (student == null) return false;
        student.setPhone(phone.trim());
        return true;
    }

    public double calculateTotalFees() {
        double total = 0;
        for (Student student : students) {
            // Operator precedence: multiplication is evaluated before addition.
            total = total + student.getFee() * (student.isActive() ? 1 : 0);
        }
        return total;
    }
}
