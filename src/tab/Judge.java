package tab;

import java.util.ArrayList;

public class Judge {
	private final String firstName;
	private final String lastName;
	private ArrayList<Team> conflicts;
	
	public Judge(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.conflicts = new ArrayList<Team>();
	}
	
	public Judge(String firstName, String lastName, ArrayList<Team> conflicts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.conflicts = conflicts;
	}
	public void addConflict(Team conflict) {
		this.conflicts.add(conflict);
	}
	
	public ArrayList<Team> getConflicts() {
		return conflicts;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return lastName + ", " + firstName;
	}
}
