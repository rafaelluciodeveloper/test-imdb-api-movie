package br.com.rafaellucio.imdb.api.movie.parser;

import java.util.Optional;
import org.jsoup.nodes.Document;

import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;

public interface ImdbParser {
    Optional<ImdbResponse> parserImdbResponse(Document document);
}
