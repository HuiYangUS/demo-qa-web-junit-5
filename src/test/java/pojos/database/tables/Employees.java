package pojos.database.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {

	// must at least one "@Id"
	@Id
	// "@Column" is not needed if variable name matches column name
	@Column(name = "employeeNumber")
	private int employeeNumber;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "extension")
	private String extension;

	@Column(name = "email")
	private String email;

	@Column(name = "officeCode")
	private String officeCode;

	// "reportsTo" can have null values and use Wrapper class
	@Column(name = "reportsTo")
	private Integer reportsTo;

	@Column(name = "jobTitle")
	private String jobTitle;

	public Employees() {
		// TODO Auto-generated constructor stub
	}

	public Employees(int employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, Integer reportsTo, String jobTitle) {
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
