package tab;

import java.util.ArrayList;
import java.util.List;

public class Judge {
	private final String firstName;
	private final String lastName;
	private List<Team> conflicts;
	
	public Judge(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.conflicts = new ArrayList<>();
	}
	
	public Judge(String firstName, String lastName, ArrayList<Team> conflicts) {
		if(conflicts == null) throw new IllegalArgumentException("conflict list cannot be null");
		this.firstName = firstName;
		this.lastName = lastName;
		this.conflicts = conflicts;
	}
	public void addConflict(Team conflict) {
		if(conflict == null)  throw new IllegalArgumentException("Team cannot be null");
		this.conflicts.add(conflict);
	}
	
	public List<Team> getConflicts() {
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
