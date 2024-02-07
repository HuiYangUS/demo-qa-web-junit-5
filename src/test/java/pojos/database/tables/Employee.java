package pojos.database.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	/*
	 * reportsTo has null value and must learn to fix it
	 */

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

	@Column(name = "jobTitle")
	private String jobTitle;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, String jobTitle) {
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
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
