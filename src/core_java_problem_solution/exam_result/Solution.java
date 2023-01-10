package core_java_problem_solution.exam_result;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubjectMarkServiceImpl subjectMarkService = new SubjectMarkServiceImpl();
        List<Subject> subjectList = new ArrayList<>(subjectMarkService.addSubjectMarkDetail());

        List<Subject> studentRankingList = new ArrayList<>(subjectMarkService.studentRanking(subjectList));
        if (!studentRankingList.isEmpty()) {
            System.out.printf("%10s %10s %10s", "RollNo", "Name", "Percentage\n");
            for (Subject subject : studentRankingList) {
                System.out.format("%10s %10s %10s", subject.getRollNo(), subject.getName(), subject.getPercentage());
                System.out.println();
            }
        }
        System.out.println("Enter \n1.Math\n2.English\n3.Hindi\n4.Science");
        int option = scanner.nextInt();
        subjectMarkService.summaryOfSubjectMark(subjectList,option);


    }
}
