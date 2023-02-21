package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Projects")
public class Projects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int projectId;
	
	@Column(name = "project_name", length = 255,
			nullable = true, unique = true)
	private String projectName;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "projects")	
	private Set<Employees> employees;
	
	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	@Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "project_description")
    private String projectDescription;
    
    @Column(name = "completed_on")
    private LocalDate completedOn;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public LocalDate getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(LocalDate completedOn) {
		this.completedOn = completedOn;
	}

	public int getProjectId() {
		return projectId;
	}

    public Projects() {
    	
    }

	public Projects(String projectName, LocalDate startDate, String projectDescription, LocalDate completedOn) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.projectDescription = projectDescription;
		this.completedOn = completedOn;
	}
    
    
}
