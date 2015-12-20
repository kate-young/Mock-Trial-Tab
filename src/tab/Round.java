package tab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Round {
	private List<Trial> trials;
	private List<Judge> availableJudges;
	private long start; 								// Start time in milliseconds
	private static final long ALL_LOSS_TIME = 3 * 60 * 60 * 1000;	// 3 hours in milliseconds
	
	public Round() { 
		trials = new ArrayList<>();
		availableJudges = new ArrayList<>();
	}

	public void addJudge(Judge judge) {
		if(judge == null) {
			throw new IllegalArgumentException("judge cannot be null");
		}
		availableJudges.add(judge);
	}

	public List<Judge> getAvailableJudges() {
		return availableJudges;
	}

	public List<Trial> getTrials() {
		return trials;
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
