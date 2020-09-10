package br.com.rafaellucio.imdb.api.movie.server.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.rafaellucio.imdb.api.movie.exception.ImdbApiMovieException;
import br.com.rafaellucio.imdb.api.movie.handler.ClientHandler;
import br.com.rafaellucio.imdb.api.movie.handler.impl.ClientHandlerImpl;
import br.com.rafaellucio.imdb.api.movie.imdb.connection.impl.ImdbConnectionImpl;
import br.com.rafaellucio.imdb.api.movie.parser.impl.ClientParserImpl;
import br.com.rafaellucio.imdb.api.movie.parser.impl.ImdbParserImpl;
import br.com.rafaellucio.imdb.api.movie.server.Server;
import br.com.rafaellucio.imdb.api.movie.tools.Configs;

public class ServerImpl implements Server {

	private Socket connection;
	
	
	public ServerImpl() {
		
	}

	public ServerImpl(Socket connection) {
		this.connection =  connection;
	}

    @Override
    public void execute() throws ImdbApiMovieException {
        try {
            ServerSocket serverSocket = this.getServer();
            System.out.println("Server Started.");
            while (true) {
                Socket connection = serverSocket.accept();
                System.out.println("Client : " + connection.getInetAddress().getHostAddress() +  " connected.");
                Runnable runnable = new ServerImpl(connection);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        } catch (Exception ex) {
            throw new ImdbApiMovieException("Error creating server.");
        }
    }

    @Override
    public void run() {
        BufferedReader input = null;
        BufferedOutputStream output = null;
        try {
            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            output = new BufferedOutputStream(connection.getOutputStream());
            ClientHandler handler = new ClientHandlerImpl(
                    new ClientParserImpl(),
                    new ImdbConnectionImpl(new ImdbParserImpl())
                    );                                           
            handler.processAndGiveBack(connection, input, output);
        } catch (IOException e) {
        	System.out.println("Error : " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
            	System.out.println("Error Connection Close : " + e.getMessage());
            }
        }
    }

   
    private ServerSocket getServer() throws ImdbApiMovieException {
        try {
            ServerSocket serverSocket = new ServerSocket(Configs.getPortNumber());
            serverSocket.setReuseAddress(true);
            return serverSocket;
        } catch (Exception e) {
            throw new ImdbApiMovieException("Error retrieving server.");
        }
    }

}
