package fa.training.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo"
//, name = "Jobs"
//,indexes = {@Index(columnList = "job_id, job_title", name = "IDX_ID_TITLE") }
)
public class Jobs {
	
	@Id
	@Column(name = "job_id",length = 10)
	private String jobId;
	
	@Column(name = "job_title",length = 255,nullable = false,unique = false)
	private String jobTitle;
	
	@Column(name = "min_salary",precision = 11,scale = 2)
	private double minSalary;
	
	@Column(name = "max_salary",precision = 11,scale = 2)
	private double maxSalary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "job",fetch = FetchType.LAZY)
	private Set<Employees> employees;
	
	
	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	public Jobs() {
		// TODO Auto-generated constructor stub
	}
	
	public Jobs(String jobId, String jobTitle, double minSalary, double maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "job")
	@PrimaryKeyJoinColumn
    private JobDetails jobDetail;
	
		
	
    public JobDetails getJobDetail() {
        return jobDetail;
    }

    public void setJobDetails(JobDetails jobDetail) {
        this.jobDetail = jobDetail;
    }


	public void setJobDetail(JobDetails jobDetail) {
		this.jobDetail = jobDetail;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getJobId() {
		return jobId;
	}
	
	
}
