package oop.assigment_problems;

/**
 * M5. Employee and Company Information Management.
 *
 * NOTE: The spec calls this class "Employee" as well, but this package
 * already has an Employee.java from M3 with different fields — two
 * public classes can't share a name in one package, so this one is named
 * EmployeeCompanyInfo.java instead. It still implements exactly what M5
 * asks for: companyName and employeeCount are static (shared once across
 * every instance), and printCompanyInfo() reads only those static fields.
 *
 * Expected Output (running this file's main method):
 *
 * Bright Horizon Technologies
 * Employees on record: 3
 */
public class EmployeeCompanyInfo {

    private String empName;
    private double salary;

    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompanyInfo("Divya", 65000);
        new EmployeeCompanyInfo("Arjun", 40000);
        new EmployeeCompanyInfo("Meena", 55000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}
