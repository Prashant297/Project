package Movie_Rating.service;

import Movie_Rating.Movie;
import Movie_Rating.MovieRating;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MovieRatingServiceImpl implements MovieRatingService{
    public enum movieStatus {
        PAST,
        PRESENT,
        FUTURE

    }
    @Override
    public void displayRating(Map<String, MovieRating> maps) {
        System.out.printf("%10s %15s %10s %20s %10s", "User ID", "Movie ID", "Rating", "Description", "Date\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, MovieRating> entry : maps.entrySet()) {
            MovieRating s = entry.getValue();
            System.out.format("%10s %15s %10s %15s %15s", s.getUserId(), s.getMovieId(), s.getRating(), s.getDescription(),"\t\t"+ entry.getKey()+"\n");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
    @Override
    public int checkMovieId(Map<Integer, Movie> map, Integer mid, List<Integer> list) {
        movieStatus enumVal = movieStatus.FUTURE;
        for (Map.Entry<Integer, Movie> entry : map.entrySet()) {
            int key = entry.getKey();
            Movie mv = entry.getValue();
            if ((key == mid) && (enumVal.equals(mv.movieStatus))) {
                System.out.println("You can't rate the Upcoming Movie");
                return 1;
            }
        }
        if (list.contains(mid)) {
            System.out.println("You cannot insert same movie id twice ");
            System.out.println();
            return 1;
        }
        list.add(mid);
        if (!map.containsKey(mid)) {
            return 1;
        }
        return 0;
    }
    @Override
    public int checkRating(int rate) {
        if (rate < 0 || rate > 5) {
            System.out.println("Invalid rating");
            return 1;
        }
        return 0;
    }
    @Override
    public movieStatus checkStatus(int year) {
        if (year < 2022) {
            return movieStatus.PAST;
        } else if (year == 2022) {
            return movieStatus.PRESENT;
        } else {
            return movieStatus.FUTURE;
        }
    }
    @Override
    public void role(Map<Integer, Movie> map, Map<String, MovieRating> rateMap) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> adminLogin = new HashMap<>();
        adminLogin.put("Prashant",1234);

        int r;
        System.out.println("Login as \n1.Admin \n 2.User \n 3.Exit");
        r = sc.nextInt();
        switch (r) {
            case 1:
                System.out.println("Enter Admin Id");
                String adminId= sc.next();
                System.out.println("Enter Password");
                int password=sc.nextInt();
                if (adminLogin.containsKey(adminId) && adminLogin.containsValue(password))
                {
                    movies(map,r,rateMap);
                }else {
                    System.out.println("Invalid AdminId or Password");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    role(map,rateMap);
                }
                break;
            case 2:
                System.out.println("Welcome to Rating Interface");
                movies(map, r, rateMap);
                System.out.println("Rate the Movies");
                ratingDetail(rateMap, map);
                break;
            default:
                break;
        }
    }
    @Override
    public void ratingAverage(Map<String, MovieRating> rateMap, Map<Integer, Float> hashMap, int select) {
        float count=1;
        float star=0;
        float n;
        for (Map.Entry<String, MovieRating> entry : rateMap.entrySet()) {
            MovieRating movieRating = entry.getValue();
            if (movieRating.getMovieId() ==select){
                star = star+ movieRating.getRating();
                n = (star / count);
                count++;
                hashMap.put(movieRating.getMovieId(), n);
            }
        }
        displayAvgRating(hashMap);
    }
    @Override
    public int checkYear(int releaseYear) {
        if (releaseYear<1800 || releaseYear>3000) {
            System.out.println("Cannot enter Movie year less than 1800 and more than 3000");
            return 1;
        }
        return 0;
    }
    @Override
    public void displayAvgRating(Map<Integer, Float> hashMap) {
        System.out.print("Movies Rating");
        System.out.println("\nMovie id\t Movie rating \t");

        for (Map.Entry<Integer,Float> entry: hashMap.entrySet()){
            System.out.println( "\t"+entry.getKey()+"\t\t\t"+entry.getValue());
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }
    @Override
    public void movies(Map<Integer, Movie> map, int r, Map<String, MovieRating> ratemap) {
        Movie movie = new Movie("welcome",2011,"Akshay Kumar",100,150,100, movieStatus.PAST);
        Movie movie1 = new Movie("krish",2014,"Hritik Roshan",150,250,120, movieStatus.PAST);

        map.put(1,movie);
        map.put(2,movie1);
        if (r == 2) {
            displayMovies(map);
        }
        if (r == 1) {
            addMovie(map,ratemap);
        }
    }
    @Override
    public void displayMovies(Map<Integer, Movie> map) {
        System.out.printf("%10s %15s %10s %20s %20s %15s %10s","Movie Name","Release Year",
                "Cast","Current Price","Previous Price","Income cr.","Status");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<Integer, Movie> entry : map.entrySet()) {
            Movie s = entry.getValue();
            System.out.println("Movie Id "+entry.getKey() );
            System.out.format("%10s  %10s %20s %10s %20s %15s %15s", s.getMovieName(), s.getReleaseYear(), s.getCast(), s.getCurrentPrice(), s.getPreviousPrice(), s.getIncomeInCr(),s.movieStatus,"\n");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void addMovie(Map<Integer, Movie> map, Map<String, MovieRating> ratemap) {
        MovieRatingService service = new MovieRatingServiceImpl();
        Scanner sc=new Scanner(System.in);
        int loop = 3;
        int releaseYear;
        int currentPrice;
        int previousPrice;
        int income;
        int r;
        String name;
        String cast;
        System.out.println("Enter \n 1.Add Movie\n 2.Display Movie \n 3.Exit");
        r=sc.nextInt();
        while (r <4) {
            if(r==2){
                displayMovies(map);
                System.out.println("Enter\n 1.Add Movie\n2.Display Movie\n3.Exit");
                r=sc.nextInt();
            }
            if(r>=3) {
                service.role(map, ratemap);
                break;
            }
            System.out.println("Enter Movie Name");
            name= sc.next();
            System.out.println("Enter Release Year");
            releaseYear= sc.nextInt();
            if (service.checkYear(releaseYear)==1){break;}
            System.out.println("Enter cast");
            cast=sc.next();
            System.out.println("Enter current Price");
            currentPrice=sc.nextInt();
            System.out.println("Enter Previous Price");
            previousPrice=sc.nextInt();
            System.out.println("Enter income in crore");
            income =sc.nextInt();

            Movie addMovie = new Movie(name,releaseYear, cast, currentPrice, previousPrice, income, service.checkStatus(releaseYear) );
            map.put(loop,addMovie);
            loop++;
            System.out.println("Enter \n 1.Add Movie\n 2.Display Movie \n 3.Exit");
            r=sc.nextInt();

        }
    }
    @Override
    public void ratingDetail(Map<String, MovieRating> rateMap, Map<Integer, Movie> map) {
        Scanner sc = new Scanner(System.in);
        final List<Integer> list = new ArrayList<>();
        final HashMap<Integer,Float> hashMap = new HashMap<>();
        MovieRatingService service = new MovieRatingServiceImpl();
        int i=0;
        int select;
        int rate;
        String describe;

        System.out.println("Enter user id");
        int use= sc.nextInt();
        while (i<=1){

            System.out.println("Select  Movie id you want to Rate");
            select=sc.nextInt();
            if(service.checkMovieId(map,select,list)==1){
                System.out.println("Invalid MovieID");
                System.out.println("-----------------------------------------");
                System.out.println();
                service.role(map,rateMap);
            }
            System.out.println("Give rating");
            rate = sc.nextInt();
            if (service.checkRating(rate)==1) {service.role(map,rateMap);}
            System.out.println("Describe about movie");
            describe=sc.next();
            System.out.println();
            MovieRating movieRating = new MovieRating(use,select, rate,describe);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
            LocalDateTime localDateTime= LocalDateTime.now();
            String dateTime = localDateTime.format(formatter);
            rateMap.put(dateTime,movieRating);
            System.out.println("Enter \n 1.Continue \n 2.Display \n 3.Exit ");
            i= sc.nextInt();
            if(i==2) {
                service.displayRating(rateMap);
                service.ratingAverage(rateMap,hashMap,select);
                System.out.println("Enter \n 1.Continue \n 2.Display \n 3.Exit ");
                i= sc.nextInt();
            }
            if (i==3){
                service.role(map, rateMap);
            }


        }

    }
}
