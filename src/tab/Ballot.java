package tab;

public class Ballot {
	private final ScoringJudge judge;
	private final Round round;
	
	public Ballot(ScoringJudge judge, Round round) {
		this.judge = judge;
		this.round = round;
	}

	public Judge getJudge() {
		return judge;
	}

	public Round getRound() {
		return round;
	}
}
