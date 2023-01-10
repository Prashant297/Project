package movieRating;

import movieRating.service.MoviesValidationServicesImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Map<String,Movie> map = new LinkedHashMap<>();
        final Map<String,MovieRating> rateMap = new LinkedHashMap<>();
        MoviesValidationServicesImpl service = new MoviesValidationServicesImpl();
        service.role(map,rateMap);
    }
}

