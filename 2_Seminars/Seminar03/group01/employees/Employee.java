package group01.employees;

public class Employee {
    private String fullName;
    private String position;
    private long phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, int phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Employee information: \n" +
                "Full name: %s;\n" +
                "Position: %s;\n;" +
                "Phone: %d;\n" +
                "Salary: %d;\n" +
                "Age: %d.\n", getFullName(), getPosition(), getPhone(), getSalary(), getAge());
    }
}
