package tab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;

/**
 * Created by kate on 12/20/15.
 */
public class TournamentTest {

    private Tournament tournament;

    @Before
    public void setUp() throws Exception {
       tournament = new Tournament("name");
    }

    @Test
    public void schoolIsAdded() {
        School school = mock(School.class);

        tournament.addSchool(school);

        assertTrue(tournament.getSchools().contains(school));
    }

    @Test
    public void teamIsAdded() {
        Team team = mock(Team.class);

        tournament.addTeam(team);

        assertTrue(tournament.getTeams().contains(team));
    }
}