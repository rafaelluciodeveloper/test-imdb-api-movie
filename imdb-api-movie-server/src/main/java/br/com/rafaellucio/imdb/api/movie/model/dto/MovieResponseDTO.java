package br.com.rafaellucio.imdb.api.movie.model.dto;

public class MovieResponseDTO extends MovieBaseDTO {

    public MovieResponseDTO() {
        super();
    }

    public MovieResponseDTO(Integer length, String content) {
        super(length, content);
    }

}
