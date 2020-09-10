package br.com.rafaellucio.imdb.api.movie.exception;

@SuppressWarnings("serial")
public class ImdbApiMovieException extends Exception {
	public ImdbApiMovieException(String error) {
		super(error);
	}
}
