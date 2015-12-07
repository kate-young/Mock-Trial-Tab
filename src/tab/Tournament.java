package tab;

import java.util.ArrayList;

public class Tournament {
	private ArrayList<School> schools;
	private ArrayList<Team> teams;
	private ArrayList<Judge> judges;
	
	public Tournament() {}
	
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
	public void addJudge(Judge judge) {
		judges.add(judge);
	}
	public ArrayList<Judge> getJudges() {
		return judges;
	}
}
