package employee.Employee;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeConnector {
	@Autowired
	EmployeeDao dao;
	
	@GetMapping("getallemp")
	public ArrayList<EmployeeModel>getalldata(){
		return dao.getallemp();
	}
	
	@GetMapping("getdatabyid/{id}")
	public EmployeeModel getempbyid(@PathVariable int id) {
		return dao.getempbyid(id);
	}
	
	@PostMapping("insertdataofemp")
	public boolean insertemp(@RequestBody EmployeeModel model) {
		boolean status = dao.insertemployee(model);
		return status;
		
		
	}
	
	@PutMapping("updatedata/{id}")
	public EmployeeModel updateemp(@PathVariable int id , @RequestBody EmployeeModel model) {
		ArrayList<EmployeeModel>list = dao.getallemp();
		for(EmployeeModel e: list) {
			if(e.getEmpId()==id) {
				e.setEmpName(model.getEmpName());
				e.setEmpSlary(model.getEmpSlary());
				e.setEmpRole(model.getEmpRole());
				e.setEmp_Workexperience(model.getEmp_Workexperience());
				return e;
			}
		}
		return null;
		
		
	}
	
	@DeleteMapping("deletedata/{id}")
	public boolean deleteemp(@PathVariable int id) {
		boolean status = dao.deletedata(id);
		return status;
	}
	
	
}