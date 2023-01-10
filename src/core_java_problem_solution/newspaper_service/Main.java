package core_java_problem_solution.newspaper_service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        NewsPaperServiceImpl newsPaperService = new NewsPaperServiceImpl();
        List<NewsPaper> newsPaperList = new ArrayList<>(newsPaperService.addNewsPaperDetail());
        System.out.println("Enter Publication Year");
        int year = scanner.nextInt();
        System.out.println("Enter NewsPaper Name");
        String name = scanner.next();

        int sum = newsPaperService.findTotalPriceByPublicationYear(newsPaperList,year);
        if (sum>0){
            System.out.println(sum);
        }else {
            System.out.println("No Newspaper found with the mentioned attribute");
        }

        NewsPaper newsPaper = newsPaperService.searchNewspaperByName(newsPaperList,name);
        if (newsPaper!=null){
            System.out.println(newsPaper.getRegNo()+"\n"+newsPaper.getName()+"\n"+newsPaper.getPublicationYear()+"\n"+newsPaper.getPrice());
        }else {
            System.out.println("No newspaper found with given name");
        }
    }
}
