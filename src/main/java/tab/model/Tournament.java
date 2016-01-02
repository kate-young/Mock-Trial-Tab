package tab.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tournament implements Serializable {

	private final String name;
	private List<School> schools;
	private List<Team> teams;
	private Round[] rounds;
	private int year;
	
	public Tournament(final String name, final int year) {
		this.name = name;
		this.year = year;
		this.rounds = new Round[4];
		this.schools = new ArrayList<>();
		this.teams = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			rounds[i] = new Round();
		}
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public void addSchool(School school) {
		if(school == null) throw new IllegalArgumentException("School cannot be null");
		schools.add(school);
	}
	public List<School> getSchools() {
		return schools;
	}
	public void addTeam(Team team) {
		if(team == null) throw new IllegalArgumentException("Team cannot be null");
		teams.add(team);
	} 
	public List<Team> getTeams() {
		return teams;
	}
	public Round[] getRounds() {
		return rounds;
	}
	public Round getRound(int index) {
		return rounds[index];
	}

	public boolean equals(Object obj) {
		Tournament other = (Tournament) obj;

		return other.getName() == name && other.getYear() == year;
	}
}
