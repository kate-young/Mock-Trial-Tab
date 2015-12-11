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
		if(conflicts == null) {
			throw new IllegalArgumentException("conflict list cannot be null");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.conflicts = conflicts;
	}
	public void addConflict(Team conflict) {
		if(conflict == null) {
			throw new IllegalArgumentException("conflict cannot be null");
		}
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
