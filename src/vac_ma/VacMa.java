package vac_ma;

import java.sql.Date;

public class VacMa {
	private int vacNo;
	private int empNo;
	private String vacType;
	private Date vacDate;
	private String delYn;

	public VacMa(int vacNo, int empNo, String vacType, Date vacDate, String delYn) {
		this.vacNo = vacNo;
		this.empNo = empNo;
		this.vacType = vacType;
		this.vacDate = vacDate;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "VacMa [vacNo=" + vacNo + ", empNo=" + empNo + ", vacType=" + vacType + ", vacDate=" + vacDate
				+ ", delYn=" + delYn + "]\n";
	}
	
}
