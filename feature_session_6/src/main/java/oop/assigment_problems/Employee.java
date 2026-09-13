package oop.assigment_problems;

/**
 * M3. Employee Profile Creation.
 * Supports interns (no fixed salary yet) and permanent employees without
 * duplicating setup logic, by chaining a 2-arg constructor to the 3-arg
 * one via this(...).
 *
 * Expected Output (running this file's main method):
 *
 * E-101 | Divya | Rs 65000.0 | Intern: false
 * E-102 | Arjun | Rs 0.0 | Intern: true
 */
public class Employee {

    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
