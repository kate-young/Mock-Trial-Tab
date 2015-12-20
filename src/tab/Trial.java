package tab;

import java.util.ArrayList;
import java.util.List;

public class Trial {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	private final List<Judge> judges;
	private boolean complete = false;
	
	public Trial(Team prosecutionTeam, Team defenseTeam) throws ConflictException {
		this.prosecutionTeam = prosecutionTeam;
		this.defenseTeam = defenseTeam;
		this.judges = new ArrayList<>();
	}

	public Team getProsecutionTeam() {
		return prosecutionTeam;
	}

	public Team getDefenseTeam() {
		return defenseTeam;
	}
	
	public void assignJudge(Judge judge) throws IllegalArgumentException, ConflictException {
		if(judge == null) {
			throw new IllegalArgumentException("Judge cannot be null");
		}
		if(judge.getConflicts().contains(defenseTeam)) {
			throw new ConflictException("Judge has conflict with defense team");
		} 
		if (judge.getConflicts().contains(prosecutionTeam)) {
			throw new ConflictException("Judge has conflict with prosecution team");
		}
		
		judges.add(judge);
	}
	
	public List<Judge> getJudges() {
		return judges;
	}
	
	public void end() throws ConflictException {
		prosecutionTeam.addToTeamsHit(defenseTeam);
        defenseTeam.addToTeamsHit(prosecutionTeam);
		for(Judge judge : judges) {
			judge.addConflict(prosecutionTeam);
			judge.addConflict(defenseTeam);
		}
		complete = true;
	}
	
	public boolean isComplete() {
		return complete;
	}
}
