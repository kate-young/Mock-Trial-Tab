package tab;

import java.util.ArrayList;

public class ScoringJudge extends Judge {

	public ScoringJudge(String firstName, String lastName) {
		super(firstName, lastName);
	}
	public ScoringJudge(String firstName, String lastName, ArrayList<Team> conflicts) {
		super(firstName, lastName, conflicts);
	}
}
