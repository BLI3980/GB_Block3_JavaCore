package hw03;

import java.util.List;

public class Chief extends Employee{

    public Chief(String fullName, String position, long phone, int salary, int age) {
        super(fullName, position, phone, salary, age);
    }

    public static void salaryIncrease(List<Employee> employeeList) {
        salaryIncrease(employeeList, 5000, 45);
    }

    // Task 04
    public static void salaryIncrease(List<Employee> employeeList, int increase, int age) {
        for (Employee employee: employeeList) {
            if (!(employee instanceof Chief) && (employee.getAge() >= age)) {
                employee.setSalary(employee.getSalary() + increase);
            }
        }
    }
}
