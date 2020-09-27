package yaksha.rest_ws.diff_payslip;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee implements Comparable<Employee>{
	@Min(value = 1,message="Cannot empty or zero or negetive")
	private Integer id;
	@Size(min=2, message="Name should be atleast two chars")
	private String name;
	private Double basic;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id, @Size(min = 2, message = "Name should be atleast two chars") String name,
			Double basic) {
		super();
		this.id = id;
		this.name = name;
		this.basic = basic;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBasic() {
		return basic;
	}
	public void setBasic(Double basic) {
		this.basic = basic;
	}
	public int compareTo(Employee emp)
	{
		return this.id.compareTo(emp.id);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", basic=" + basic + "]";
	}
    
}
