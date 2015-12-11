package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tab.Ballot;
import tab.Judge;
import tab.School;
import tab.ScoringJudge;
import tab.Team;
import tab.Trial;

public class TeamTest {
	
	private School ku = new School("KU", "jayhawk");
	private School umkc = new School("UMKC", "kanagaroo");
	private Team kuA = new Team(1111,ku);
	private Team umkcA = new Team(2222, umkc);
	private ScoringJudge judge1 = new ScoringJudge("judge1", "test");
	private ScoringJudge judge2 = new ScoringJudge("judge2", "test");
	private ArrayList<Judge> judges = new ArrayList<Judge>();
	private Trial trial;
	private Ballot ballot1;
	private Ballot ballot2;
	
	private void setUpTrial() {
		judges.add(judge1);
		judges.add(judge2);
		trial = new Trial(kuA, umkcA);
		ballot1 = new Ballot(judge1, trial);
		ballot2 = new Ballot(judge2, trial);
		trial.end();
	}

	@Test
	public void testTeamsHitUpdates() {
		setUpTrial();
		assertTrue(kuA.getTeamsHit().contains(umkcA));
		assertTrue(umkcA.getTeamsHit().contains(kuA));
	}
	
	@Test
	public void testCombinedStrengthAllLoss() {
		setUpTrial();
		ballot1.score(0, 0);
		ballot2.score(0, 0);
		
		assertEquals(0, kuA.getCombinedStrength(), .001);
		assertEquals(0, umkcA.getCombinedStrength(), .001);
	}
	
	@Test
	public void testCombinedStrengthProsecutionWin() {
		setUpTrial();
		ballot1.score(140, 110);
		ballot2.score(140, 100);
		
		assertEquals(0, kuA.getCombinedStrength(), .001);
		assertEquals(2, umkcA.getCombinedStrength(), 001);
	}
	
	@Test
	public void testCombinedStrengthDefenseWin() {
		setUpTrial();
		ballot1.score(120, 140);
		ballot2.score(120, 140);
		
		assertEquals(2, kuA.getCombinedStrength(), .001);
		assertEquals(0, umkcA.getCombinedStrength(), 001);
	}
	
	@Test
	public void testCombinedStrengthTie() {
		setUpTrial();
		ballot1.score(100, 100);
		ballot2.score(140, 140);
		
		assertEquals(1, kuA.getCombinedStrength(), .001);
		assertEquals(1, umkcA.getCombinedStrength(), .001);
	}
	
	@Test
	public void testCombinedStrengthSplit() {
		setUpTrial();
		ballot1.score(100, 140);
		ballot2.score(130, 110);
		
		assertEquals(1, kuA.getCombinedStrength(), .001);
		assertEquals(1, umkcA.getCombinedStrength(), .001);
	}
	
	@Test 
	public void testCombinedStrengthSplitTie() {
		setUpTrial();
		ballot1.score(100, 100);
		ballot2.score(140, 120);
		
		assertEquals(.5, kuA.getCombinedStrength(), 001);
		assertEquals(1.5, umkcA.getCombinedStrength(), 001);
	}
}
