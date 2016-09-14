import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	@Test
	public void createMovie() {
		Movie upmovie = new Movie("up", "regular");
		assertEquals(upmovie.getName(), "up");
	}

	@Test
	public void getMoviePrice() throws Exception {
		Movie upmovie = new Movie("up", "regular");
		assertEquals( 6, 0, upmovie.getPrice(5));
		assertEquals( 12, 0, upmovie.getPrice(6));
	}

	@Test
	public void getChildrensMoviePrice() throws Exception {
		Movie upmovie = new Movie("up", "childrens");
		assertEquals(5, 0, upmovie.getPrice(3));
	}

	
}
