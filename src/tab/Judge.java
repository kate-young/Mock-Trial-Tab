package tab;

import java.util.ArrayList;

public class Judge {
	private final String firstName;
	private final String lastName;
	private ArrayList<School> conflicts;
	
	public Judge(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Judge(String firstName, String lastName, ArrayList<School> conflicts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.conflicts = conflicts;
	}
	public void addConflict(School conflict) {
		this.conflicts.add(conflict);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
