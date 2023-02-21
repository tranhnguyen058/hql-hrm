package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "JobDetails"
//, schema = "dbo"
)
public class JobDetails {

	@Id
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(parameters = {@Parameter(name = "property", value = "job")},strategy = "foreign", name = "foreigngen")
	@Column(name = "job_detail_id", length = 10)
	private String jobDetailId;

	@Column(name = "job_description", length = 255)
	private String jobDescription;

	@Column(name = "active_date")
	private LocalDate activeDate;

	@OneToOne
	@JoinColumn(name = "job_id", referencedColumnName = "job_id")
	private Jobs job;

	public JobDetails() {

	}
	

	// Constructors with params
	// getter and setter methods

	
	public Jobs getJob() {
		return job;
	}


	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	

	public LocalDate getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(LocalDate activeDate) {
		this.activeDate = activeDate;
	}

	public JobDetails(String jobDetailId, String jobDescription, LocalDate activeDate, Jobs job) {
		super();
		this.jobDetailId = jobDetailId;
		this.jobDescription = jobDescription;
		this.activeDate = activeDate;
		this.job = job;
	}

	public String getJobDetailId() {
		return jobDetailId;
	}


	public void setJobDetailId(String jobDetailId) {
		this.jobDetailId = jobDetailId;
	}


	public JobDetails(String jobDescription, LocalDate of) {
		// TODO Auto-generated constructor stub
		this.jobDescription = jobDescription;
		this.activeDate =of;
	}


	public void setJob(Jobs job) {
		this.job = job;
	}
}
