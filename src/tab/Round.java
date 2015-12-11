package tab;

import java.util.ArrayList;
import java.util.Date;

public class Round {
	private ArrayList<Trial> trials;
	private ArrayList<Judge> availableJudges;
	private long start; 								// Start time in milliseconds
	private static final long ALL_LOSS_TIME = 3 * 60 * 60 * 1000;	// 3 hours in milliseconds
	
	public Round() { 
		trials = new ArrayList<Trial>();
		availableJudges = new ArrayList<Judge>();
	}
	
	public Round(ArrayList<Trial> trials) {
		if(trials == null) {
			throw new IllegalArgumentException("trial list cannot be null");
		}
		this.trials = trials;
		this.availableJudges = new ArrayList<Judge>();
	}
	
	public Round(ArrayList<Trial> trials, ArrayList<Judge> availableJudges) {
		if(trials == null) {
			throw new IllegalArgumentException("trial list cannot be null");
		}
		if(availableJudges == null) {
			throw new IllegalArgumentException("available judges list cannot be null");
		}
		this.availableJudges = availableJudges;
	}
	
	public void addJudge(Judge judge) {
		if(judge == null) {
			throw new IllegalArgumentException("judge cannot be null");
		}
		availableJudges.add(judge);
	}
	
	public void addTrial(Trial trial) {
		if(trial == null) {
			throw new IllegalArgumentException("trial cannot be null");
		}
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
