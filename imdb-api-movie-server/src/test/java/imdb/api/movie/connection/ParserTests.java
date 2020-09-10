package imdb.api.movie.connection;

import org.junit.Assert;
import org.junit.Test;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.model.ImdbMovie;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieResponseDTO;
import br.com.rafaellucio.imdb.api.movie.parser.ClientParser;
import br.com.rafaellucio.imdb.api.movie.parser.impl.ClientParserImpl;
import br.com.rafaellucio.imdb.api.movie.tools.Configs;
import imdb.api.movie.seeds.SeedMovie;

import java.util.Optional;

public class ParserTests {

	private ClientParser clientParser = new ClientParserImpl();

	@Test
	public void successCreateRequestTest() throws ImdbApiMovieException {
		Assert.assertEquals("12",
				String.valueOf(clientParser.createRequest(Optional.ofNullable("12:THE AVANGERS")).get().getLength()));
	}

	@Test(expected = ImdbApiMovieException.class)
	public void createRequestExceptionEmptyTest() throws ImdbApiMovieException {
		clientParser.createRequest(Optional.empty());
	}

	@Test(expected = ImdbApiMovieException.class)
	public void createRequestExceptionWithoutLengthTest() throws ImdbApiMovieException {
		clientParser.createRequest(Optional.ofNullable(":AVANGERS"));
	}

	@Test(expected = ImdbApiMovieException.class)
	public void createRequestExceptionWithoutLengthAlsoTest() throws ImdbApiMovieException {
		clientParser.createRequest(Optional.ofNullable("AVANGERS"));
	}

	@Test(expected = ImdbApiMovieException.class)
	public void createRequestExceptionWithoutContentTest() throws ImdbApiMovieException {
		clientParser.createRequest(Optional.ofNullable("14:"));
	}

	@Test
	public void successCreateResponseTest() throws ImdbApiMovieException {
		ImdbResponse imdbResponse = SeedMovie.createFakerImdbResponse();
		Optional<ImdbResponse> optImdbResponse = Optional.ofNullable(imdbResponse);
		Optional<MovieResponseDTO> opt = clientParser.createResponse(optImdbResponse);
		String expected = "";
		for (ImdbMovie imdbMovie : imdbResponse.getMovies()) {
			expected = expected + imdbMovie.getTitle() + Configs.getTitleSeparator();
		}
		Assert.assertEquals(String.valueOf(expected.length()), opt.get().getLength().toString());
		Assert.assertEquals(expected, opt.get().getContent());
	}

	@Test
	public void successCreateOtherResponseTest() throws ImdbApiMovieException {
		ImdbResponse imdbResponse = SeedMovie.createFakerImdbResponse();
		Optional<ImdbResponse> optImdbResponse = Optional.ofNullable(imdbResponse);
		Optional<MovieResponseDTO> opt = clientParser.createResponse(optImdbResponse);
		Assert.assertNotEquals("CARROS\nCARROS 3\n".length(), opt.get().getLength().toString());
		Assert.assertNotEquals("CARROS\nCARROS 3\n", opt.get().getContent());
	}

	@Test(expected = ImdbApiMovieException.class)
	public void createResponseExceptionEmptyTest() throws ImdbApiMovieException {
		Optional<MovieResponseDTO> optionalMoveResponseDTO = clientParser.createResponse(Optional.empty());
	}

}
