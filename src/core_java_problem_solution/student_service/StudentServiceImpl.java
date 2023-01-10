package core_java_problem_solution.student_service;

import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> addStudentDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Student> studentList = new ArrayList<>();
        System.out.println("Enter number of student detail you want");
        int num = scanner.nextInt();
        for (int i =0; i<num; i++){
            Student student = new Student();
            System.out.println("Enter student rollNo");
            student.setRollNo(scanner.nextInt());
            System.out.println("Enter student name");
            student.setName(scanner.next());
            System.out.println("Enter student branch");
            student.setBranch(scanner.next());
            System.out.println("Enter student score");
            student.setScore(scanner.nextInt());
            System.out.println("Enter Student dayScholar");
            student.setDayScholar(scanner.nextBoolean());

            studentList.add(student);
        }
        return studentList;
    }
    static int findCountOfDayScholarStudents(List<Student> studentList){
        return (int) studentList.stream()
                .filter(student -> student.isDayScholar() && student.getScore()>=80)
                .count();
    }

    static Student findStudentWithSecondHighestScore(List<Student> studentList){
        List<Double> list = studentList.stream()
                .filter(student -> !student.isDayScholar())
                .map(Student::getScore)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        if (list.size()==1) {
            for (Student student : studentList) {
                if (!student.isDayScholar() && student.getScore() == list.get(0)) {
                    return student;
                }
            }
        }
        if (list.size()==2){
            for (Student student : studentList){
                if (!student.isDayScholar() && student.getScore()==list.get(1)){
                    return  student;
                }
            }
        }
        return null;
    }
}
