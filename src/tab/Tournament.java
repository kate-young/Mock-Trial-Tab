package tab;

import java.util.ArrayList;

public class Tournament {
	private final String name;
	private ArrayList<School> schools;
	private ArrayList<Team> teams;
	private Round[] rounds;
	
	public Tournament(final String name) {
		this.name = name;
		this.rounds = new Round[4];
		for(int i = 0; i < 4; i++) {
			rounds[i] = new Round();
		}
	}

	public String getName() {
		return name;
	}
	
	public void addSchool(School school) {
		if(school == null) throw new IllegalArgumentException("school cannot be null");
		schools.add(school);
	}
	public ArrayList<School> getSchools() {
		return schools;
	}
	public void addTeam(Team team) {
		if(team == null) throw new IllegalArgumentException("team cannot be null");
		teams.add(team);
	} 
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public Round[] getRounds() {
		return rounds;
	}
	public Round getRound(int index) {
		return rounds[index];
	}
}
