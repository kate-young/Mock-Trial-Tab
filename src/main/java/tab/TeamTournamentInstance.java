package tab;

import java.util.ArrayList;
import java.util.List;

public class TeamTournamentInstance implements Comparable  {
    private Team team;
    private double wins = 0;
	private double losses = 0;
	private List<TeamTournamentInstance> teamsHit;

    public TeamTournamentInstance(Team team) {
        this.team = team;
        teamsHit = new ArrayList<>();
    }
    @Override
	public int compareTo(Object obj) {
		TeamTournamentInstance other = (TeamTournamentInstance) obj;
		if(wins > other.getWins() || (wins == other.getWins() && getCombinedStrength() > other.getCombinedStrength())) {
			return 1;
		}
		if (wins < other.getWins() || (wins == other.getWins() && getCombinedStrength() < other.getCombinedStrength())){
			return -1;
		}
		return 0;
	}

	public Team getTeam() {
		return team;
	}

	protected void addToTeamsHit(TeamTournamentInstance otherTeam) throws ConflictException {
		if(otherTeam == null)  {
			throw new IllegalArgumentException("Team cannot be null");
		}
		if(this.team == otherTeam.getTeam()) {
			throw new ConflictException("Team cannot hit itself");
		}
		if(this.team.getSchool() == otherTeam.getTeam().getSchool()) {
			throw new ConflictException("Team cannot hit team from its own school");
		}
		if(teamsHit.contains(otherTeam)) {
			throw new ConflictException("Team has already hit this team");
		}
		teamsHit.add(otherTeam);
	}

	protected List<TeamTournamentInstance> getTeamsHit() {
		return teamsHit;
	}

	public double getCombinedStrength() {
		double sum = 0;
		for(TeamTournamentInstance team: teamsHit) {
			sum += team.getWins();
		}
		return sum;
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
