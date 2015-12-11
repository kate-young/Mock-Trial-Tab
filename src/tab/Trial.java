package tab;

import java.util.ArrayList;

public class Trial {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	private final ArrayList<Judge> judges;
	private boolean complete = false;
	
	public Trial(Team prosecutionTeam, Team defenseTeam) {
		if(prosecutionTeam == null) {
			throw new IllegalArgumentException("Prosecution team cannot be null");
		}
		if(defenseTeam == null) {
			throw new IllegalArgumentException("Defense team cannot be null");
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
			throw new IllegalArgumentException("Judge has conflict with " + defenseTeam);
		} 
		if (judge.getConflicts().contains(prosecutionTeam)) {
			throw new IllegalArgumentException("Judge has conflict with " + prosecutionTeam);
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
		complete = true;
	}
	
	public boolean isComplete() {
		return complete;
	}
}
