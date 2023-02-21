package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employees"
//, schema = "dbo"
//, indexes = {@Index(columnList = "firstName, lastName",name = "IDX_EMP_NAME")}
)
public class Employees {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "firstName", length = 255, nullable = false)
    private String first_name;
    
    @Column(name = "lastName", length = 255, nullable = false)
    private String last_name;
    
    @Column(name = "email", length = 20, unique = true)
    private String email;
    
    @Column(name = "phone_number", length = 20, unique = true)
    private String phoneNumber;
    
    @Column(name = "hire_date")
    private LocalDate hireDate;
    
    private double salary;
    
    @Column(name = "commission_pct")
    private double commissionPct;
    
    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "job_id")
    private Jobs job;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Project",
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name ="project_id"))
    private Set<Projects> projects;
    
    public Set<Projects> getProjects() {
		return projects;
	}

	public void setProjects(Set<Projects> projects) {
		this.projects = projects;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Jobs getJob() {
        return job;
    }
    
    public void setJob(Jobs job) {
        this.job = job;
    }

    
    public Employees() {
    	
    }

	public Employees(int employeeId, String first_name, String last_name, String email, String phoneNumber,
			LocalDate hireDate, double salary, double commissionPct, Jobs job) {
		super();
		this.employeeId = employeeId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.job = job;
	}

	public Employees(String first_name, String last_name, String email, String phoneNumber, LocalDate hireDate,
			double salary, double commissionPct) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
	}
	
    
}
