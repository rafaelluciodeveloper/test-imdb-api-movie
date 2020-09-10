package br.com.rafaellucio.imdb.api.movie.handler.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.handler.ClientHandler;
import br.com.rafaellucio.imdb.api.movie.imdb.connection.ImdbConnection;
import br.com.rafaellucio.imdb.api.movie.model.ImdbResponse;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieRequestDTO;
import br.com.rafaellucio.imdb.api.movie.model.dto.MovieResponseDTO;
import br.com.rafaellucio.imdb.api.movie.parser.ClientParser;
import br.com.rafaellucio.imdb.api.movie.tools.Configs;
import br.com.rafaellucio.imdb.api.movie.validation.InputDataValidation;
import br.com.rafaellucio.imdb.api.movie.validation.OutputDataValidation;

public class ClientHandlerImpl implements ClientHandler {

    private final ClientParser clientParser;
    private final ImdbConnection imdbConnection;

    public ClientHandlerImpl(ClientParser clientParser,ImdbConnection imdbConnection) {
        this.clientParser = clientParser;
        this.imdbConnection = imdbConnection;
    }

    public void processAndGiveBack(Socket connection, BufferedReader input,
                                 BufferedOutputStream output) throws IOException {
        String data = "";
        while ((data = input.readLine()) != null) {
            try {
                try {
                	//validatin input data
                    InputDataValidation.verify(data);
                    // identify query 
                    Optional<MovieRequestDTO> optionalRequest = this.verifyRequest(data);
                    // connect to imdb
                    Optional<ImdbResponse> optionalResponse = this.requestImdb(optionalRequest);
                    // convert response to string
                    data = this.parseImdbResponse(optionalResponse);
                    // validating  output data
                    OutputDataValidation.verify(data);
                } catch ( ImdbApiMovieException e) {
                	data = e.getMessage().length() + String.valueOf(Configs.getQuerySeparator()) + e.getMessage();
                }
            } catch (Exception ex) {
            	System.out.println(ex.getMessage());
            }
            output.write((data + (char) 13 + (char) 10).getBytes());
            output.flush();
        }
    }

    
    private Optional<MovieRequestDTO> verifyRequest(String content) throws ImdbApiMovieException {
        Optional<MovieRequestDTO> optionalRequest = clientParser.createRequest(Optional.ofNullable(content));
        if(!optionalRequest.isPresent()){
            throw new ImdbApiMovieException("Error creating request.");
        }
        return optionalRequest;
    }

   
    private Optional<ImdbResponse> requestImdb(Optional<MovieRequestDTO> optRequest) throws ImdbApiMovieException {
        Optional<ImdbResponse> optionalResponse = imdbConnection.searchByMovieTitle(optRequest.get().getContent());
        if(!optionalResponse.isPresent()){
            throw new ImdbApiMovieException("Movie not found.");
        }
        return optionalResponse;
    }

    
    private String parseImdbResponse(Optional<ImdbResponse> optionalResponse) throws ImdbApiMovieException {
        Optional<MovieResponseDTO> optApiMoviesResponse = clientParser.createResponse(optionalResponse);
        if(!optApiMoviesResponse.isPresent()){
            throw new ImdbApiMovieException("Error parsing response.");
        }
        return optApiMoviesResponse.get().getLength()
                + String.valueOf(Configs.getQuerySeparator())
                + optApiMoviesResponse.get().getContent();
    }

}
