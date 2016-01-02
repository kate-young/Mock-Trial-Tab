package tab.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tab.dao.ISchoolDao;
import tab.model.School;
import tab.services.ISchoolService;

/**
 * Created by kate on 1/1/16.
 */
public class SchoolServiceImpl implements ISchoolService {

    @Autowired
    ISchoolDao schoolDao;

    @Override
    @Transactional
    public void saveSchool(School school) {
        schoolDao.saveSchool(school);
    }

    @Override
    public School getSchool(int schoolId) {
        return schoolDao.getSchool(schoolId);
    }

    @Override
    public void updateSchool(School school, int schoolId) {
        schoolDao.updateSchool(school, schoolId);
    }

    @Override
    public void deleteSchool(int schoolId) {
        schoolDao.deleteSchool(schoolId);
    }
}
