import java.util.Comparator;

public class Player {
	
	private String surname;
	private String gender;
	private int highScore;
	
	public Player () {}
	
	public Player (String s, String g, String hs) {
		this.surname = s;
		this.gender = g;
		this.highScore = Integer.parseInt(hs);
	}
	
	public String getSurname() {return surname;}
	public void setSurname(String surname) {this.surname = surname;}
	
	public String isGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	public int getHighScore() {return highScore;}
	public void setHighScore(int hs) {this.highScore = hs;}
	
	@ Override
	public String toString () {
//		String mf = "";
//		if (gender) {
//			mf = "(M)";
//			} else {
//				mf = "(F)";
//			}
		String s = surname+" "+gender+" "+highScore;
		return s;
	}

	public static Comparator<Player> highScoreComparator = new Comparator<Player>() {
	
	public int compare(Player p1, Player p2) { 
		int hs1 = p1.getHighScore();
		int hs2 = p2.getHighScore();
	
		return hs2-hs1;
	}
	};
	
	public static Comparator<Player> surnameComparator = new Comparator<Player>() {
		
	public int compare(Player p1, Player p2) { 
		String s1 = p1.getSurname().toUpperCase();
		String s2 = p2.getSurname().toUpperCase();
	
		return s1.compareTo(s2);
	}
	};
}
