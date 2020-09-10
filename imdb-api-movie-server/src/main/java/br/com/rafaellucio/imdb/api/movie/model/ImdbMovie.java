package br.com.rafaellucio.imdb.api.movie.model;

import java.util.Objects;

public class ImdbMovie {

    private String code;
    private String title;

    public ImdbMovie(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImdbMovie imdbMovie = (ImdbMovie) o;
        return Objects.equals(code, imdbMovie.code) &&
        		Objects.equals(title, imdbMovie.title);
                
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title);
    }

    @Override
    public String toString() {
    	return this.code + " - " + this.title;
    }
   
}
