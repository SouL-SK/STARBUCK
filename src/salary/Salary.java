package salary;

import java.sql.Date;

public class Salary {
	private int salNo;
	private int empNo;
	private Date salDate;
	private int dalAmt;
	private String delYn;

	public Salary(int salNo, int empNo, Date salDate, int dalAmt, String delYn) {
		this.salNo = salNo;
		this.empNo = empNo;
		this.salDate = salDate;
		this.dalAmt = dalAmt;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "Salary [salNo=" + salNo + ", empNo=" + empNo + ", salDate=" + salDate + ", dalAmt=" + dalAmt
				+ ", delYn=" + delYn + "]\n";
	}
	
}
