public class Store {
    private Movie movies[];

    public Store() {
        this.movies = new Movie[10];
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies[index]);
    }

    public void setMovie(int index, Movie movie) {
        Movie copy = new Movie(movie);
        this.movies[index] = copy;
    }

    public String toString() {
        String temp = "";
        for (Movie movie : movies) {
            temp += movie.toString() + "\n";
        }
        return temp;
    }
}
