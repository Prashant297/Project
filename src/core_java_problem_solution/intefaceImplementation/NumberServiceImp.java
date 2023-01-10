package core_java_problem_solution.intefaceImplementation;

import java.util.*;
public class NumberServiceImp implements NumberService {
    @Override
    public void addNumber() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Integer> numberList = new ArrayList<>();
        System.out.println("Enter no of Number you want to enter");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            System.out.println("Enter the Number");
            int number = scanner.nextInt();
            numberList.add(number);
        }
        IntSummaryStatistics numberSummary = numberList.stream().mapToInt(Integer::shortValue).summaryStatistics();

        int n=2;
        while (n==2) {
            System.out.println("Enter\n1.Maximum\n2.Minimum\n3.Average\n4.Sum");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Max number is " + numberSummary.getMax());
                    break;
                case 2:
                    System.out.println("Min number is " + numberSummary.getMin());
                    break;
                case 3:
                    System.out.println("Average number is " + numberSummary.getAverage());
                    break;
                case 4:
                    System.out.println("Sum of Number "+numberSummary.getSum());
                    break;
                default:
                    break;
            }
            System.out.println("\ndo you want to exit \n1.Yes\n2.No");
            n = scanner.nextInt();
        }
    }
}
