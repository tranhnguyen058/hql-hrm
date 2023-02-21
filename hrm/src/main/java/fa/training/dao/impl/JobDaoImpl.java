package fa.training.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.JobDao;
import fa.training.entities.Jobs;
import fa.training.utils.HibernateUtils;

public class JobDaoImpl implements JobDao {
    @Override
    public boolean save(Jobs job) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Serializable result = session.save(job);
            
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

	@Override
	public Jobs findById(String jobId) throws Exception {
Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            Jobs job = session.get(Jobs.class, jobId);
            
            return job;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }

	}


}
