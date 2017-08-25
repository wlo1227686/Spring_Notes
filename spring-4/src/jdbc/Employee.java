package jdbc;

public class Employee {
	private Integer id;
	private String lastName;
	private String email;
	private int Dept_ID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDept_ID() {
		return Dept_ID;
	}

	public void setDept_ID(int dept_ID) {
		Dept_ID = dept_ID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", Dept_ID=" + Dept_ID + "]";
	}

}
