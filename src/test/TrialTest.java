package test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tab.ConflictException;
import tab.Judge;
import tab.Trial;
import tab.School;
import tab.ScoringJudge;
import tab.Team;

public class TrialTest {

	private School school1;
	private School school2;
	private Team prosTeam;
	private Team defTeam;
	private Trial trial;
	private ScoringJudge judge1;
	private ScoringJudge judge2;
	private Judge judge3;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	public void setUpTrial() {
		this.school1 = new School("school1", "kangaroos");
		this.school2 = new School("school2", "jayhawks");
		this.prosTeam = new Team(1234, school1);
		this.defTeam = new Team(5678, school2);
		this.judge1 = new ScoringJudge("judge1", "test");
		this.judge2 = new ScoringJudge("judge2", "test");
		this.judge3 = new Judge("judge3", "test");
		try {
			this.trial = new Trial(prosTeam, defTeam);
		} catch (ConflictException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testTeamConflictsFromPreviousTrial() throws ConflictException {
		setUpTrial();
		try {
			new Trial(prosTeam, defTeam);
		} catch(ConflictException e) {
			thrown.expect(ConflictException.class);
		}
	}
	@Test
	public void testTeamConflictsSameTeam() throws ConflictException {
		School school = new School("MU", "tigers");
		Team team1 = new Team(1111, school);
		Team team2 = new Team(2222, school);
		try {
			new Trial(team1, team2);
		} catch(ConflictException e) {
			thrown.expect(ConflictException.class);
		}
	}
	@Test public void testTeamConflictsSameSchool() throws ConflictException {
		School school = new School("WashU", "Bears");
		Team team1 = new Team(3333, school);
		Team team2 = new Team(4444, school);
		try {
			new Trial(team1, team2);
		} catch(ConflictException e) {
			thrown.expect(ConflictException.class);
		}
	}
	
	@Test
	public void testConflictsAddedToJudges() {
		setUpTrial();
		try {
			trial.assignJudge(judge1);
			trial.assignJudge(judge2);
		} catch (Exception e) {
			fail("Judge Assignment Failed: " + e.getMessage());
		}
		trial.end();
		assertTrue(judge1.getConflicts().contains(prosTeam));
		assertTrue(judge2.getConflicts().contains(defTeam));
	}
	@Test
	public void testCorrectJudgeAssignment() {
		
		setUpTrial();
		try {
			trial.assignJudge(judge1);
			trial.assignJudge(judge2);
			trial.assignJudge(judge3);
		} catch (Exception e) {
			fail("Judge Assignment Failed: " + e.getMessage());
		}
		assertTrue(trial.getJudges().contains(judge1));
		assertTrue(trial.getJudges().contains(judge2));
		assertTrue(trial.getJudges().contains(judge3));
	}
	
	@Test
	public void testJudgeAssignmentWithConflict() throws ConflictException {
		setUpTrial();
		trial.end();
		Team prosTeam2 = new Team(1111,school1);
		Team defTeam2 = new Team(2222, school2);
		Trial trial2 = new Trial(prosTeam2, defTeam2);
		try {
			trial.assignJudge(judge1);
		} catch (Exception e) {
			fail("Initial Judge Assignment Failed: " + e.getMessage());
		}
		try {
			trial2.assignJudge(judge1);
		} catch(ConflictException e) {
			thrown.expect(ConflictException.class);
		}
	}
	@Test
	public void testCompletion() {
		setUpTrial();
		trial.end();
		assertTrue(trial.isComplete());
	}
}
