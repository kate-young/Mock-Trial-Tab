package tab.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tab.model.Judge;
import tab.model.JudgeTournamentInstance;
import tab.model.Team;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class JudgeTournamentInstanceTest {

    private JudgeTournamentInstance judge;
    private Team team;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        judge = new JudgeTournamentInstance(mock(Judge.class));
        team = mock(Team.class);
    }

    public ExpectedException getThrown() {
        return thrown;
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
}