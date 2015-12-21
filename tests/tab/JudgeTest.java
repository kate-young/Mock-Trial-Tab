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
public class JudgeTest {

    private Judge judge;
    private Team team;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        judge = new Judge("judge", "brown");
        team = mock(Team.class);
    }

    @Test
    public void teamConflictIsAddedToJudge() throws Exception {
        judge.addConflict(team);

        assertTrue(judge.getConflicts().contains(team));
    }

    @Test
    public void nullTeamCannotBeAddedToConflicts() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Team cannot be null");

        judge.addConflict(null);
    }

    @Test
    public void twoJudgesAreEqual() throws Exception {
        Judge judge2 = new Judge("judge", "brown");

        assertTrue(judge.equals(judge2));
    }
}