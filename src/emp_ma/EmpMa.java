package emp_ma;

import java.sql.Date;

public class EmpMa {
	private int empNo;
	private String empNm;
	private String empId;
	private String empPass;
	private String empGrd;
	private Date hireDate;
	private Date fireDate;
	private int stoNo;
	private String delYn;

	
	public EmpMa() {
		super();
	}

	public EmpMa(int empNo, String empNm, String empId, String empPass, String empGrd, Date hireDate, Date fireDate,
			int stoNo, String delYn) {
		this.empNo = empNo;
		this.empNm = empNm;
		this.empId = empId;
		this.empPass = empPass;
		this.empGrd = empGrd;
		this.hireDate = hireDate;
		this.fireDate = fireDate;
		this.stoNo = stoNo;
		this.delYn = delYn;
	}

	
	public EmpMa(int empNo, String empNm, String empId, String empPass) {
		this.empNo = empNo;
		this.empNm = empNm;
		this.empId = empId;
		this.empPass = empPass;
	}


	@Override
	public String toString() {
		return "EmpMa [empNo=" + empNo + ", empNm=" + empNm + ", empGrd=" + empGrd + ", hireDate=" + hireDate
				+ ", fireDate=" + fireDate + ", stoNo=" + stoNo + ", delYn=" + delYn + "]\n";
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getEmpGrd() {
		return empGrd;
	}

	public void setEmpGrd(String empGrd) {
		this.empGrd = empGrd;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getFireDate() {
		return fireDate;
	}

	public void setFireDate(Date fireDate) {
		this.fireDate = fireDate;
	}

	public int getStoNo() {
		return stoNo;
	}

	public void setStoNo(int stoNo) {
		this.stoNo = stoNo;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpPass() {
		return empPass;
	}


	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	
}
