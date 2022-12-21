package Movie_Rating;

public class MovieRating {
    int userId;
    int movieId;
    int rating;
    String description;

    public int getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovieRating(int userId, int movieId, int rating, String description){
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.description = description;
    }

}
