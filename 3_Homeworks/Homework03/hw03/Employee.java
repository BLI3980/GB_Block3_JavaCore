package hw03;

public class Employee implements Comparable<Employee>{
    private String fullName;
    private String position;
    private long phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, long phone, int salary, int age) {
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

    public void setPhone(long phone) {
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
        return String.format("%s information: \n" +
                "Full name: %s;\n" +
                "Position: %s;\n" +
                "Phone: %d;\n" +
                "Salary: %d;\n" +
                "Age: %d.\n",
                getClass().getSimpleName(), getFullName(), getPosition(),
                getPhone(), getSalary(), getAge());
    }

//    @Override
//    public int compareTo(Employee o) {
//        if (this.salary < o.salary) return -1;
//        else if (this.salary > o.salary) return 1;
//        else return 0;
//    }
    @Override
    public int compareTo(Employee o) {
        if (this.age == o.age) return this.salary - o.salary;
        else return this.age - o.age;
    }
}
