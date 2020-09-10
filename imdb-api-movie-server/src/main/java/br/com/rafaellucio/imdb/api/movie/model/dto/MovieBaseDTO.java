package br.com.rafaellucio.imdb.api.movie.model.dto;

import java.util.Objects;

public class MovieBaseDTO {

    private Integer length;
    private String content;

    public MovieBaseDTO(){
    }

    public MovieBaseDTO(Integer length, String content) {
        this.length = length;
        this.content = content;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieBaseDTO baseModel = (MovieBaseDTO) o;
        return Objects.equals(length, baseModel.length) &&
                Objects.equals(content, baseModel.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, content);
    }


}
