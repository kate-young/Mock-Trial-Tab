package tab.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tab.dao.ISchoolDao;
import tab.model.School;
import org.springframework.beans.factory.annotation.Autowired;

public class SchoolDaoImpl implements ISchoolDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveSchool(School school) {
        sessionFactory.getCurrentSession().save(school);
    }

    @Override
    public School getSchool(int schoolId) {
        return sessionFactory.getCurrentSession().get(School.class, schoolId);
    }

    @Override
    public void deleteSchool(int schoolId) {
        Session session = sessionFactory.getCurrentSession();
        School school = session.get(School.class, schoolId);
        session.delete(school);
    }

    @Override
    public void updateSchool(School sch, int schoolId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        School school = session.get(School.class, schoolId);
        school.setName(sch.getName());
        school.setMascot(sch.getMascot());
    }
}
