package test;

import static org.junit.Assert.*;
import org.junit.Test;

import tab.Ballot;
import tab.Round;
import tab.School;
import tab.ScoringJudge;
import tab.Team;

public class BallotTest {

	private School school1;
	private School school2;
	private Team prosTeam;
	private Team defTeam;
	private Round round;
	private Ballot ballot;
	private ScoringJudge judge;
	
	public void setUpRound() {
		this.school1 = new School("school1");
		this.school2 = new School("school2");
		this.prosTeam = new Team(1234, school1);
		this.defTeam = new Team(5678, school2);
		this.judge = new ScoringJudge("judge", "test");
		this.round = new Round(prosTeam, defTeam);
		this.ballot = new Ballot(judge, round);
	}
	@Test
	public void testProsecutionWin() {
		setUpRound();
		ballot.score(130, 110);
		assertEquals(1, prosTeam.getWins(), .001);
		assertEquals(0, prosTeam.getLosses(), .001);
		assertEquals(0, defTeam.getWins(), .001);
		assertEquals(1, defTeam.getLosses(), .001);		
	}
	@Test
	public void testDefenseWin() {
		setUpRound();
		ballot.score(120, 135);
		assertEquals(0, prosTeam.getWins(), .001);
		assertEquals(1, prosTeam.getLosses(), .001);
		assertEquals(1, defTeam.getWins(), .001);
		assertEquals(0, defTeam.getLosses(), .001);
	}
	@Test
	public void testTie() {
		setUpRound();
		ballot.score(120, 120);
		assertEquals(.5, prosTeam.getWins(), .001);
		assertEquals(.5, prosTeam.getLosses(), .001);
		assertEquals(.5, defTeam.getWins(), .001);
		assertEquals(.5, defTeam.getLosses(), .001);
	}
	@Test
	public void testJudgeConflicts() {
		setUpRound();
		ballot.score(130, 125);
		assertEquals(2, judge.getConflicts().size());
		assertTrue(judge.getConflicts().contains(prosTeam));
		assertTrue(judge.getConflicts().contains(defTeam));
	}
}
