package core_java_problem_solution.student_marks;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("\u001B[31m \u001B[5m");

        StudentServiceImpl studentService = new StudentServiceImpl();
        Map<Integer,Student> studentMap = new HashMap<>(studentService.addStudentDetail());
        System.out.println("\u001B[35m \u001B[5m"+"Enter Student branch");
        String branch = scanner.next();

        studentService.maxAndMin(studentMap,branch);


    }
}
