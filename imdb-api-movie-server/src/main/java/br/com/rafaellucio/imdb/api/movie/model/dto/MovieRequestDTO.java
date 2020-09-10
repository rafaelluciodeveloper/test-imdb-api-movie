package br.com.rafaellucio.imdb.api.movie.model.dto;

public class MovieRequestDTO extends MovieBaseDTO {

    public MovieRequestDTO() {
        super();
    }

    public MovieRequestDTO(Integer length, String content) {
        super(length, content);
    }

}
