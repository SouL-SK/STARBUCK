package tna_ma;

import java.sql.Date;

public class TnaMa {
	private int tnaNo;
	private Date attDate;
	private Date colDate;
	private int empNo;
	private String delYn;

	public TnaMa(int tnaNo, Date attDate, Date colDate, int empNo, String delYn) {
		this.tnaNo = tnaNo;
		this.attDate = attDate;
		this.colDate = colDate;
		this.empNo = empNo;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "TnaMa [tnaNo=" + tnaNo + ", attDate=" + attDate + ", colDate=" + colDate + ", empNo=" + empNo
				+ ", delYn=" + delYn + "]\n";
	}
	
}
