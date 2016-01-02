package tab.services;

import tab.model.School;

/**
 * Created by kate on 1/1/16.
 */
public interface ISchoolService {
    void saveSchool(School school);

    School getSchool(int schoolId);

    void updateSchool(School school, int schoolId);

    void deleteSchool(int schoolId);
}
