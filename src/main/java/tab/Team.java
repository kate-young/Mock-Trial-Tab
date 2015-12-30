package tab;

public class Team {
	private final School school;
	private final int id;

	public Team(int id, School school) {
		if(school == null) throw new IllegalArgumentException("school cannot be null");
		this.id = id;
		this.school = school;
	}
	public int getId() {
		return id;
	}
	public School getSchool() {
		return school;
	}
	public boolean equals(Object obj) {
		Team other = (Team) obj;
		return this.id == other.getId();
	}
}
