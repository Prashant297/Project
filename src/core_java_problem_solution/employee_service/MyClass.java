package core_java_problem_solution.employee_service;


import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>(employeeService.addEmployeeDetail());
        System.out.println("Enter branch id");
        String branch = scanner.next();
        int count = employeeService.findCountOfEmployeesUsingCompTransport(employees,branch);

        if(count>0){
            System.out.println(count);
        }else {
            System.out.println("No Such Employee");
        }

        String rate= employeeService.findEmployeeWithSecondHighestRating(employees);
        System.out.println(Objects.requireNonNullElse(rate, "All Company using Company Transport"));
    }
}

