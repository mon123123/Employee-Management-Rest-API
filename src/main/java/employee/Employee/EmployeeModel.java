package employee.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeModel {
	int empId;
	String empName;
	String empDepartment;
	Double empSlary;
	String empRole;
	int emp_Workexperience;
	
	public EmployeeModel() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeModel(int empId, String empName, String empDepartment, Double empSlary, String empRole,
			int emp_Workexperience) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empSlary = empSlary;
		this.empRole = empRole;
		this.emp_Workexperience = emp_Workexperience;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public Double getEmpSlary() {
		return empSlary;
	}

	public void setEmpSlary(Double empSlary) {
		this.empSlary = empSlary;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public int getEmp_Workexperience() {
		return emp_Workexperience;
	}

	public void setEmp_Workexperience(int emp_Workexperience) {
		this.emp_Workexperience = emp_Workexperience;
	}

	@Override
	public String toString() {
		return " [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment
				+ ", empSlary=" + empSlary + ", empRole=" + empRole + ", emp_Workexperience=" + emp_Workexperience
				+ "]";
	}
	
}
