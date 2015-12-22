package tab;

import java.util.List;

public class JudgeTournamentInstance {
    private Judge judge;
	private List<Team> conflicts;

    public JudgeTournamentInstance(Judge judge) {
        this.judge = judge;
    }

    public void addConflict(Team conflict) {
		if(conflict == null)  throw new IllegalArgumentException("Team cannot be null");
		this.conflicts.add(conflict);
	}

    public List<Team> getConflicts() {
		return conflicts;
	}
}
