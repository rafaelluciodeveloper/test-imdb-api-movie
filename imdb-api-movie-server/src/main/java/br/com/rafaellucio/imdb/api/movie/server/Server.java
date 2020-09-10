package br.com.rafaellucio.imdb.api.movie.server;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;

public interface Server extends Runnable{
	void execute() throws ImdbApiMovieException;
}
