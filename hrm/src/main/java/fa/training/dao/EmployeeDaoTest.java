package fa.training.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.dao.impl.EmployeeDaoImpl;
import fa.training.entities.Employees;
import fa.training.entities.Jobs;

public class EmployeeDaoTest {
static EmployeeDao employeeDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        employeeDao = new EmployeeDaoImpl();
    }

    private Jobs job;
    
    @Test
    void testSave() throws Exception {
        Employees employee = new Employees("Nguyen", "Quang Anh",
                "anhnd22@fsoft.com.vn", "0988777666", LocalDate.of(2019, 1, 1), 1000, 1.1);
        
	   employee.setJob(job);
        
        assertTrue(employeeDao.save(employee));

    }
    

}
