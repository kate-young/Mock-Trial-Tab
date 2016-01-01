package tab;

import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static tab.HibernateUtil.getSessionFactory;

public class School {

	private String name;
	private String mascot;
	private final Date created;
	private Date updated;

	public School() {
		created = new Date();
	}

	public School(String name, String mascot) {
		if( exists(name) ) {
			throw new IllegalArgumentException("School with that name already exists");
		}
		this.name = name;
		this.mascot = mascot;
		this.created = new Date();
		this.updated = new Date();
	}

	public String getName() {
		return name;
	}

	public String getMascot() {
		return mascot;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setName(String name) {
		this.name = name;
		this.updated = new Date();
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
		this.updated = new Date();
	}

	public void save() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
		session.close();
	}

	protected boolean exists(String checkName) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("select 1 from schools where name = :name").setString("name", checkName);
		session.close();
		return query.uniqueResult() != null;
	}

	@Override
	public boolean equals(Object obj) {
		School otherSchool = (School) obj;

		return this.name == otherSchool.getName();
	}
}
