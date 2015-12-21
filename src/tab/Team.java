package tab;

import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Teams attending a tournament. Tracks the number of wins, losses, and other teams hit
 * at a tournament.
 *
 */
public class Team implements Comparable {
	private final School school;
	private static int count = 0;
	private final int id;
	private double wins = 0;
	private double losses = 0;
	private List<Team> teamsHit;
	
	public Team(int id, School school) {
		if(school == null) throw new IllegalArgumentException("school cannot be null");
		this.id = id;
		this.school = school;
		this.teamsHit = new ArrayList<>();
		count++;
	}

	@Override
	public int compareTo(Object obj) {
		Team other = (Team) obj;
		if(wins > other.getWins() || (wins == other.getWins() && getCombinedStrength() > other.getCombinedStrength())) {
			return 1;
		}
		if (wins < ((Team) obj).getWins() || (wins == other.getWins() && getCombinedStrength() < other.getCombinedStrength())){
			return -1;
		}
		return 0;
	}

	protected void addToTeamsHit(Team team) throws ConflictException {
		if(team == null)  {
			throw new IllegalArgumentException("Team cannot be null");
		}
		if(this == team) {
			throw new ConflictException("Team cannot hit itself");
		}
		if(this.school == team.getSchool()) {
			throw new ConflictException("Team cannot hit team from its own school");
		}
		if(teamsHit.contains(team)) {
			throw new ConflictException("Team has already hit this team");
		}
		teamsHit.add(team);
	}

	protected List<Team> getTeamsHit() {
		return teamsHit;
	}

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
	protected void win() {
		wins += 1;
	}
	protected void lose() {
		losses += 1;
	}
	protected void tie() {
		wins += 0.5;
		losses += 0.5;
	}
}
