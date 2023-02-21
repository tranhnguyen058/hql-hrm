package fa.training.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.ProjectDao;
import fa.training.entities.Projects;
import fa.training.utils.HibernateUtils;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public boolean save(Projects project) {
		Session session = null;
		Transaction transaction =null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result =session.save(project);
			transaction.commit();
			
			return (result != null);
			
		} finally  {
			if (session != null) {
				session.close();
			}
			// TODO: handle exception
		}
	}

}
