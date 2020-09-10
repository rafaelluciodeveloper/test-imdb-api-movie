package imdb.api.movie.seeds;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaellucio.imdb.api.movie.model.ImdbMovie;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;

public class SeedMovie {

    public static ImdbResponse createFakerImdbResponse(){
        ImdbResponse imdbResponse = new ImdbResponse();
        imdbResponse.setMovies(createListImdbMovie());
        return imdbResponse;
    }

    public static List<ImdbMovie> createListImdbMovie(){
        List<ImdbMovie> listMovies = new ArrayList<>();
        listMovies.add(new ImdbMovie("tt0848228","The Avengers"));
        listMovies.add(new ImdbMovie("tt0371746","Iron Man"));
        listMovies.add(new ImdbMovie("tt0800080","The Incredible Hulk"));
        return listMovies;
    }
    
    public static void main(String[] args) {
    	System.out.println(createFakerImdbResponse());
    }

}
