package sto_ma;

public class StoMa {
	private int stoNo;
	private String stoNm;
	private String stoLoc;
	private int stoSeat;
	private String stoGrd;
	private String delYn;

	public StoMa(int stoNo, String stoNm, String stoLoc, int stoSeat, String stoGrd, String delYn) {
		this.stoNo = stoNo;
		this.stoNm = stoNm;
		this.stoLoc = stoLoc;
		this.stoSeat = stoSeat;
		this.stoGrd = stoGrd;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "StoMa [stoNo=" + stoNo + ", stoNm=" + stoNm + ", stoLoc=" + stoLoc + ", stoSeat=" + stoSeat
				+ ", stoGrd=" + stoGrd + ", delYn=" + delYn + "]\n";
	}

}
