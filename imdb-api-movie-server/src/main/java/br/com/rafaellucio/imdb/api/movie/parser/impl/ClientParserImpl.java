package br.com.rafaellucio.imdb.api.movie.parser.impl;

import java.util.Optional;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.model.ImdbMovie;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieRequestDTO;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieResponseDTO;
import br.com.rafaellucio.imdb.api.movie.parser.ClientParser;
import br.com.rafaellucio.imdb.api.movie.tools.Configs;
import br.com.rafaellucio.imdb.api.movie.tools.Utilities;

public class ClientParserImpl implements ClientParser {

    @Override
    public Optional<MovieRequestDTO> createRequest(Optional<String> optionalRequestContent) throws ImdbApiMovieException {
        try {
            int position = Utilities.checkQuerySeparator(optionalRequestContent.get());
            Integer length = Integer.parseInt(optionalRequestContent.get().substring(0, position));
            String content = optionalRequestContent.get().substring(position+1, (length + position + 1));
            return Optional.ofNullable(new MovieRequestDTO(length, content.toLowerCase()));
        } catch (Exception e){
            throw new ImdbApiMovieException("Error creating request client.");
        }
    }

    @Override
    public Optional<MovieResponseDTO> createResponse(Optional<ImdbResponse> optionalImdbResponse) throws ImdbApiMovieException {
        if(optionalImdbResponse.isPresent()) {
            String content = "";
            for(ImdbMovie movie : optionalImdbResponse.get().getMovies()){
            	content = content.concat(
                        movie.getTitle().concat(String.valueOf(Configs.getTitleSeparator())));
            }
            return Optional.ofNullable(new MovieResponseDTO(content.length(), content));
        } else {
            throw new ImdbApiMovieException("Error creating response client.");
        }
    }

}
