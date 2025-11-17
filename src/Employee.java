import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    public static void main(String[] args) {
        List<EmployeeDto> list = new ArrayList<>();
        list.add(new EmployeeDto("Shivani" , 22 , "2025" , 7000000));
        list.add(new EmployeeDto("sonu", 22 , "2026" , 800000));
        System.out.println("-----All the employees----------");
        System.out.println(list.stream().map(employeeDto -> employeeDto.getName()).collect(Collectors.toList()));
        System.out.println(list.stream().map(employeeDto -> employeeDto.getAge()).collect(Collectors.toList()));













        list.stream().map(employeeDto -> new EmployeeDto(employeeDto.getName(),
                employeeDto.getAge(),employeeDto.getYOJ(), employeeDto.getSalary()+employeeDto.getSalary()*0.05 )).forEach(System.out::println);



    }
}
