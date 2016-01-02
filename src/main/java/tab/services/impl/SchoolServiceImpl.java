package tab.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tab.dao.ISchoolDao;
import tab.model.School;
import tab.services.ISchoolService;

/**
 * Created by kate on 1/1/16.
 */
public class SchoolServiceImpl implements ISchoolService {
    private static final Logger LOG = LoggerFactory.getLogger(SchoolServiceImpl.class);

    @Autowired
    ISchoolDao schoolDao;

    @Override
    @Transactional
    public void saveSchool(School school) {
        LOG.info("In Service");
        schoolDao.saveSchool(school);
    }

    @Override
    @Transactional
    public School getSchool(int schoolId) {
        LOG.info("In Service");
        return schoolDao.getSchool(schoolId);
    }

    @Override
    @Transactional
    public void updateSchool(School school, int schoolId) {
        LOG.info("In Service");
        schoolDao.updateSchool(school, schoolId);
    }

    @Override
    @Transactional
    public void deleteSchool(int schoolId) {
        LOG.info("In Service");
        schoolDao.deleteSchool(schoolId);
    }
}
