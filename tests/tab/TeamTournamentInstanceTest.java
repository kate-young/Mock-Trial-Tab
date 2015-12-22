package tab;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TeamTournamentInstanceTest {
    private TeamTournamentInstance teamInstance;
    private School school = new School("UMKC", "Kangaroos");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        Team team = new Team(1111, school);
        teamInstance = new TeamTournamentInstance(team);
    }

    private TeamTournamentInstance  setUpOtherTeamInstance() throws Exception {
        School otherSchool = mock(School.class);
        return new TeamTournamentInstance(new Team(1111,otherSchool));
    }

    @Test
    public void lossIsIncrementedOnLoss() throws Exception {
        teamInstance.lose();

        assertEquals(1, teamInstance.getLosses(), .001);
    }

    @Test
    public void winIsIncrementedOnWin() throws Exception {
        teamInstance.win();

        assertEquals(1, teamInstance.getWins(), .001);
    }

    @Test
    public void halfWinAndHalfLossIsAddedOnTie() throws Exception {
        teamInstance.tie();

        assertEquals("half win is added", .5, teamInstance.getWins(), .001);
        assertEquals("half loss is added", .5, teamInstance.getLosses(), .001);
    }
     @Test
    public void conflictExceptionThrownWhenThisTeamIsAddedToTeamsHit() throws Exception {
        thrown.expect(ConflictException.class);
        thrown.expectMessage("Team cannot hit itself");
        teamInstance.addToTeamsHit(teamInstance);
    }

    @Test
    public void conflictExceptionThrownWhenTeamFromSameSchoolAddedToTeamsHit() throws Exception {
        TeamTournamentInstance otherTeamInstance = new TeamTournamentInstance(new Team(2222, school));

        thrown.expect(ConflictException.class);
        thrown.expectMessage("Team cannot hit team from its own school");
        teamInstance.addToTeamsHit(otherTeamInstance);
    }

    @Test
    public void nullTeamCannotBeAddedToTeamsHit() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Team cannot be null");
        teamInstance.addToTeamsHit(null);
    }

    @Test
    public void teamIsAddedToHitTeams() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();

        teamInstance.addToTeamsHit(otherTeamInstance);

        assertTrue(teamInstance.getTeamsHit().contains(otherTeamInstance));
    }

    @Test
    public void teamCantHitSameTeamTwice() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();

        thrown.expect(ConflictException.class);
        thrown.expectMessage("Team has already hit this team");
        teamInstance.addToTeamsHit(otherTeamInstance);
        teamInstance.addToTeamsHit(otherTeamInstance);
    }

    @Test
    public void compareOtherTeamWithFewerWins() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();
        otherTeamInstance.win();
        otherTeamInstance.lose();
        teamInstance.win();
        teamInstance.win();

        assertEquals(1, teamInstance.compareTo(otherTeamInstance));
    }

    @Test
    public void compareToOtherTeamWithMoreWins() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();
        otherTeamInstance.win();
        otherTeamInstance.win();
        teamInstance.win();
        teamInstance.lose();

        assertEquals(-1, teamInstance.compareTo(otherTeamInstance));
    }

    @Test
    public void compareToOtherTeamWithSameWinsButLowerCS() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();
        School school1 = mock(School.class);
        School school2 = mock(School.class);
        TeamTournamentInstance team1 = new TeamTournamentInstance(new Team(7777, school1));
        TeamTournamentInstance team2 = new TeamTournamentInstance(new Team(8888, school2));
        team1.win();
        team1.win();
        team2.lose();
        team2.lose();
        teamInstance.win();
        teamInstance.lose();
        teamInstance.addToTeamsHit(team1);
        otherTeamInstance.win();
        otherTeamInstance.lose();
        otherTeamInstance.addToTeamsHit(team2);

        assertEquals(1, teamInstance.compareTo(otherTeamInstance));
    }

    @Test
    public void compareToOtherTeamWithSameWinsButHigherCS() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();
        TeamTournamentInstance team1 = new TeamTournamentInstance(new Team(7777, mock(School.class)));
        TeamTournamentInstance team2 = new TeamTournamentInstance(new Team(8888, mock(School.class)));
        team1.win();
        team1.win();
        team2.lose();
        team2.lose();
        teamInstance.win();
        teamInstance.lose();
        teamInstance.addToTeamsHit(team2);
        otherTeamInstance.win();
        otherTeamInstance.lose();
        otherTeamInstance.addToTeamsHit(team1);

        assertEquals(-1, teamInstance.compareTo(otherTeamInstance));
    }

    @Test
    public void compareToOtherTeamWithSameWinsAndSameCS() throws Exception {
        TeamTournamentInstance otherTeamInstance = setUpOtherTeamInstance();
        School school1 = mock(School.class);
        TeamTournamentInstance team1 = new TeamTournamentInstance(new Team(7777, school1));
        team1.win();
        team1.win();
        teamInstance.win();
        teamInstance.lose();
        teamInstance.addToTeamsHit(team1);
        otherTeamInstance.win();
        otherTeamInstance.lose();
        otherTeamInstance.addToTeamsHit(team1);

        assertEquals(0, teamInstance.compareTo(otherTeamInstance));
    }
}