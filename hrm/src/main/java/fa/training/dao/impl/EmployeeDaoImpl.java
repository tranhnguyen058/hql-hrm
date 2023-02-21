package fa.training.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.EmployeeDao;
import fa.training.entities.Employees;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao	 {

	@Override
	public boolean save(Employees employee) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Serializable result = session.save(employee);
            
            transaction.commit();
            
            return (result != null);
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

	

}
