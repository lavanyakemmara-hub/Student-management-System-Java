# Student Management System — Java OOP Mini Project

**Course:** Java Programming, B.Sc. (BSTCs), Semester V  
**University:** REVA University  
**Project:** Console-based Student Management System

## Features
- Add, list, search, update, and delete student records
- Department enum, fee calculations, scholarship student subtype
- Input validation, formatted console output, duplicate-ID check
- OOP demonstration menu for inheritance, dynamic binding, abstract class, interface, and static object count
- Two custom packages: `com.reva.sms.model` and `com.reva.sms.service` (plus the app package)

## Requirements
- JDK 8 or newer
- Terminal / Command Prompt

## Compile and run
Run these commands from the project root (`student_management_system`):

```bash
javac -d out src/com/reva/sms/model/*.java src/com/reva/sms/service/*.java src/com/reva/sms/app/*.java
java -cp out com.reva.sms.app.StudentManagementSystem
```

On Windows, the same commands work in Command Prompt if `javac` and `java` are on PATH.

## Menu
1. Add student
2. View all students
3. Search student by name
4. Update student phone
5. Delete student
6. Calculate total active fees
7. Demonstrate OOP features
0. Exit

Two demo records are loaded at startup so the app can be tested immediately. Add your own records through the menu.

## Mandatory-feature traceability
| Assignment requirement | Where it is demonstrated |
|---|---|
| 3–4+ classes and encapsulation | `model/Person.java`, `Student.java`, `ScholarshipStudent.java`, `FeeRecord.java`; private fields and getters/setters |
| Data types, `final`, variable scope | `Student.java`, `StudentManagementSystem.java`; instance fields, local variables, static counter, constants |
| Operators and precedence | `StudentService.calculateTotalFees()` uses `fee * (active ? 1 : 0)` before addition |
| Type casting | `Student.printDetails()` casts `double fee` to `int` |
| Enum | `model/Department.java` |
| if/else, switch, loops, break, continue, return | `StudentManagementSystem.java`, `StudentService.java`, `Student.java` |
| Arrays/collections of objects | `StudentService.java` stores a `List<Student>` (object collection) |
| Console input/output and formatting | `StudentManagementSystem.java`, `Student.printDetails()` |
| Constructor overloading | `Person.java`, `Student.java` |
| Method overloading | `Student.printDetails()` and `printDetails(boolean)` |
| Static fields/methods | `Student.java`: `totalStudents`, `getTotalStudents()` |
| `this` keyword / constructor chaining | `Student.java` constructor uses `this(...)`; constructors assign instance fields |
| String methods | `StudentService.searchByName()` uses `trim()`, `toLowerCase()`, `contains()`; app uses `equalsIgnoreCase()` |
| Base class and two subclasses | `Person` → `Student` → `ScholarshipStudent` |
| `super` constructor and method call | `Student.java` calls `super(name, phone)`; `ScholarshipStudent.java` calls `super.printDetails()` |
| Overriding and dynamic binding | `getRole()` overridden; `showOopDemo()` uses a `Person` reference for `ScholarshipStudent` |
| Abstract class and abstract method | `Person.java` and `getRole()` |
| Interface accessed via interface reference | `FeePayable.java`, `FeeRecord.java`, and `showOopDemo()` |
| `toString()` / `equals()` | `Student.java` overrides both |
| Final method/class and explanation | `Student.getStudentCode()` is final with a comment explaining why |
| Two custom packages and imports | `com.reva.sms.model`, `com.reva.sms.service`, `com.reva.sms.app` |

## Sample console run
```text
======================================
       REVA UNIVERSITY
     STUDENT MANAGEMENT SYSTEM
======================================

1. Add student
2. View all students
3. Search student by name
4. Update student phone
5. Delete student
6. Calculate total active fees
7. Demonstrate OOP features
0. Exit
Enter your choice: 2
ID       NAME                 DEPARTMENT      PHONE         FEE           STATUS
-------------------------------------------------------------------------------
101      Asha Rao             BSC_BSTCS       9876543210    Rs.25000      Active
102      Rohan Kumar          BCA             9988776655    Rs.30000      Active
Total student records: 2
```
