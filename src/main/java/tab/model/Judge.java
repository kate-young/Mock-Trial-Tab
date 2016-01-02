package tab.model;

import java.util.ArrayList;

public class Judge {
	private String firstName;
	private String lastName;

	public Judge(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Judge(String firstName, String lastName, ArrayList<Team> conflicts) {
		if(conflicts == null) throw new IllegalArgumentException("conflict list cannot be null");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}

	@Override
	public boolean equals(Object obj) {
		Judge other = (Judge) obj;

		return other.getFirstName() == this.firstName && this.lastName == other.getLastName();
	}
}
