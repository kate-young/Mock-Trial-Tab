package tab;

import java.util.ArrayList;

public class Trial {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	private final ArrayList<Judge> judges;
	private boolean complete = false;
	
	public Trial(Team prosecutionTeam, Team defenseTeam) throws ConflictException {
		if(prosecutionTeam.hasConflict(defenseTeam) || defenseTeam.hasConflict(prosecutionTeam)) {
			throw new ConflictException("Teams have a conflict", defenseTeam, prosecutionTeam);
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
	
	public void assignJudge(Judge judge) throws IllegalArgumentException, ConflictException {
		if(judge == null) {
			throw new IllegalArgumentException("Judge cannot be null");
		}
		
		if(judge.getConflicts().contains(defenseTeam)) {
			throw new ConflictException("judge has conflict", judge, defenseTeam);
		} 
		if (judge.getConflicts().contains(prosecutionTeam)) {
			throw new ConflictException("judge has conflict", judge, prosecutionTeam);
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
		try {
			prosecutionTeam.addToTeamsHit(defenseTeam);
			defenseTeam.addToTeamsHit(prosecutionTeam);
		} catch (ConflictException e) {
			e.printStackTrace();
		}
		complete = true;
	}
	
	public boolean isComplete() {
		return complete;
	}
}
