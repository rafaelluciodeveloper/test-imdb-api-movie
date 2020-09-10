package br.com.rafaellucio.imdb.api.movie.model;

import java.util.List;
import java.util.Objects;

public class ImdbResponse {

    private List<ImdbMovie> movies;

    public ImdbResponse(){
    }

    public ImdbResponse(List<ImdbMovie> movies) {
        this.movies = movies;
    }

    public List<ImdbMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<ImdbMovie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImdbResponse that = (ImdbResponse) o;
        return Objects.equals(movies, that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movies);
    }

}
