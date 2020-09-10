package br.com.rafaellucio.imdb.api.movie.parser;

import java.util.Optional;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieRequestDTO;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieResponseDTO;

public interface ClientParser {
    Optional<MovieRequestDTO> createRequest(Optional<String> optionalRequestContent) throws ImdbApiMovieException;
    Optional<MovieResponseDTO> createResponse(Optional<ImdbResponse> optionalImdbResponse) throws ImdbApiMovieException;
}
