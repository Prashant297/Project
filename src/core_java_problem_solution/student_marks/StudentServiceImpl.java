package core_java_problem_solution.student_marks;

import java.io.*;
import java.util.*;

public class StudentServiceImpl implements StudentService{
    @Override
    public Map<Integer,Student> addStudentDetail() throws IOException {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        Map<Integer,Student> studentMap = new HashMap<>();
        System.out.println("Number of student you want to enter");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Student student = new Student();
            System.out.println("Enter Student Name");
            student.setName(scanner.next());
            System.out.println("Enter Student branch");
            student.setBranch(scanner.next());
            System.out.println("Enter Student Mark");
            student.setMark(scanner.nextInt());
            studentMap.put(i+1,student);
        }
        return studentMap;
    }

    static void maxAndMin(Map<Integer,Student> studentMap, String branch){

        IntSummaryStatistics stat = studentMap.values().stream()
                .filter(student -> student.getBranch().equalsIgnoreCase(branch))
                .mapToInt(Student::getMark).summaryStatistics();

        System.out.println("\u001B[33m"+"Maximum "+stat.getMax()+"\nMinimum "+stat.getMin()+"\u001B[5m");
        System.out.println("IT= "+stat.getCount());

    }
}
