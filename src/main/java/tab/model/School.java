package tab.model;

public class School {

	private String name;
	private String mascot;

	public School() { }

	public School(String name, String mascot) {
		this.name = name;
		this.mascot = mascot;
	}

	public String getName() {
		return name;
	}

	public String getMascot() {
		return mascot;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	@Override
	public boolean equals(Object obj) {
		School otherSchool = (School) obj;
		return this.name == otherSchool.getName();
	}
}
