package com.reva.sms.model;

public abstract class Person {
    private String name;
    private String phone;

    public Person() {
        this("Unknown", "Not provided");
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public abstract String getRole();

    public void displayBasicInfo() {
        System.out.println("Name: " + name + " | Phone: " + phone);
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Phone=" + phone;
    }
}
