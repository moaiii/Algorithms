import java.io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
	
	private final String inputFile = "players.txt";
	private String read;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	// Constructor reads in the text file
	public Players () {
		// reads text file and creates objects array
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
		    while ((read = br.readLine()) != null) {
		    	// read full line then split into array elements at [SPACE] delim.
		    	String [] holder = read.split(" ");
		    	playerList.add(new Player (holder[0],holder[1],holder[2]));
		    }
		}
		catch (IOException e) {
			System.err.println("Input file not found");
		}
	}

	public void changeScore (String surname, int score) {
		
		for (int i=0; i<playerList.size(); i++) {
			
			String lookFor = playerList.get(i).getSurname();
			
			if(lookFor.equals(surname)) { 
				playerList.get(i).setHighScore(score);
			}
		}
		
	}
	
	public void addPlayer(String surname, String gender, int highScore) {
		
		String hs = "";
		
		// parse the integer to a String 
		if(highScore>100) { 
			hs = "100";
		}
		else {
			hs = Integer.toString(highScore);
		}
	
		// add player
		playerList.add(new Player (surname, gender, hs));
	}
	
	public void removePlayer (String surname) {
		
		for (int i=0; i<playerList.size(); i++) {
			
			String lookFor = playerList.get(i).getSurname();
			
			if(lookFor.equals(surname)) { 
				playerList.remove(i);
			}
		}
	}
	
	public void listPlayers () throws IOException {
		String title = "\nThe list of players is: ";
		
		System.out.println(title);
		print(title);
		
		for (Player p: playerList) {
			System.out.println(p);
			print(p.toString());
		}
	}
	
	public void getHighScore () throws IOException {
		String title = "\nThe high score is: ";
		
		Collections.sort(playerList, Player.highScoreComparator);
		
		System.out.println(title+playerList.get(0).getHighScore());
		 
		String highScore = Integer.toString(playerList.get(0).getHighScore());
		
		print(title+highScore);
	}
	
	public void sortHighScores () throws IOException {
		String title = "\nThe (high-score)-sorted list is: ";
		
		Collections.sort(playerList, Player.highScoreComparator);
		
		System.out.println(title);
		print(title);
		
		for (Player p: playerList) {
			System.out.println(p);
			print(p.toString());
		}
	}
	
	public void sortSurnames () throws IOException {
		String title = "\nThe (name)-sorted list is:";
		
		Collections.sort(playerList, Player.surnameComparator);
		
		System.out.println(title);
		print(title);
		
		for (Player p: playerList) {
			System.out.println(p.toString());
			print(p.toString());
		}
	}
	
	public void print (String s) throws IOException {
		
		String fileName = "output.txt";
		
		FileWriter write = new FileWriter(fileName, true);
		PrintWriter print = new PrintWriter(write);
		print.println(s);
		
		print.close();
	}
}
