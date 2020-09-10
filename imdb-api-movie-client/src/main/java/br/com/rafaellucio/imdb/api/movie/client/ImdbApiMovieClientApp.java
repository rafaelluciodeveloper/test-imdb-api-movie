package br.com.rafaellucio.imdb.api.movie.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ImdbApiMovieClientApp {
	public static void main(String[] args) {
		 
	        try (Socket socket = new Socket("127.0.0.1", 37000)) {
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            Scanner scanner = new Scanner(System.in);
	            String query = null;
	            while (!"quit".equalsIgnoreCase(query)) {
	                System.out.println("\nInput the title movie to query -> ");
	                query = scanner.nextLine();
	                out.println(query);
	                out.flush();
	                System.out.println("Response server -> " + in.readLine());
	            }
	            scanner.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
