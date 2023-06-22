package hw03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create instances of employees and a chief
        Employee employee1 = new Employee("Ivanov Ivan Ivanovich", "manager",
                11_111_111_111L, 17000, 40);
        Employee employee2 = new Employee("Petrov Petr Petrovich", "director",
                22_222_222_222L, 100_000, 50);
        Employee employee3 = new Employee("Sidorov Sidor Sidorovich", "accountant",
                33_333_333_333L, 10_000, 46);
        Chief chief = new Chief("John Smith", "Big Boss",
                44_444_444_444L, 500_000, 40);
        Employee employee4 = new Employee("John Doe", "janitor",
                55_555_555_555L, 12000, 40);

        // Create a list of employees and a chief
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(chief);

        // Show the employee information before and after salary increase
        System.out.println("========== Before Salary Increase =================");
        printEmployees(employeeList);
        Chief.salaryIncrease(employeeList);
        System.out.println("========== After Salary Increase =================");
        printEmployees(employeeList);

        // Sort employee list by salary. Using Comparator.
        System.out.println("============ Sort by salary. Comparator ==================");
        employeeList.sort(new SalaryComporator());
        printEmployees(employeeList);
        // Sort employee list by age. Using Comparator.
        System.out.println("============ Sort by age. Comparator ==================");
        employeeList.sort(new AgeComparator());
        printEmployees(employeeList);

        //Shuffle the list before performing new sorting by Comparable.
        Collections.shuffle(employeeList);
        System.out.println("============ Shuffled list ==================");

        printEmployees(employeeList);

        // Sort employee list by salary and age. Using Comparable.
        Collections.sort(employeeList);
        System.out.println("============ Sort by 1. age and 2. salary. Comparable =======");
        printEmployees(employeeList);

    }

    public static void printEmployees(List<Employee> list) {
        list.forEach(employee -> System.out.printf(
                "Full name - %25s; age - %d; salary - %d\n",
                employee.getFullName(), employee.getAge(), employee.getSalary()));
        System.out.println();
    }



}
