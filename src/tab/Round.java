package tab;

import java.util.ArrayList;

public class Round {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	private final ArrayList<Judge> judges;
	
	public Round(Team prosecutionTeam, Team defenseTeam) {
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
	
	public void assignJudge(Judge judge) throws Exception {
		if(judge.getConflicts().contains(defenseTeam)) {
			throw new Exception("Judge has conflict with " + defenseTeam.getId());
		} else if (judge.getConflicts().contains(prosecutionTeam)) {
			throw new Exception("Judge has conflict with " + prosecutionTeam.getId());
		}
		judges.add(judge);
	}
	
	public ArrayList<Judge> getJudges() {
		return judges;
	}
}
