package yaksha.rest_ws.diff_payslip;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
@Component
public class EmployeeService {
 public static Set<Employee> employeeSet=new TreeSet<Employee>();
 public static List<Payslip> payslipList=new ArrayList<Payslip>();
 static{
	 employeeSet.add(new Employee(10,"Richie",12500.00));
	 employeeSet.add(new Employee(12,"Steve",15000.00));
	 employeeSet.add(new Employee(11,"Mary",17500.00));
	 employeeSet.add(new Employee(15,"Mila",22500.00));
	 employeeSet.add(new Employee(13,"Lionel",21000.00));
	 employeeSet.add(new Employee(14,"Anna",27500.00));
	 employeeSet.add(new Employee(16,"Eve",29500.00));
	 employeeSet.add(new Employee(18,"Bob",21500.00));
	 employeeSet.add(new Employee(17,"Louis",25000.00));
	 employeeSet.add(new Employee(19,"Donna",16500.00));
	 employeeSet.add(new Employee(20,"Neil",11000.00));
	 
 }
 public List<Employee> findAllEmployees(){
	 List<Employee> empList=new ArrayList<Employee>(employeeSet);
	 return empList;
 }
 public boolean addEmployee(Employee employee){
	 return employeeSet.add(employee);
 }

 public Payslip generatePayslip(Employee employee){
		 Date date=new Date();
	 SimpleDateFormat sdf=new SimpleDateFormat("MMMyyyy");
	 String monthYear=sdf.format(date);
	 int id=employee.getId();
	 double basic=employee.getBasic();
	 double allownce=0.00;
	 if(basic>25000)
		 allownce=basic*0.5;
	 else if(basic>20000)
		 allownce=basic*0.65;
	 else
		 allownce=basic*0.75;
	 double gross=basic+allownce;
	 double pf=gross/10;
	 double tax=0.0;
	 if(gross<25000)
		 tax=gross*0.05;
	 else if(gross<35000)
		 tax=gross*0.075;
	 else 
		  tax=gross/10;
	  double net=gross-pf-tax;
	  return new Payslip(id,monthYear,basic,allownce,gross,pf,tax,net);
   }
  public void addPayslip(Payslip payslip){
	  payslipList.add(payslip);
  }
   public Payslip findPayslipById(int id){
	   for(Payslip payslip:payslipList)
	   {
		   if(id==payslip.getEmpId())
			   return payslip;
	   }
	   return null;
   }
   
   public Employee findEmployeeById(int id){
	   for(Employee employee:employeeSet)
	   {
		   if(id==employee.getId())
			   return employee;
	   }
	   return null;
   }
 }
 
 
 
 
 

 
 

