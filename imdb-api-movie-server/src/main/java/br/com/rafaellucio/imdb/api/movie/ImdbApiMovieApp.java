package br.com.rafaellucio.imdb.api.movie;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.server.Server;
import br.com.rafaellucio.imdb.api.movie.server.impl.ServerImpl;

public class ImdbApiMovieApp {
	public static void main(String[] args) throws ImdbApiMovieException {
        Server server = new ServerImpl();
        server.execute();
	}
}
