package tab;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by kate on 12/20/15.
 */
public class AppTest {

    private App app;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        app = new App();
    }

    @Test
    public void addSchool() throws  Exception {
        School school = app.addSchool("UMKC", "Kangaroo");

        assertTrue(app.getSchools().contains(school));
    }

    @Test
    public void addJudge() throws Exception {
        Judge judge = app.addJudge("Kate", "Young");

        assertTrue(app.getJudges().contains(judge));
    }

    @Test
    public void addTournament() throws Exception {
        Tournament tournament = app.addTournament("City of Fountains", 2015);

        assertTrue(app.getTournaments().contains(tournament));
    }

    @Test
    public void cannotAddSchoolThatIsAlreadyAdded() throws Exception {
        app.addSchool("UMKC", "Kangaroo");

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("School already added");
        app.addSchool("UMKC", "Kangaroo");
    }

    @Test
    public void cannotAddJudgeThatIsAlreadyAdded() throws Exception {
        app.addJudge("Kate", "Young");

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Judge already added");
        app.addJudge("Kate", "Young");
    }
}