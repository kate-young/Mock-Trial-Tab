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
public class TeamTest {
    private School school = mock(School.class);
    private Team team;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        team = new Team(1900, school);
    }

    private Team  setUpOtherTeam() throws Exception {
        School otherSchool = mock(School.class);
        return new Team(1111,school);
    }

    @Test
    public void lossIsIncrementedOnLoss() throws Exception {
        team.lose();

        assertEquals(1, team.getLosses(), .001);
    }

    @Test
    public void winIsIncrementedOnWin() throws Exception {
        team.win();

        assertEquals(1, team.getWins(), .001);
    }

    @Test
    public void halfWinAndHalfLossIsAddedOnTie() throws Exception {
        team.tie();

        assertEquals("half win is added", .5, team.getWins(), .001);
        assertEquals("half loss is added", .5, team.getLosses(), .001);
    }

    @Test
    public void conflictExceptionThrownWhenThisTeamIsAddedToTeamsHit() throws Exception {
        thrown.expect(ConflictException.class);
        thrown.expectMessage("Team cannot hit itself");
        team.addToTeamsHit(team);
    }

    @Test
    public void conflictExceptionThrownWhenTeamFromSameSchoolAddedToTeamsHit() throws Exception {
        Team otherTeam = new Team(2000, school);

        thrown.expect(ConflictException.class);
        thrown.expectMessage("Team cannot hit team from its own school");
        team.addToTeamsHit(otherTeam);
    }

    @Test
    public void nullTeamCannotBeAddedToTeamsHit() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Team cannot be null");
        team.addToTeamsHit(null);
    }

    @Test
    public void teamIsAddedToHitTeams() throws Exception {
        Team otherTeam = mock(Team.class);

        team.addToTeamsHit(otherTeam);

        assertTrue(team.getTeamsHit().contains(otherTeam));
    }

    @Test
    public void teamCantHitSameTeamTwice() throws Exception {
        Team otherTeam = mock(Team.class);

        thrown.expect(ConflictException.class);
        thrown.expectMessage("Team has already hit this team");
        team.addToTeamsHit(otherTeam);
        team.addToTeamsHit(otherTeam);
    }

    @Test
    public void compareOtherTeamWithFewerWins() throws Exception {
        Team otherTeam = setUpOtherTeam();
        otherTeam.win();
        otherTeam.lose();
        team.win();
        team.win();

        assertEquals(1, team.compareTo(otherTeam));
    }

    @Test
    public void comparetOtherTeamWithMoreWins() throws Exception {
        Team otherTeam = setUpOtherTeam();
        otherTeam.win();
        otherTeam.win();
        team.win();
        team.lose();

        assertEquals(-1, team.compareTo(otherTeam));
    }

    @Test
    public void comparetOtherTeamWithSameWinsButLowerCS() throws Exception {
        Team otherTeam = setUpOtherTeam();
        School school1 = mock(School.class);
        School school2 = mock(School.class);
        Team team1 = new Team(7777, school1);
        Team team2 = new Team(8888, school2);
        team1.win();
        team1.win();
        team2.lose();
        team2.lose();
        team.win();
        team.lose();
        team.addToTeamsHit(team1);
        otherTeam.win();
        otherTeam.lose();
        otherTeam.addToTeamsHit(team2);

        assertEquals(1, team.compareTo(otherTeam));
    }

    @Test
    public void compareToOtherTeamWithSameWinsButHigherCS() throws Exception {
        Team otherTeam = setUpOtherTeam();
        School school1 = mock(School.class);
        School school2 = mock(School.class);
        Team team1 = new Team(7777, school1);
        Team team2 = new Team(8888, school2);
        team1.win();
        team1.win();
        team2.lose();
        team2.lose();
        team.win();
        team.lose();
        team.addToTeamsHit(team2);
        otherTeam.win();
        otherTeam.lose();
        otherTeam.addToTeamsHit(team1);

        assertEquals(-1, team.compareTo(otherTeam));
    }

    @Test
    public void compareToOtherTeamWithSameWinsAndSameCS() throws Exception {
        Team otherTeam = setUpOtherTeam();
        School school1 = mock(School.class);
        Team team1 = new Team(7777, school1);
        team1.win();
        team1.win();
        team.win();
        team.lose();
        team.addToTeamsHit(team1);
        otherTeam.win();
        otherTeam.lose();
        otherTeam.addToTeamsHit(team1);

        assertEquals(0, team.compareTo(otherTeam));
    }
}