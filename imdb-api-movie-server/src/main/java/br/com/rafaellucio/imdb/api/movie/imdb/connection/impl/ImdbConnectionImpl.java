package br.com.rafaellucio.imdb.api.movie.imdb.connection.impl;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.imdb.connection.ImdbConnection;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;
import br.com.rafaellucio.imdb.api.movie.parser.ImdbParser;
import br.com.rafaellucio.imdb.api.movie.tools.Utilities;

import java.io.IOException;
import java.util.Optional;

public class ImdbConnectionImpl implements ImdbConnection {

    private static final int TIMEOUT = 5000;
    private static final String TITLE_IDENTIFIER = "$TITLE";
    private static final String IMDB_SEARCH_URL = "https://www.imdb.com/find?q=$TITLE&s=tt&ref_=fn_al_tt_mr";

    private ImdbParser imdbParser;

    public ImdbConnectionImpl(ImdbParser imdbParser) {
        this.imdbParser = imdbParser;
    }

    //search movie 
    @Override
    public Optional<ImdbResponse> searchByMovieTitle(String titleMovie) throws ImdbApiMovieException {
        try {
            return this.connectImdb(titleMovie);
        } catch (Exception e){
            throw new ImdbApiMovieException("Movie not found.");
        }
    }

  
    //connect to imdb
    private Optional<ImdbResponse> connectImdb(String titleMovie) throws ImdbApiMovieException {
        try {
            String url = IMDB_SEARCH_URL.replace(TITLE_IDENTIFIER, Utilities.encode(titleMovie));
            Connection connection = Jsoup.connect(url).timeout(TIMEOUT);
            return imdbParser.parserImdbResponse(connection.get());
        } catch (IOException e) {
            throw new ImdbApiMovieException("Erro connecting to imdb.");
        }
    }



}
