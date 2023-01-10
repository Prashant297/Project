package core_java_problem_solution.student_service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();

        List<Student> studentList = new ArrayList<>(studentService.addStudentDetail());
        int count = StudentServiceImpl.findCountOfDayScholarStudents(studentList);
        Student student = studentService.findStudentWithSecondHighestScore(studentList);

        if (count>0){
            System.out.println(count);
        }else {
            System.out.println("There are no such dayScholar students");
        }

        if (student!=null){
            System.out.println(student.getRollNo()+" # "+student.getName()+" # "+student.getScore());
        }else {
            System.out.println("There are no student from non day scholar");
        }
    }
}
