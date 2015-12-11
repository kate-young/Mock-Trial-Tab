package tab;

import java.util.ArrayList;

/**
 * Teams attending a tournament. Tracks the number of wins, losses, and other teams hit
 * at a tournament.
 *
 */
public class Team {
	private final School school;
	private static int count = 0;
	private final int id;
	private double wins = 0;
	private double losses = 0;
	private ArrayList<Team> teamsHit;
	
	/**
	 * @param id
	 * @param school
	 */
	public Team(int id, School school) {
		if(school == null) throw new IllegalArgumentException("school cannot be null");
		this.id = id;
		this.school = school;
		this.teamsHit = new ArrayList<Team>();
		count++;
	}
	/**
	 * @param team
	 * @throws ConflictException 
	 */
	public void addToTeamsHit(Team team) throws ConflictException {
		if(team == null) throw new IllegalArgumentException("team cannot be null");
		if(team == this) throw new ConflictException("team cannot hit itself", team, team);
		teamsHit.add(team);
	}
	/**
	 * @param other - Team to check conflicts for
	 * @return true if both teams are from the same school or if they have already hit
	 */
	public boolean hasConflict(Team other) {
		return other.equals(this)
				|| other.equals(this.getSchool()) 
				|| other.getTeamsHit().contains(this) 
				|| teamsHit.contains(other);
	}
	/**
	 * @return list of teams that this team has already been in trial with this tournament
	 */
	public ArrayList<Team> getTeamsHit() {
		return teamsHit;
	}
	/**
	 * @return sum of the number of wins for all other teams that this team has hit. This will
	 * be used for determining rankings at the end of the tournament.
	 */
	public double getCombinedStrength() {
		double sum = 0;
		for(Team team: teamsHit) {
			sum += team.getWins();
		}
		return sum;
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
