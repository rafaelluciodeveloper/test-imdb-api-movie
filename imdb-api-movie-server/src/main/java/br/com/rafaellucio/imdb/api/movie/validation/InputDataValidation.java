package br.com.rafaellucio.imdb.api.movie.validation;

import org.apache.commons.lang3.StringUtils;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;

public class InputDataValidation extends BaseDataValidation {

    public static void verify(String content) throws ImdbApiMovieException {
        if(StringUtils.isNotBlank(content)){
        	verifyLenght(content);
        } else {
            throw new ImdbApiMovieException("Invalid input data.");
        }
    }

}
