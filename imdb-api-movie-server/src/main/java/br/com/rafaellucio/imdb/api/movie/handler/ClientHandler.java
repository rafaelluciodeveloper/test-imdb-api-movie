package br.com.rafaellucio.imdb.api.movie.handler;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public interface ClientHandler {
    void processAndGiveBack(Socket connection, BufferedReader input, BufferedOutputStream output) throws IOException;
}
