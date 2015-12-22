package tab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BallotTest {

    private School school1 = mock(School.class);
    private School school2 = mock(School.class);
    private TeamTournamentInstance prosTeam;
    private TeamTournamentInstance defTeam;
    private Trial trial;
    private ScoringJudge judge;
    private Ballot ballot;

    @Before
    public void setUp() throws Exception {
       judge = mock(ScoringJudge.class);
       prosTeam = new TeamTournamentInstance(new Team(1900, school1));
       defTeam = new TeamTournamentInstance(new Team(2000, school2));
       trial = new Trial(prosTeam, defTeam);
       ballot = new Ballot(judge, trial);
    }

    @Test
    public void prosecutionWinIncrementsProsecutionWinsAndDefenseLosses() throws Exception {
        ballot.score(120, 110);

        assertEquals("prosecution wins incremented", 1, prosTeam.getWins(), .001);
        assertEquals("prosecution losses remain", 0, prosTeam.getLosses(), .001);
        assertEquals("defense losses incremented", 1, defTeam.getLosses(), .001);
        assertEquals("defense wins remain", 0, defTeam.getWins(), .001);
    }

    @Test
    public void defenseWinIncrementsDefenseWinsAndProsecutionLosses() throws Exception {
        ballot.score(110, 120);

        assertEquals("prosecution wins remain", 0, prosTeam.getWins(), .001);
        assertEquals("prosecution losses incremented", 1, prosTeam.getLosses(), .001);
        assertEquals("defense losses remain", 0, defTeam.getLosses(), .001);
        assertEquals("defense wins incremented", 1, defTeam.getWins(), .001);
    }

    @Test
    public void tieAddsHalfToBothTeamsWinsAndLosses() throws Exception {
        ballot.score(100, 100);

        assertEquals("prosecution wins incremented by .5", .5, prosTeam.getWins(), .001);
        assertEquals("prosecution losses incremented by .5", .5, prosTeam.getLosses(), .001);
        assertEquals("defense losses incremented by .5", .5, defTeam.getLosses(), .001);
        assertEquals("defense wins incremented by .5", .5, defTeam.getWins(), .001);
    }

    @Test
    public void bothTeamsLoseWithAllLose() throws Exception {
        ballot.score(0,0);

        assertEquals("prosecution wins remains", 0, prosTeam.getWins(), .001);
        assertEquals("prosecution losses incremented", 1, prosTeam.getLosses(), .001);
        assertEquals("defense losses incremented", 1, defTeam.getLosses(), .001);
        assertEquals("defense wins remains", 0, defTeam.getWins(), .001);
    }

    @Test
    public void scoreIsUpdated() throws Exception {
        ballot.score(110, 120);

        assertEquals("prosecution score is updated", 110, ballot.getProsecutionScore());
        assertEquals("defense score is updated", 120, ballot.getDefenseScore());
    }
}