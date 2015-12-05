package tab;

public class School {
	private static int count = 0;
	private String name;
	private final int id;
	public School() {
		this.id = ++count;
	}
	public School(String name) {
		this.id = ++count;
		this.setName(name);
	}
	public School(School other) {
		this.id = other.id;
		this.setName(other.name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
}
