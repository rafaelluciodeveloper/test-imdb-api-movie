package br.com.rafaellucio.imdb.api.movie.tools;

public class Configs {
	 	
		private static final int PORT_NUMBER = 37000;
	    private static final char QUERY_SEPARATOR = ':';
	    private static final String TITLE_SEPARATOR = "\\n";
	    
	    public Configs() {
	    	
	    }
	    
		public static int getPortNumber() {
			return PORT_NUMBER;
		}
		public static char getQuerySeparator() {
			return QUERY_SEPARATOR;
		}
		public static String getTitleSeparator() {
			return TITLE_SEPARATOR;
		}
	    
	    
}
