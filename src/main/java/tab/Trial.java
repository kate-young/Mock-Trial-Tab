package tab;

import java.util.ArrayList;
import java.util.List;

public class Trial {
	private final TeamTournamentInstance prosecutionTeam;
	private final TeamTournamentInstance defenseTeam;
	private final List<JudgeTournamentInstance> judges;
	private boolean complete = false;
	
	public Trial(TeamTournamentInstance prosecutionTeam, TeamTournamentInstance defenseTeam) throws ConflictException {
		this.prosecutionTeam = prosecutionTeam;
		this.defenseTeam = defenseTeam;
		this.judges = new ArrayList<>();
	}

	public TeamTournamentInstance getProsecutionTeam() {
		return prosecutionTeam;
	}

	public TeamTournamentInstance getDefenseTeam() {
		return defenseTeam;
	}
	
	public void assignJudge(JudgeTournamentInstance judge) throws IllegalArgumentException, ConflictException {
		if(judge == null) {
			throw new IllegalArgumentException("Judge cannot be null");
		}
		if(judge.getConflicts().contains(defenseTeam.getTeam())) {
			throw new ConflictException("Judge has conflict with defense team");
		} 
		if (judge.getConflicts().contains(prosecutionTeam.getTeam())) {
			throw new ConflictException("Judge has conflict with prosecution team");
		}
		judges.add(judge);
	}
	
	public List<JudgeTournamentInstance> getJudges() {
		return judges;
	}
	
	public void end() throws ConflictException {
		prosecutionTeam.addToTeamsHit(defenseTeam);
        defenseTeam.addToTeamsHit(prosecutionTeam);
		for(JudgeTournamentInstance judge : judges) {
			judge.addConflict(prosecutionTeam.getTeam());
			judge.addConflict(defenseTeam.getTeam());
		}
		complete = true;
	}
	
	public boolean isComplete() {
		return complete;
	}
}
