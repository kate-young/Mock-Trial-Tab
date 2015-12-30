package tab;

public class School {
	private static int count = 0;
	private String name;
	private String mascot;
	private final int id;

	public School() {
		this.id = ++count;
	}

	public School(String name, String mascot) {
		this.id = ++count;
		this.name = name;
		this.mascot = mascot;
	}

	public String getName() {
		return name;
	}

	public String getMascot() {
		return mascot;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		School otherSchool = (School) obj;

		return this.name == otherSchool.getName();
	}
}
