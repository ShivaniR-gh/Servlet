import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalRunner {
    public static void main(String[] args) {

EmployeeDto employeeDto = new EmployeeDto("shivani ", 22 , "2025",100000);
Optional<EmployeeDto> employeeDto1 = Optional.of(employeeDto);
System.out.println(employeeDto1.get());

EmployeeDto employeeDto2 = null;
Optional.ofNullable(employeeDto2);
//Optional.of(employeeDto2); Null pointer exception
        List<EmployeeDto> employeeDtoList = new LinkedList<>();
        employeeDtoList.add(1,employeeDto);

        String age ="11111";
         int age1 = Integer.parseInt(age);
        System.out.println(age1);

        Optional<String> nameOptional = Optional.of("Shivani");
        System.out.println(nameOptional);

        Optional<String> nullableOptional = Optional.ofNullable(null);


//        if (nameOptional.isPresent()) {
//            System.out.println("Name: " + nameOptional.get());
//        }

        String name = nullableOptional.orElse("Default Name");
        System.out.println("Result: " + name);

       // nameOptional.ifPresent(value -> System.out.println("Value exists: " + value));

    }
}


