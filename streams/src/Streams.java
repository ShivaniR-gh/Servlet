import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Streams {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        Employee employee= new Employee(1, "Shivani", 24, 55000, "IT", "Developer");
        Employee employee1= new Employee(2, "Shivani", 24, 55000, "IT", "Developer");

        list.add(employee);
        list.add(employee1);
        list.add(new Employee(3, "Meena", 29, 48000, "HR", "HR Executive"));
        list.add(new Employee(4, "Arjun", 40, 95000, "Finance", "Manager"));
        list.add(new Employee(5, "Sneha", 35, 68000, "IT", "Lead"));
        list.add(new Employee(6, "Mahesh", 42, 85000, "Admin", "Admin Manager"));


        Iterator<Employee> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n=== All Employees ===");
        list.stream().forEach(System.out::println);

        System.out.println("\n=== Employees age > 30 ===");
        list.stream().filter(e -> e.getAge() >30 ).forEach(System.out::println);
        //list.stream().sorted().forEach(System.out::println);

        System.out.println("\n=== Highest Salary Employee ===");
        System.out.println(list.stream().max(Comparator.comparing(Employee::getSalary)));

        System.out.println("\n=== lowest Salary Employee ===");
        System.out.println(list.stream().min(Comparator.comparing(Employee::getSalary)));


        System.out.println("name");
        list.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("sort");
        list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

    }
}
