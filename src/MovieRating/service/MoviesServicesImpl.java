package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.util.*;

public class MoviesServicesImpl implements MoviesService{
    Scanner sc=new Scanner(System.in);

    @Override
    public int movies(Map<String, Movie> map, int r, Map<String, MovieRating> ratemap) {
        if (r==5){
            filterMovies(map);
        }
        if (r==4){
            updateMovie(map);
        }
        if (r==3){
            deleteOldMovies(map);
        }
     if (r==2){
         if(displayMovies(map)==1) {
             System.out.println("No Data Available");
             return 1;
         }else
             return 0;
     }
        if (r == 1)
            addMovie(map,ratemap);
        return 0;
    }

    @Override
    public int displayMovies(Map<String, Movie> map) {
        if (map.isEmpty()){
            return 1;
        }
        System.out.printf("%10s %15s %10s %20s %20s %15s %10s","Movie Name","Release Year",
                "Cast","Current Price","Previous Price","Income cr.","Status");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie s = entry.getValue();
            System.out.println("Movie Id "+entry.getKey() );
            System.out.format("%10s  %10s %20s %10s %20s %15s %15s", s.getMovieName(),
                    s.getReleaseYear(), s.getCast(), s.getCurrentPrice(), s.getPreviousPrice(),
                    s.getIncomeInCr(),s.getMovieStatus(),"\n");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }
        return 0;
    }

    public void addMovie(Map<String, Movie> map, Map<String, MovieRating> ratemap)  {
        MoviesValidationServicesImpl moviesValidationServices = new MoviesValidationServicesImpl();
        Movie movie = new Movie();
        int releaseYear;
        int currentPrice;
        int previousPrice;
        int income;
        int r;
        String name;
        String cast;
        System.out.println("Enter \n 1.Add Movie\n 2.Display Movie \n 3.Delete Movie \n 4.Update \n5.Filter \n 6.Exit");
        r=sc.nextInt();
        while (true) {
            if(r==1){
            System.out.println("Enter Movie Name");
            name = sc.next();
            movie.setMovieName(name);
            System.out.println("Enter Release Year");
            releaseYear = sc.nextInt();
            movie.setReleaseYear(releaseYear);
            if (moviesValidationServices.checkYear(releaseYear) == 1) {
                break;
            }
            System.out.println("Enter cast");
            cast = sc.next();
            movie.setCast(cast);
            System.out.println("Enter current Price");
            currentPrice = sc.nextInt();
            movie.setCurrentPrice(currentPrice);
            System.out.println("Enter Previous Price");
            previousPrice = sc.nextInt();
            movie.setPreviousPrice(previousPrice);
            System.out.println("Enter income in crore");
            income = sc.nextInt();
            movie.setIncomeInCr(income);
            movie.setMovieStatus(moviesValidationServices.checkStatus(releaseYear));
            map.put(uniqeString(),new  Movie(movie.getMovieStatus(),movie.getMovieName(),movie.getReleaseYear(),movie.getCast(),
                    movie.getCurrentPrice(),movie.getPreviousPrice(),movie.getIncomeInCr()));
        }
            if(r==2){
                displayMovies(map);
            }
            if (r==3){
                deleteOldMovies(map);
            }
            if (r==4){
                updateMovie(map);
            }
            if (r==5){
                filterMovies(map);
            }
            if(r==6) {
                moviesValidationServices.role(map, ratemap);
                break;
            }
            System.out.println("Enter \n 1.Add Movie\n 2.Display Movie \n 3.Delete \n 4.Update \n 5.Filter \n 6.Exit");
            r=sc.nextInt();

        }
    }

    @Override
    public int deleteOldMovies(Map<String,Movie> map) {
        if(displayMovies(map)==1) {
            System.out.println("NO Movie Exit");
            return 0;
        }
        System.out.println("Select Movie Id You Want To Delete");
        String delete = sc.next();
        if (map.containsKey(delete)){
            map.remove(delete);
            System.out.println("Deleted Successfully \n");
        }else {
            System.out.println("Movie id Dosent exit");
        }
        return 0;
    }

    @Override
    public int updateMovie(Map<String, Movie> map) {
        if(displayMovies(map)==1) {
            System.out.println("NO Movie Exit");
            return 0;
        }
        System.out.println("Select Movie Id You Want To Update");
        String update = sc.next();
            updateMovieField(map,update);
        return 0;
    }

    @Override
    public void updateMovieField(Map<String, Movie> map, String update) {
        MoviesValidationServicesImpl moviesValidationServices = new MoviesValidationServicesImpl();
        String updateField;
        int updateInt;
        int field;
        System.out.println("Select to Change\n1.Movie Name\n2.Release Year \n3.Cast\n4.Current Price\n5.Previous Price\n6.Income ");
        field= sc.nextInt();
            for (Map.Entry<String, Movie> entry : map.entrySet()) {
                Movie movie1 = entry.getValue();
                String key = entry.getKey();
                if (map.containsKey(update)) {
                    switch (field){
                        case 1:
                            if (update.equals(key)) {
                                System.out.println("Enter Movie Name");
                                updateField = sc.next();
                                movie1.setMovieName(updateField);
                            }
                            break;
                        case 2:
                            if (update.equals(key)) {
                                System.out.println("Enter Release Year");
                            updateInt = sc.nextInt();
                            if(moviesValidationServices.checkYear(updateInt)==1){break;}
                            movie1.setMovieStatus(moviesValidationServices.checkStatus(updateInt));
                            movie1.setReleaseYear(updateInt);
                            }
                            break;
                        case 3:
                            if (update.equals(key)) {
                                System.out.println("Enter CAst");
                                updateField = sc.next();
                                movie1.setCast(updateField);
                            }
                            break;
                        case 4:
                            if (update.equals(key)) {
                                System.out.println("Enter Current price");
                                updateInt = sc.nextInt();
                                movie1.setCurrentPrice(updateInt);
                            }
                            break;
                        case 5:
                            if (update.equals(key)) {
                                System.out.println("Enter Previous Price");
                                updateInt = sc.nextInt();
                                movie1.setPreviousPrice(updateInt);
                            }
                            break;
                        case 6:
                            if (update.equals(key)) {
                                System.out.println("Enter Income ");
                                updateInt = sc.nextInt();
                                movie1.setIncomeInCr(updateInt);
                            }
                        break;
                        default:break;
                    }
                }
            }
        }

    @Override
    public void filterMovies(Map<String, Movie> map) {
        MoviesFilterServiceImpl moviesFilterService = new MoviesFilterServiceImpl();
        System.out.println("Filter\n1.Status\n2.Year\n3.Rate");
        int filter = sc.nextInt();
        switch (filter){
            case 1:moviesFilterService.statusFilter(map);
            break;
            case 2:moviesFilterService.yearFilter(map);
            break;
            case 3: moviesFilterService.rateFilter(map);
            default:break;
        }
    }

    @Override
    public String uniqeString() {
        {
            UUID uniqueString = UUID.randomUUID();
            return uniqueString.toString().substring(30);
        }
    }

}

