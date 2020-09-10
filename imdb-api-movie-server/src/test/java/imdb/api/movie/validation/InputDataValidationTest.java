package imdb.api.movie.validation;

import org.junit.Test;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.validation.InputDataValidation;

public class InputDataValidationTest {

	@Test
	public void separatorTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("12:The Avangers");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void blankSeparatorTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void lengthZeroTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("0:The Avangers");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void higherLengthTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("399:The Avangers");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void nullContentTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("null");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void newLineTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("\\n");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutIntegerLengthTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("rrr:aaa");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutLengthWithContentTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght(":aaa");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutContentWithLengthTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("1:");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void justSeparatorTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght(":");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutSeparatorButNotBlankTest() throws ImdbApiMovieException {
		InputDataValidation.verifyLenght("teste");
	}
}
