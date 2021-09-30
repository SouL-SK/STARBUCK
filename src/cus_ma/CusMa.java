package cus_ma;

import java.sql.Date;

public class CusMa {
	private int cusNo;
	private String cusNm;
	private String cusId;
	private String cusPass;
	private String phone;
	private Date lastVisit;
	private String carNumOne;
	private String carNumTwo;
	private int grdNo;
	private Date appDate;
	private String delYn;

	public CusMa() {
		super();
	}
	public CusMa(int cusNo, String cusNm, String cusId, String cusPass, String phone, Date lastVisit, String carNumOne,
			String carNumTwo, int grdNo, Date appDate, String delYn) {
		super();
		this.cusNo = cusNo;
		this.cusNm = cusNm;
		this.cusId = cusId;
		this.cusPass = cusPass;
		this.phone = phone;
		this.lastVisit = lastVisit;
		this.carNumOne = carNumOne;
		this.carNumTwo = carNumTwo;
		this.grdNo = grdNo;
		this.appDate = appDate;
		this.delYn = delYn;
	}

	public CusMa(int cusNo, String cusNm, String cusId, String cusPass) {
		super();
		this.cusNo = cusNo;
		this.cusNm = cusNm;
		this.cusId = cusId;
		this.cusPass = cusPass;
	}


	
	public CusMa(int cusNo, String cusNm, String phone, Date lastVisit, String carNumOne, int grdNo, Date appDate,
			String delYn) {
		super();
		this.cusNo = cusNo;
		this.cusNm = cusNm;
		this.phone = phone;
		this.lastVisit = lastVisit;
		this.carNumOne = carNumOne;
		this.grdNo = grdNo;
		this.appDate = appDate;
		this.delYn = delYn;
	}

	public int getCusNo() {
		return cusNo;
	}

	public void setCusNo(int cusNo) {
		this.cusNo = cusNo;
	}

	public String getCusNm() {
		return cusNm;
	}

	public void setCusNm(String cusNm) {
		this.cusNm = cusNm;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCusPass() {
		return cusPass;
	}

	public void setCusPass(String cusPass) {
		this.cusPass = cusPass;
	}

	@Override
	public String toString() {
		return "CusMa [cusNo=" + cusNo + ", cusNm=" + cusNm + ", cusId=" + cusId + ", cusPass=" + cusPass + ", phone="
				+ phone + ", lastVist=" + lastVisit + ", carNUmOne=" + carNumOne + ", carNumTwo=" + carNumTwo
				+ ", grdNo=" + grdNo + ", appDate=" + appDate + ", delYn=" + delYn + "]\n";
	}

}
