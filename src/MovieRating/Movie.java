package MovieRating;

import MovieRating.service.MovieRatingServiceImpl;

public class Movie {
    public MovieRatingServiceImpl.movieStatus getMovieStatus() {
        return movieStatus;
    }

    public MovieRatingServiceImpl.movieStatus movieStatus;
    String movieName;
    int releaseYear;
    String cast;
    int currentPrice;
    int previousPrice;
    int incomeInCr;

    public Movie() {

    }

    public String getMovieName() {
        return movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCast() {
        return cast;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public int getPreviousPrice() {
        return previousPrice;
    }

    public int getIncomeInCr() {
        return incomeInCr;
    }

    public void setMovieStatus(MovieRatingServiceImpl.movieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setPreviousPrice(int previousPrice) {
        this.previousPrice = previousPrice;
    }

    public void setIncomeInCr(int incomeInCr) {
        this.incomeInCr = incomeInCr;
    }

    public Movie( MovieRatingServiceImpl.movieStatus movieStatus, String movieName, int releaseYear, String cast, int currentPrice, int previousPrice, int incomeInCr) {
        this.movieStatus = movieStatus;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.cast = cast;
        this.currentPrice = currentPrice;
        this.previousPrice = previousPrice;
        this.incomeInCr = incomeInCr;
    }
}
