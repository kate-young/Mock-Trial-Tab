package tab.dao;

import tab.model.School;

public interface ISchoolDao {
    void saveSchool(School school);

    School getSchool(int schoolId);

    void deleteSchool(int schoolId);

    void updateSchool(School schoo, int schoolId);
}
