package point;

import java.sql.Date;

import cus_ma.CusMa;

public class Point {
	private int pointNo;
	private int cusNo;
	private int accPoint;
	private Date accDate;
	private int empNo;
	private String delYn;
	private CusMa list;

	public Point(int pointNo, int cusNo, int accPoint, Date accDate, int empNo, String delYn) {
		this.pointNo = pointNo;
		this.cusNo = cusNo;
		this.accPoint = accPoint;
		this.accDate = accDate;
		this.empNo = empNo;
		this.delYn = delYn;
	}

	
	public Point(CusMa list, int accPoint, Date accDate, int empNo) {
		super();
		this.list = list;
		this.accPoint = accPoint;
		this.accDate = accDate;
		this.empNo = empNo;
	}


	@Override
	public String toString() {
		return "Point [pointNo=" + pointNo + ", cusNo=" + cusNo + ", accPoint=" + accPoint + ", accDate=" + accDate
				+ ", empNo=" + empNo + ", delYn=" + delYn + "]\n";
	}

}
