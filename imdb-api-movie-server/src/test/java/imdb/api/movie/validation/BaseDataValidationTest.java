package imdb.api.movie.validation;

import org.junit.Test;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.validation.BaseDataValidation;

public class BaseDataValidationTest {
	
	 	@Test
	    public void separatorTest() throws ImdbApiMovieException {
	        BaseDataValidation.verifyLenght("12:The Avangers");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void blankSeparatorTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void lengthZeroTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("0:The Avangers");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void higherLengthTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("399:The Avangers");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void nullContentTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("null");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void newLineTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("\\n");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void withoutIntegerLengthTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("rrr:aaa");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void withoutLengthWithContentTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght(":aaa");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void withoutContentWithLengthTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("1:");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void justSeparatorTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght(":");
	    }

	    @Test(expected = ImdbApiMovieException.class)
	    public void withoutSeparatorButNotBlankTest() throws ImdbApiMovieException {
	         BaseDataValidation.verifyLenght("teste");
	    }
	 
}
