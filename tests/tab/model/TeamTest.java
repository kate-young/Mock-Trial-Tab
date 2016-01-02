package tab.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tab.model.School;
import tab.model.Team;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by kate on 12/19/15.
 */
public class TeamTest {
    private School school = mock(School.class);
    private Team team;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        team = new Team(1900, school);
    }

    @Test
    public void equalsSameTeam() throws Exception {
        Team otherTeam = new Team(1900, school);
        assertTrue(team.equals(otherTeam));
    }

    @Test
    public void doesNotEqualDifferentTeam() throws Exception {
        Team otherTeam = new Team(2000, school);
        assertFalse(team.equals(otherTeam));
    }
}