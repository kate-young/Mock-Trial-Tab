package tab;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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