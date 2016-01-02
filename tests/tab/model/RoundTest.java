package tab.model;

import org.junit.Before;
import org.junit.Test;
import tab.model.Judge;
import tab.model.Round;
import tab.model.TeamTournamentInstance;
import tab.model.Trial;

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
        TeamTournamentInstance team1 = mock(TeamTournamentInstance.class);
        TeamTournamentInstance team2 = mock(TeamTournamentInstance.class);
        TeamTournamentInstance team3 = mock(TeamTournamentInstance.class);
        TeamTournamentInstance team4 = mock(TeamTournamentInstance.class);

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
        TeamTournamentInstance team1 = mock(TeamTournamentInstance.class);
        TeamTournamentInstance team2 = mock(TeamTournamentInstance.class);
        TeamTournamentInstance team3 = mock(TeamTournamentInstance.class);
        TeamTournamentInstance team4 = mock(TeamTournamentInstance.class);

        Trial trial1 = new Trial(team1,team2);
        Trial trial2 = new Trial(team3,team4);

        round.addTrial(trial1);
        round.addTrial(trial2);

        trial1.end();

        assertFalse(round.isComplete());
    }
}