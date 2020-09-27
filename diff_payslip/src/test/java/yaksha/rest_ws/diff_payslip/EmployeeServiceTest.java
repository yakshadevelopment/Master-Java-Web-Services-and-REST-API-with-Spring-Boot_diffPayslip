package yaksha.rest_ws.diff_payslip;

import static org.junit.Assert.*;
import static yaksha.rest_ws.diff_payslip.TestUtils.*;
import org.junit.Test;

public class EmployeeServiceTest {

	@Test
	public void testGeneratePayslip() throws Exception {
		Employee emp1=new Employee(10,"Richie",12500.00);
		Employee emp2=new Employee(14,"Anna",27500.00);
		Payslip payslip1=new EmployeeService().generatePayslip(emp1);
		Payslip payslip2=new EmployeeService().generatePayslip(emp2);
		int x=payslip1.getNet().intValue();
		int y=payslip2.getNet().intValue();
		yakshaAssert(currentTest(),(x==18593?"true":"false"),businessTestFile);
		yakshaAssert(currentTest(),(y==33000?"true":"false"),businessTestFile);
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }

}
