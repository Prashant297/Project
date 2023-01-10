package core_java_problem_solution.exam_result;

import java.util.*;
import java.util.stream.Collectors;

public class SubjectMarkServiceImpl implements SubjectMarkService{

    @Override
    public List<Subject> addSubjectMarkDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Subject> subjectList = new ArrayList<>();
        System.out.println("Enter No. of subject Mark you want to add");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Subject subject = new Subject();
            System.out.println("Enter Student RollNo");
            subject.setRollNo(scanner.nextInt());
            System.out.println("Enter Student Name");
            subject.setName(scanner.next());
            System.out.println("Enter English mark");
            subject.setEnglishMark(scanner.nextInt());
            System.out.println("Enter Science mark");
            subject.setScienceMark(scanner.nextInt());
            System.out.println("Enter Hindi Mark");
            subject.setHindiMark(scanner.nextInt());
            System.out.println("Enter Math Mark");
            subject.setMathMark(scanner.nextInt());
            subjectList.add(subject);
        }
        return subjectList;
    }

    static List<Subject> studentRanking(List<Subject> subjectList){
        List<Subject> studentRankingList = new ArrayList<>();
        double percentage;
        for (Subject subject : subjectList){
            if(subject.getMathMark()>35 && subject.getHindiMark()>35 && subject.getScienceMark()>35 && subject.getEnglishMark()>35) {
                percentage = (subject.getEnglishMark() + subject.getHindiMark() + subject.getScienceMark()) / 3;
                percentage = (percentage + subject.getMathMark()) / 2;
                subject.setName(subject.getName());
                subject.setRollNo(subject.getRollNo());
                subject.setPercentage(percentage);
                studentRankingList.add(subject);
            }
        }
        studentRankingList.sort(Comparator.comparingDouble(Subject::getPercentage).reversed());
        return studentRankingList;
    }

    static void summaryOfSubjectMark(List<Subject> subjectList,int option){
        IntSummaryStatistics sub = null;
        List<Integer> subjectMarkList = new ArrayList<>();
        String subject = null;
        switch (option){
            case 1 : subject = "Math";
                     sub = subjectList.stream().mapToInt(Subject::getMathMark).summaryStatistics();
                     subjectMarkList = subjectList.stream().map(Subject::getMathMark).collect(Collectors.toList());
            break;
            case 2 : subject="English";
                    sub =  subjectList.stream().mapToInt(Subject::getEnglishMark).summaryStatistics();
                    subjectMarkList = subjectList.stream().map(Subject::getEnglishMark).collect(Collectors.toList());
            break;
            case 3 : subject="Hindi";
                    sub =  subjectList.stream().mapToInt(Subject::getHindiMark).summaryStatistics();
                    subjectMarkList = subjectList.stream().map(Subject::getHindiMark).collect(Collectors.toList());
            break;
            case 4 :  subject="Science";
                    sub = subjectList.stream().mapToInt(Subject::getScienceMark).summaryStatistics();
                    subjectMarkList = subjectList.stream().map(Subject::getScienceMark).collect(Collectors.toList());
            break;
            default: break;
        }
        System.out.println(subject+" Mark");
         subjectMarkList.forEach(System.out::println);
        assert sub != null;
        System.out.println("Average mark in "+subject+"Subject is "+sub.getAverage());

    }
}

