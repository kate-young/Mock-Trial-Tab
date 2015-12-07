package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tab.Round;
import tab.School;
import tab.Team;
import tab.Trial;

public class RoundTest {

	private School school1;
	private School school2;
	private Team prosTeam1;
	private Team defTeam1;
	private Team prosTeam2;
	private Team defTeam2;
	private Trial trial1;
	private Trial trial2;
	private ArrayList<Trial> trials;
	private Round round;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	public void setUpTrials() {
		this.school1 = new School("school1", "kangaroos");
		this.school2 = new School("school2", "jayhawks");
		this.prosTeam1 = new Team(1234, school1);
		this.defTeam1 = new Team(5678, school2);
		this.prosTeam2 = new Team(9101, school1);
		this.defTeam2 = new Team(1213, school2);
		this.trial1 = new Trial(prosTeam1, defTeam1);
		this.trial2 = new Trial(prosTeam2, defTeam2);
		this.trials = new ArrayList<Trial>();
		trials.add(trial1);
		trials.add(trial2);
		this.round = new Round(trials);
	}
	
	@Test
	public void testCompletion() {
		setUpTrials();
		trial1.end();
		trial2.end();
		assertTrue(round.isComplete());
	}
	
	@Test
	public void testInCompletion() {
		setUpTrials();
		trial1.end();
		assertFalse(round.isComplete());
	}
}
