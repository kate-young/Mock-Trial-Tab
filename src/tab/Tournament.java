package tab;

import java.util.ArrayList;

public class Tournament {
	private ArrayList<School> schools;
	private ArrayList<Team> teams;
	
	public Tournament() {}
	
	public void addSchool(School school) {
		schools.add(school);
	}
	public void addTeam(Team team) {
		teams.add(team);
	} 
}
