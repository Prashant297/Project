package core_java_problem_solution.newspaper_service;

import java.util.*;

public class NewsPaperServiceImpl implements NewsPaperService {
    @Override
    public List<NewsPaper> addNewsPaperDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<NewsPaper> newsPaperList = new ArrayList<>();

        System.out.println("Enter number of Song you want ");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            NewsPaper newsPaper = new NewsPaper();
            System.out.println("Enter NewsPaper regNo");
            newsPaper.setRegNo(scanner.nextInt());
            System.out.println("Enter NewsPaper Name");
            newsPaper.setName(scanner.next());
            System.out.println("Enter NewsPaper Publish Year");
            newsPaper.setPublicationYear(scanner.nextInt());
            System.out.println("Enter NewsPaper Price");
            newsPaper.setPrice(scanner.nextInt());
            newsPaperList.add(newsPaper);
        }
        return newsPaperList;
    }
    static int findTotalPriceByPublicationYear(List<NewsPaper> newsPaperList,int year){
        return newsPaperList.stream().
                filter(newsPaper -> newsPaper.getPublicationYear()==year)
                .mapToInt(NewsPaper::getPrice).sum();
    }

    static NewsPaper searchNewspaperByName(List<NewsPaper> newsPaperList,String name){
        return newsPaperList.stream()
                .filter(newsPaper -> newsPaper.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}
