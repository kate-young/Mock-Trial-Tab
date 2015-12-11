package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tab.School;

public class SchoolTest {

	@Test
	public void autoIncrementSchoolId() {
		School school1 = new School("UMKC", "kangaroos");
		School school2 = new School("KU", "jayhawks");
		assertEquals(school1.getId() + 1, school2.getId());
	}
}
