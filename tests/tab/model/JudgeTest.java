package tab.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tab.model.Judge;

import static org.junit.Assert.*;

public class JudgeTest {

    private Judge judge;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        judge = new Judge("judge", "brown");
    }

    @Test
    public void twoJudgesAreEqual() throws Exception {
        Judge judge2 = new Judge("judge", "brown");

        assertTrue(judge.equals(judge2));
    }

    @Test
    public void toStringReturnsLastAndFirstName() throws Exception {
        assertEquals("brown, judge", judge.toString());
    }
}