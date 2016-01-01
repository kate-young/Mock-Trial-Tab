package tab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class School {
	@Id
	@GeneratedValue
	private Integer id;
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

	public void save() {
	}

	@Override
	public boolean equals(Object obj) {
		School otherSchool = (School) obj;

		return this.name == otherSchool.getName();
	}
}
