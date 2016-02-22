import java.io.IOException;

public class OrganisePlayers {
	
	public static void main (String[] arg) throws IOException{
		
		// constructor automatically reads the input file
		Players p = new Players();
		
		p.addPlayer("Melville", "(M)", 50);
		p.removePlayer("Croal");
		p.listPlayers();
		
		p.getHighScore();
		
		p.changeScore("Pelletier", 99);
		
		p.sortHighScores();
		p.sortSurnames();
		
		
	}
}
