package tab;

import java.util.ArrayList;

public class Round {
	private final Team prosecutionTeam;
	private final Team defenseTeam;
	public final ArrayList<Ballot> ballots;
	
	public Round(Team prosecutionTeam, Team defenseTeam, ArrayList<Ballot> ballots) {
		this.prosecutionTeam = prosecutionTeam;
		this.defenseTeam = defenseTeam;
		this.ballots = ballots;
	}

	public Team getProsecutionTeam() {
		return prosecutionTeam;
	}

	public Team getDefenseTeam() {
		return defenseTeam;
	}
}
