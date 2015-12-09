package tab;

import java.util.ArrayList;
import java.util.Date;

public class Round {
	private ArrayList<Trial> trials;
	private ArrayList<Judge> availableJudges;
	private long start; 								// Start time in milliseconds
	private static final long ALL_LOSS_TIME = 10800000;	// 3 hours in milliseconds
	
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

	public Date getStart() {
		return new Date(start);
	}
	
	public long getStartMillis() {
		return start;
	}

	public void start() {
		this.start = System.currentTimeMillis();
	}
	
	public Date getAllLossTime() {
		return new Date(start + ALL_LOSS_TIME);
	}
	
	public long getAllLossTimeMillis() {
		return start + ALL_LOSS_TIME;
	}
}
