package tab;

import java.util.ArrayList;

public class Round {
	private ArrayList<Trial> trials;
	private ArrayList<Judge> availableJudges;
	
	public Round() { 
		trials = new ArrayList<Trial>();
		availableJudges = new ArrayList<Judge>();
	}
	
	public Round(ArrayList<Trial> trials) {
		this.trials = trials;
		this.availableJudges = new ArrayList<Judge>();
	}
	
	public Round(ArrayList<Trial> trials, ArrayList<Judge> availableJudges) {
		this.trials = trials;
		this.availableJudges = availableJudges;
	}
	
	public void addJudge(Judge judge) {
		availableJudges.add(judge);
	}
	
	public void addTrial(Trial trial) {
		trials.add(trial);
	}
	
	public boolean isComplete() {
		for( Trial trial : trials) {
			if (!trial.isComplete()) 
				return false;
		}
		return true;
	}
}
