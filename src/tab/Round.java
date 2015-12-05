package tab;

public class Round {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	
	public Round(Team prosecutionTeam, Team defenseTeam) {
		this.prosecutionTeam = prosecutionTeam;
		this.defenseTeam = defenseTeam;
	}

	public Team getProsecutionTeam() {
		return prosecutionTeam;
	}

	public Team getDefenseTeam() {
		return defenseTeam;
	}
}
