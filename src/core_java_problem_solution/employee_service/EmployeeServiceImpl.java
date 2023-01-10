package core_java_problem_solution.employee_service;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
    Scanner scanner = new Scanner(System.in);

    @Override
    public List<Employee> addEmployeeDetail() {
        List<Employee> empDetailList = new ArrayList<>();
        System.out.println("Enter number of Employee you want to add");
        int add=scanner.nextInt();
        for (int i=1; i<=add; i++){
            Employee employee = new Employee();
            System.out.println("Enter "+i+" employee Id");
            employee.setEmployeeId(scanner.nextInt());
            System.out.println("Enter "+i+" employee Name");
            employee.setName(scanner.next());
            System.out.println("Enter "+i+" employee Branch");
            employee.setBranch(scanner.next());
            System.out.println("Enter "+i+" employee Rating");
            employee.setRating(scanner.nextDouble());
            System.out.println("Enter "+i+" employee Company Transport");
            employee.setComTansport(scanner.nextBoolean());
            empDetailList.add(employee);

        }
        return empDetailList;
    }
    int findCountOfEmployeesUsingCompTransport(List<Employee> employeeList,String branch) {
        int count;
        count = (int) employeeList
                .stream()
                .filter(employee -> employee.getBranch().equalsIgnoreCase(branch))
                .count();
//        for (Employee value : employeeList) {
//            if (value.getBranch().equals(branch) && value.isComTansport()) {
//                count++;
//            }
//        }
        return count;
    }
    String findEmployeeWithSecondHighestRating(List<Employee> employeeList){
        Employee employee = new Employee();
        List<Double> list;
        list = employeeList
                .stream()
                .filter(employee1 -> employee.isComTansport()==false)
                .map(employee1 -> employee1.getRating())
                .collect(Collectors.toList());

        Collections.sort(list);
//        List<Double> list =new ArrayList<>();
//        for (Employee item : employeeList) {
//            if (!item.isComTansport())
//                list.add(item.getRating());
//        }
//        if (list.isEmpty()){
//            return null;
//        }
//        list.sort(Collections.reverseOrder());

        for (Employee value : employeeList) {
            if (list.size() == 1 && value.getRating() == list.get(0) && !value.isComTansport()) {
                return value.getName() + "  " + value.getEmployeeId();
            }
            if (list.size() > 1 && value.getRating() == list.get(1) && !value.isComTansport()) {
                return value.getName() + "  " + value.getEmployeeId();
            }
        }
        return null;
    }
}
