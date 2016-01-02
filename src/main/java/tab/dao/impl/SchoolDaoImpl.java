package tab.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tab.dao.ISchoolDao;
import tab.model.School;

public class SchoolDaoImpl implements ISchoolDao {

    private static final Logger LOG = LoggerFactory.getLogger(SchoolDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveSchool(School school) {
        LOG.info("In Dao, request to add new school details into the database name:{}", school.getName());
        sessionFactory.getCurrentSession().save(school);
        LOG.info("School details saved successfully in database");
    }

    @Override
    public School getSchool(int schoolId) {
        LOG.info("In Dao, request to fetch school details for school id:{}",schoolId);
        School school = sessionFactory.getCurrentSession().get(School.class, schoolId);
        LOG.info("School details retrieved successfully from database");
        return school;
    }

    @Override
    public void deleteSchool(int schoolId) {
        LOG.info("In Dao, request to delete school details id:{}", schoolId);
        Session session = sessionFactory.getCurrentSession();
        School school = session.get(School.class, schoolId);
        session.delete(school);
        LOG.debug("School details deleted successfully from DB");
    }

    @Override
    public void updateSchool(School sch, int schoolId) {
        LOG.info("In Dao, request to update employee details id:{}", schoolId);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        School school = session.get(School.class, schoolId);
        school.setName(sch.getName());
        school.setMascot(sch.getMascot());
        LOG.debug("School details deleted successfully from database");
    }
}
