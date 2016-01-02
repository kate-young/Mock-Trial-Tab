package tab.model;

public class Ballot {
	private final ScoringJudge judge;
	private int prosecutionScore;
	private int defenseScore;
	private Trial trial;
	private static final int ALL_LOSS_SCORE = 0;
	
	public Ballot(ScoringJudge judge, Trial trial) {
		this.judge = judge;
		this.trial = trial;
	}

	public Judge getJudge() {
		return judge;
	}

	public int getProsecutionScore() {
		return prosecutionScore;
	}

	public int getDefenseScore() {
		return defenseScore;
	}

	public void score(int prosecutionScore, int defenseScore) {
		this.defenseScore = defenseScore;
		this.prosecutionScore = prosecutionScore;
		TeamTournamentInstance defense = this.trial.getDefenseTeam();
		TeamTournamentInstance prosecution = this.trial.getProsecutionTeam();
		if(prosecutionScore == ALL_LOSS_SCORE && defenseScore == ALL_LOSS_SCORE) {
			prosecution.lose();
			defense.lose();
		} else if(prosecutionScore > defenseScore) {
			prosecution.win();
			defense.lose();
		} else if (defenseScore > prosecutionScore) {
			prosecution.lose();
			defense.win();
		} else {
			prosecution.tie();
			defense.tie();
		}
	}
}
