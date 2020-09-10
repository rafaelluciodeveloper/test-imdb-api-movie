package br.com.rafaellucio.imdb.api.movie.imdb.connection;

import java.util.Optional;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;

public interface ImdbConnection {
    Optional<ImdbResponse> searchByMovieTitle(String title) throws ImdbApiMovieException;
}
