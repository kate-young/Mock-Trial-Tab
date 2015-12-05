package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tab.School;

public class SchoolTest {

	@Test
	public void autoIncrementSchoolId() {
		School school1 = new School("UMKC");
		School school2 = new School("KU");
		assertEquals(1, school1.getId());
		assertEquals(2, school2.getId());
	}
}
