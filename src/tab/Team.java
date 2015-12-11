package tab;

public class Team {
	private final School school;
	private static int count = 0;
	private final int id;
	private double wins = 0;
	private double losses = 0;
	
	public Team(int id, School school) {
		if(school == null) {
			throw new IllegalArgumentException("school cannot be null");
		}
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
	public double getWins() {
		return wins;
	}
	public double getLosses() {
		return losses;
	}
	public void win() {
		wins += 1;
	}
	public void lose() {
		losses += 1;
	}
	public void tie() {
		wins += 0.5;
		losses += 0.5;
	}
}
