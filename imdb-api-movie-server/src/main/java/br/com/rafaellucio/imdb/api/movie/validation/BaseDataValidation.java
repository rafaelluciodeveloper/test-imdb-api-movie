package br.com.rafaellucio.imdb.api.movie.validation;

import org.apache.commons.lang3.StringUtils;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.tools.Utilities;

public class BaseDataValidation {

    private static void querySeparatorValidate(String content) throws ImdbApiMovieException {
	        int position = Utilities.checkQuerySeparator(content);
	        try {
	            int size = Integer.parseInt(content.substring(0, position).trim());
	            int lengthLastPart = content.substring(position+1).trim().length();
	            if ( size <= 0
	                    || lengthLastPart <= 0
	                    || (lengthLastPart > 0 && size != lengthLastPart)) {
	                throw new ImdbApiMovieException("Invalid query lenght.");
	            }
	        } catch (NumberFormatException | StringIndexOutOfBoundsException ex){
                throw new ImdbApiMovieException("Invalid query lenght.");
	        }
	    }
	
    public static void verifyLenght(String content) throws ImdbApiMovieException {
        if(StringUtils.isNotBlank(content)) {
        	querySeparatorValidate(content);
        } else {
            throw new ImdbApiMovieException("Invalid query separator.");
        }
    }

}
