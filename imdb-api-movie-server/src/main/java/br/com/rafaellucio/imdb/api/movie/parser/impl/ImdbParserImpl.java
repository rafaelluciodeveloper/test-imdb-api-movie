package br.com.rafaellucio.imdb.api.movie.parser.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import br.com.rafaellucio.imdb.api.movie.model.ImdbMovie;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;
import br.com.rafaellucio.imdb.api.movie.parser.ImdbParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImdbParserImpl implements ImdbParser {
	
	public ImdbParserImpl() {
		
	}

    public Optional<ImdbResponse> parserImdbResponse(Document document) {
        Elements resultText = document.select("td.result_text");
        if(!resultText.isEmpty()){
            List<ImdbMovie> list = new ArrayList<>();
            resultText.forEach(elem -> {
                Elements linkElement = elem.select("a");
                String movieLink = linkElement.attr("href");
                String movieCode = movieLink.replace("/title/", "").trim();
                int length = movieCode.indexOf("/?");
                movieCode = movieCode.substring(0, length);
                String movieTitle = linkElement.select("[href]").text();
                ImdbMovie movie = new ImdbMovie(movieCode,movieTitle);
                if(!list.contains(movie)){
                    list.add(movie);
                }
            });
            return Optional.ofNullable(new ImdbResponse(list));
        }
        return Optional.empty();
    }

}
