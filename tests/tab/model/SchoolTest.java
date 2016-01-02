package tab.model;

import org.junit.Test;
import tab.model.School;

import static org.junit.Assert.*;

public class SchoolTest {

    School school1 = new School("UMKC", "kangaroo");
    School school2 = new School("KU", "jayhawk");

    @Test
    public void twoSchoolsAreEqual() throws Exception {
        School school = new School("UMKC", "no mascot");

        assertTrue(school1.equals(school));
    }
}