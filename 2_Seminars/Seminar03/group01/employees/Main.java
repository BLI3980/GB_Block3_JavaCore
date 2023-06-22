package group01.employees;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task 01
        Employee employee1 = new Employee("Ivanov Ivan Ivanovich", "manager",
                111111, 1000, 32);
        Employee employee2 = new Employee("Petrov Petr Petrovich", "director",
                222222, 100000, 50);
        Employee employee3 = new Employee("Sidorov Sidor Sidorovich", "accountant",
                333333, 10000, 46);

        // Task 02
        System.out.println("============Task02=============");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3.toString());

        // Task 03
        System.out.println("============Task03=============");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        salaryIncrease(employeeList);
        System.out.println();
        employeeList.forEach(System.out::println);

        // Task 04
        System.out.println("============Task04=============");
        salaryIncrease(employeeList, 7000, 49);
        employeeList.forEach(System.out::println);

    }

    // Task 03
//    public static void salaryIncrease(List<Employee> employeeList) {
//        for (Employee employee: employeeList) {
//            if (employee.getAge() >= 45) {
//                employee.setSalary(employee.getSalary() + 5000);
//            }
//        }
//    }

    // Modified method after completion of task04.
    public static void salaryIncrease(List<Employee> employeeList) {
        salaryIncrease(employeeList, 5000, 45);
    }

    // Task 04
    public static void salaryIncrease(List<Employee> employeeList, int increase, int age) {
        for (Employee employee: employeeList) {
            if (employee.getAge() >= age) {
                employee.setSalary(employee.getSalary() + increase);
            }
        }
    }


}
