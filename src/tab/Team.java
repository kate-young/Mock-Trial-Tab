package tab;

public class Team {
	private final School school;
	private static int count = 0;
	private final int id;
	private int wins = 0;
	private int losses = 0;
	
	public Team(int id, School school) {
		this.id = id;
		this.school = school;
		count++;
	}
	public int getId() {
		return id;
	}
	public static int getCount() {
		return count;
	}
	public School getSchool() {
		return school;
	}
	public int getWins() {
		return wins;
	}
	public int getLoses() {
		return losses;
	}
	public void win() {
		this.wins++;
	}
	public void lose() {
		this.losses++;
	}
}
