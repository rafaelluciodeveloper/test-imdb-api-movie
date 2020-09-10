package br.com.rafaellucio.imdb.api.movie.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;

public class Utilities {

    public static String encode(String url) throws ImdbApiMovieException {
        try {
            return URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new ImdbApiMovieException("Erro when encode url.");
        }
    }
  
    public static int checkQuerySeparator(String content) throws ImdbApiMovieException {
        if(content.indexOf(Configs.getQuerySeparator(), 0) <= 0
                || content.indexOf(Configs.getQuerySeparator(), 0) == (content.length()-1)) {
            throw new ImdbApiMovieException("Error validating query.");
        } else {
            return content.indexOf(Configs.getQuerySeparator(), 0);
        }
    }

}
