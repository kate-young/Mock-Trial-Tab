package tab;

import java.util.ArrayList;

public class Trial {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	private final ArrayList<Judge> judges;
	private boolean complete = false;
	
	public Trial(Team prosecutionTeam, Team defenseTeam) {
		if(prosecutionTeam.hasConflict(defenseTeam) || defenseTeam.hasConflict(prosecutionTeam)) {
			throw new IllegalArgumentException("Teams have a conflict");
		}
		this.prosecutionTeam = prosecutionTeam;
		this.defenseTeam = defenseTeam;
		this.judges = new ArrayList<Judge>();
	}

	public Team getProsecutionTeam() {
		return prosecutionTeam;
	}

	public Team getDefenseTeam() {
		return defenseTeam;
	}
	
	public void assignJudge(Judge judge) throws IllegalArgumentException {
		if(judge == null) {
			throw new IllegalArgumentException("Judge cannot be null");
		}
		
		if(judge.getConflicts().contains(defenseTeam)) {
			throw new IllegalArgumentException("Judge has conflict with " + defenseTeam.toString());
		} 
		if (judge.getConflicts().contains(prosecutionTeam)) {
			throw new IllegalArgumentException("Judge has conflict with " + prosecutionTeam.toString());
		}
		
		judges.add(judge);
	}
	
	public ArrayList<Judge> getJudges() {
		return judges;
	}
	
	public void end() {
		for(Judge judge : judges) {
			judge.addConflict(prosecutionTeam);
			judge.addConflict(defenseTeam);
		}
		prosecutionTeam.addToTeamsHit(defenseTeam);
		defenseTeam.addToTeamsHit(prosecutionTeam);
		complete = true;
	}
	
	public boolean isComplete() {
		return complete;
	}
}
