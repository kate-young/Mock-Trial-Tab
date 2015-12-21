package tab;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolTest {

    School school1 = new School("UMKC", "kangaroo");
    School school2 = new School("KU", "jayhawk");

    @Test
    public void idIsAutoIncremented() throws Exception {
        assertEquals(1, school1.getId());
        assertEquals(2, school2.getId());
    }

    @Test
    public void twoSchoolsAreEqual() throws Exception {
        School school = new School("UMKC", "no mascot");

        assertTrue(school1.equals(school));
    }
}