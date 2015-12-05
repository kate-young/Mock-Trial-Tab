package tab;

public class Team {
	private final School school;
	private static int count = 0;
	private final int id;
	
	public Team(int id, School school) {
		this.id = id;
		this.school = school;
		count++;
	}
	public int getId() {
		return id;
	}
	public static int getCount() {
		return count;
	}
	public School getSchool() {
		return school;
	}
}
