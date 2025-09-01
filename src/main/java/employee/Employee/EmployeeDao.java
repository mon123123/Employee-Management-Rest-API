package employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class EmployeeDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private EmployeeModel employeemodel;

	public boolean insertemployee(EmployeeModel model) {
		boolean status = false;
		try {
			String sql = "INSERT INTO employeedata (empId,empName,empDepartment,empSlary,empRole,emp_Workexperience) VALUES (?,?,?,?,?,?)";
			int count = jdbctemplate.update(sql, model.getEmpId(), model.getEmpName(), model.getEmpDepartment(),
					model.getEmpSlary(), model.getEmpRole(), model.getEmp_Workexperience());
			if (count > 0) {
				System.out.println("insert successfully");
				status = true;
			}
			else {
				System.out.println("insert fail");
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean updatedata(EmployeeModel model) {
		boolean status = false;
		try {

			String sql = "UPDATE employeedata SET empName =?,empDepartment=?,empSlary=?,empRole=?,emp_Workexperience=? WHERE empId=?";
			int count = jdbctemplate.update(sql, model.getEmpId(), model.getEmpName(), model.getEmpDepartment(),
					model.getEmpSlary(), model.getEmpRole(), model.getEmp_Workexperience());
			if (count > 0) {
				System.out.println("update successfully");
				status = true;
			} else {
				System.out.println("updata fail");
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
      public boolean deletedata(int empId) {
    	  boolean status = false;
    	  try {
    	  String sql = "DELETE employeedata WHERE empId =?";
    	  int count = jdbctemplate.update(sql, empId);
    	  if(count>0) {
    		  System.out.println("delete successfully");
    		  status=true;
    	  }
    	  else {
    		  System.out.println("deletion fail");
    	  }
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  return status;
      }
      
     
      public ArrayList<EmployeeModel> getallemp() {
    	  String sql = "SELECT * FROM employeedata";
    	  return (ArrayList<EmployeeModel>) jdbctemplate.query(sql, new EmployeeeRowMapper());
      }
      
      
      public EmployeeModel getempbyid(int id) {
    	  String sql = "SELECT * FROM employeedata WHERE empId = ?";
    	  return  jdbctemplate.queryForObject(sql, new EmployeeeRowMapper(),id);
    	  
      }
      
      
    public static  final class EmployeeeRowMapper implements RowMapper<EmployeeModel>{

		@Override
		public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeModel model = new EmployeeModel();
			model.setEmpId(rs.getInt("empId"));
			model.setEmpName(rs.getString("empName"));
			model.setEmpDepartment(rs.getString("empDepartment"));
			model.setEmpSlary(rs.getDouble("empSlary"));
			model.setEmpRole(rs.getString("empRole"));
			model.setEmp_Workexperience(rs.getInt("emp_Workexperience"));
			return model;
		}

		
    	  
      }
      
      
}
