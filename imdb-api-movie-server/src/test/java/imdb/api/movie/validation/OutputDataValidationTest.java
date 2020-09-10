package imdb.api.movie.validation;

import org.junit.Test;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.validation.OutputDataValidation;

public class OutputDataValidationTest {
	@Test
	public void separatorTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("12:The Avangers");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void blankSeparatorTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void lengthZeroTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("0:The Avangers");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void higherLengthTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("399:The Avangers");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void nullContentTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("null");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void newLineTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("\\n");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutIntegerLengthTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("rrr:aaa");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutLengthWithContentTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght(":aaa");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutContentWithLengthTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("1:");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void justSeparatorTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght(":");
	}

	@Test(expected = ImdbApiMovieException.class)
	public void withoutSeparatorButNotBlankTest() throws ImdbApiMovieException {
		OutputDataValidation.verifyLenght("teste");
	}
}
