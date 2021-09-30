package dev_menu;

import java.sql.Date;

public class DevMenu {
	private int menuNo;
	private int testCount;
	private int empNo;
	private Date devDate;
	private String delYn;

	public DevMenu(int menuNo, int testCount, int empNo, Date devDate, String delYn) {
		this.menuNo = menuNo;
		this.testCount = testCount;
		this.empNo = empNo;
		this.devDate = devDate;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "DevMenu [menuNo=" + menuNo + ", testCount=" + testCount + ", empNo=" + empNo + ", devDate=" + devDate
				+ ", delYn=" + delYn + "]\n";
	}

}
