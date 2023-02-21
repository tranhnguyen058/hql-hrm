package fa.training.dao;




import static org.junit.Assert.assertEquals;

import java.time.LocalDate;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.dao.impl.JobDaoImpl;
import fa.training.entities.JobDetails;
import fa.training.entities.Jobs;

public class JobDaoTest {
	static JobDao jobDao;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        jobDao = new JobDaoImpl();
    }
    
    @Test
    void testSave1() throws Exception {
    	JobDetails jobDetail = new JobDetails("Java Developer Level 1", LocalDate.of(2020, 9, 1));
    	Jobs job = new Jobs("J01", "Java Dev1", 1000, 2000);
    	job.setJobDetails(jobDetail);
        jobDetail.setJob(job);

        
        assertEquals(true, jobDao.save(job));
    }
    
    @Test
    void testSave2() throws Exception {
        Jobs job = new Jobs("J02", "Java Dev2", 1200, 2200);
        assertEquals(true, jobDao.save(job));
    }

}
