package tab;

import java.util.ArrayList;

public class Tournament {
	private ArrayList<School> schools;
	private ArrayList<Team> teams;
	private Round[] rounds;
	
	public Tournament() {
		this.rounds = new Round[4];
		for(int i = 0; i < 4; i++) {
			rounds[i] = new Round();
		}
	}
	
	public void addSchool(School school) {
		schools.add(school);
	}
	public ArrayList<School> getSchools() {
		return schools;
	}
	public void addTeam(Team team) {
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
