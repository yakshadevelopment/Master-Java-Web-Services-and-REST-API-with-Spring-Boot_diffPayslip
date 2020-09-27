package yaksha.rest_ws.diff_payslip;

public class Payslip {
 private Integer empId;
 private String monthYear;
 private Double basic;
 private Double allownce;
 private Double gross;
 private Double pf;
 private Double tax;
 private Double net;

public Payslip() {
	super();
	// TODO Auto-generated constructor stub
}

public Payslip(Integer empId, String monthYear, Double basic, Double allownce, Double gross, Double pf, Double tax,
		Double net) {
	super();
	this.empId = empId;
	this.monthYear = monthYear;
	this.basic = basic;
	this.allownce = allownce;
	this.gross = gross;
	this.pf = pf;
	this.tax = tax;
	this.net = net;
}

public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public String getMonthYear() {
	return monthYear;
}
public void setMonthYear(String monthYear) {
	this.monthYear = monthYear;
}
public Double getBasic() {
	return basic;
}
public void setBasic(Double basic) {
	this.basic = basic;
}
public Double getAllownce() {
	return allownce;
}
public void setAllownce(Double allownce) {
	this.allownce = allownce;
}
public Double getGross() {
	return gross;
}
public void setGross(Double gross) {
	this.gross = gross;
}
public Double getPf() {
	return pf;
}
public void setPf(Double pf) {
	this.pf = pf;
}
public Double getTax() {
	return tax;
}
public void setTax(Double tax) {
	this.tax = tax;
}
public Double getNet() {
	return net;
}
public void setNet(Double net) {
	this.net = net;
}
  
}
