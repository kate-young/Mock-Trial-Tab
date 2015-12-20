package tab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by kate on 12/20/15.
 */
public class RoundTest {

    Round round;

    @Before
    public void setUp() throws Exception {
       round = new Round();
    }

    @Test
    public void judgeIsAdded() throws Exception {
        Judge judge = mock(Judge.class);

        round.addJudge(judge);

        assertTrue(round.getAvailableJudges().contains(judge));
    }

    @Test
    public void trialIsAdded() throws Exception {
        Trial trial = mock(Trial.class);

        round.addTrial(trial);

        assertTrue(round.getTrials().contains(trial));
    }

    @Test
    public void roundCompletedWhenAllTrialsAreComplete() throws Exception {
        Team team1 = mock(Team.class);
        Team team2 = mock(Team.class);
        Team team3 = mock(Team.class);
        Team team4 = mock(Team.class);

        Trial trial1 = new Trial(team1,team2);
        Trial trial2 = new Trial(team3,team4);

        round.addTrial(trial1);
        round.addTrial(trial2);

        trial1.end();
        trial2.end();

        assertTrue(round.isComplete());
    }

    @Test
    public void roundIncompletedWhenNotAllTrialsAreComplete() throws Exception {
        Team team1 = mock(Team.class);
        Team team2 = mock(Team.class);
        Team team3 = mock(Team.class);
        Team team4 = mock(Team.class);

        Trial trial1 = new Trial(team1,team2);
        Trial trial2 = new Trial(team3,team4);

        round.addTrial(trial1);
        round.addTrial(trial2);

        trial1.end();

        assertFalse(round.isComplete());
    }
}