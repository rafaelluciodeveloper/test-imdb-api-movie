package imdb.api.movie.tools;

import org.junit.Assert;
import org.junit.Test;

import br.com.rafaellucio.imdb.api.movie.tools.Configs;

public class ConfigsTest {

	@Test
	public void portTest() {
		Assert.assertEquals(37000, Configs.getPortNumber());
	}

	@Test
	public void portNullTest() {
		Assert.assertNotEquals(null, Configs.getPortNumber());
	}

	@Test
	public void querySeparatorTest() {
		Assert.assertEquals(":", String.valueOf(Configs.getQuerySeparator()));
	}

	@Test
	public void querySeparatorNullTest() {
		Assert.assertNotEquals(null, String.valueOf(Configs.getQuerySeparator()));
	}

	@Test
	public void titleSeparatorTest() {
		Assert.assertEquals("\\n", Configs.getTitleSeparator());
	}

	@Test
	public void titleSeparatorNullTest() {
		Assert.assertNotEquals(null, Configs.getTitleSeparator());
	}

}
