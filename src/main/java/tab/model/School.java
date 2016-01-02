package tab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schools")
public class School {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String mascot;

	public School() { }

	public School(String name, String mascot) {
		this.name = name;
		this.mascot = mascot;
	}

	public int getId() {
		return id;
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
