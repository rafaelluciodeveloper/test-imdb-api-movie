package imdb.api.movie.tools;

import org.junit.Assert;
import org.junit.Test;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.tools.Utilities;

public class UtilitesTest  {

   
    @Test(expected = ImdbApiMovieException.class)
    public void checkSeparatorAtFirstTest() throws ImdbApiMovieException {
    	Utilities.checkQuerySeparator(":1407119");
    }

    @Test(expected = ImdbApiMovieException.class)
    public void checkSeparatorAtLastPositionTest() throws ImdbApiMovieException {
    	Utilities.checkQuerySeparator("1407119:");
    }

    @Test
    public void checkSeparatoTest() throws ImdbApiMovieException {
        Assert.assertEquals(1, Utilities.checkQuerySeparator("1:140790"));
        Assert.assertEquals(3, Utilities.checkQuerySeparator("111:1407"));
        Assert.assertEquals(4, Utilities.checkQuerySeparator("1101:147"));
        Assert.assertEquals(6, Utilities.checkQuerySeparator("110191:1"));
    }

}
