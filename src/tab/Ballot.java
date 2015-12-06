package tab;

public class Ballot {
	private final ScoringJudge judge;
	private int prosecutionScore;
	private int defenseScore;
	private Round round;
	
	public Ballot(ScoringJudge judge, Round round) {
		this.judge = judge;
		this.round = round;
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
		this.updateJudgeConflicts();
		this.defenseScore = defenseScore;
		this.prosecutionScore = prosecutionScore;
		Team defense = this.round.getDefenseTeam();
		Team prosecution = this.round.getProsecutionTeam();
		if(prosecutionScore > defenseScore) {
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
	private void updateJudgeConflicts() {
		judge.addConflict(round.getProsecutionTeam());
		judge.addConflict(round.getDefenseTeam());
	}
}
