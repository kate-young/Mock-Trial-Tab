package tab.model;

import java.util.ArrayList;

/**
 * Judges that are scoring a round. Only two scoring judges are allowed for each round.
 *
 */
public class ScoringJudge extends Judge {

	public ScoringJudge(String firstName, String lastName) {
		super(firstName, lastName);
	}
	public ScoringJudge(String firstName, String lastName, ArrayList<Team> conflicts) {
		super(firstName, lastName, conflicts);
	}
}
