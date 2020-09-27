package yaksha.rest_ws.diff_payslip;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
 @Autowired
 EmployeeService service;
 
 @GetMapping(path="/show-employees-json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> showAllEmployeesInJson(){
	
		return service.findAllEmployees();
	}
	
	@GetMapping(path="/show-employees-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Employee> showAllEmployeesInXML(){
		return service.findAllEmployees();
	}
	
	@GetMapping(path="/show-payslip/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Payslip showEmployeePayslip(@PathVariable int id){
	 Payslip payslip=service.findPayslipById(id);
	 if(payslip==null){
		 Employee employee=service.findEmployeeById(id);
		 if(employee==null)
				throw new EmployeeNotFoundException ("Employee id "+id+" not found");
		 payslip=service.generatePayslip(employee);
		 service.addPayslip(payslip);
	 }
	 return payslip;
	}
	@GetMapping(path="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee showOneEmployee(@PathVariable int id){
		Employee employee=service.findEmployeeById(id);
		if(employee==null)
			throw new EmployeeNotFoundException ("Employee id "+id+" not found");
		return employee;
		}
	@PostMapping(path="/add-employee",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String addNewEmployee(@RequestBody Employee employee){
		if(employee.getBasic()>30000 || employee.getBasic()<10000)
			throw new SalaryOutOfBoundException("Basic must be between 10000 and 30000");
		if(!service.addEmployee(employee))
			return "Duplicate Employee id, not accepted";
		else
		return "Employee Added Successfully";
	}
}
