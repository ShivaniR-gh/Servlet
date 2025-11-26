public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;
    private String designation;

    public Employee(int id, String name, int age, double salary, String department, String designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + age + " - " + salary
                + " - " + department + " - " + designation;
    }
}
