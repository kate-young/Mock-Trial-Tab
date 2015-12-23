package tab;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kate on 12/19/15.
 */
public class TrialTest {
    JudgeTournamentInstance judge;
    School school1;
    School school2;
    TeamTournamentInstance prosTeam;
    TeamTournamentInstance defTeam;
    Trial trial;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        judge = new JudgeTournamentInstance(new Judge("judge", "brown"));
        school1 = mock(School.class);
        school2 = mock(School.class);
        prosTeam = new TeamTournamentInstance(new Team(1111, school1));
        defTeam = new TeamTournamentInstance(new Team(1234, school2));
        trial = new Trial(prosTeam, defTeam);
    }

    @Test
    public void judgeIsAssigned() throws Exception {
        trial.assignJudge(judge);

        assertTrue(trial.getJudges().contains(judge));
    }

    @Test
    public void endingTrialAddsTeamsToJudgeConflicts() throws Exception {
        trial.assignJudge(judge);
        trial.end();

        assertTrue("prosecution team added to judge's conflicts", judge.getConflicts().contains(prosTeam.getTeam()));
        assertTrue("defense team added to judge's conflicts", judge.getConflicts().contains(defTeam.getTeam()));
    }

    @Test
    public void endingTrialAddsTeamsToEachothersTeamsHitLists() throws Exception {
        trial.end();

        assertTrue("Defense team added to Prosecution's teams hit list", prosTeam.getTeamsHit().contains(defTeam));
        assertTrue("Prosecution team added to Defense's teams hit list", defTeam.getTeamsHit().contains(prosTeam));
    }

    @Test
    public void endingTrialMarksTrialAsComplete() throws Exception {
        trial.end();

        assertTrue(trial.isComplete());
    }

    @Test
    public void judgeCannotBeAssignedIfTheyHaveAConflictWithProsecution() throws Exception {
        judge.addConflict(prosTeam.getTeam());

        thrown.expect(ConflictException.class);
        thrown.expectMessage("Judge has conflict with prosecution team");
        trial.assignJudge(judge);
    }

    @Test
    public void judgeCannotBeNull() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Judge cannot be null");
        trial.assignJudge(null);
    }
}